#!groovy

/**
 * Pipeline de Automatización para actualizacion de VM y generacion de template en catalogo 
 * @param vapp_name - Nombre de la vApp correspondiente a la VM a ser actualizada
 *
 * Pasos del pipeline
 * Paso "Encendiendo VM"
 *       Enciende la vApp en caso de no estar ya encendida
 * Paso "Aprovisionando VM"
 *       Realiza las actualizaciones de SO y software necesarias a la VM de la vApp encendida
 * Paso "Apagando VM"
 *       Apaga la vApp
 * Paso "Liberar en destino"
 *       Genera el template de la vApp correspondiente a la VM que fue actualizada, actualizando el catalogo Test
 **/

node {
	def rootDir = pwd()
	def configDir = "${env.CONFIG_DIR}"
	def tmpDir = "${env.TMP_DIR}"
        parameters{
		string(name: "vapp_name", defaultValue: "", description: "Nombre de la vApp(VM) a ser actualizada")
	}

	currentBuild.displayName = "${env.BUILD_NUMBER} - ${params.vapp_name}"
	try {
		stage('Encendiendo VM') {
			dir("${rootDir}@script/vcloud/ansible") {
 				 ansiblePlaybook( 
                                                playbook: 'powerOn.yml',
						inventory: 'hosts/inventory',
						extraVars: [
								vapp_name : "${params.vapp_name}",
								tmp_dir   : "${tmpDir}"
						])
                                }
			
		}
		stage('Aprovisionando VM') {
			dir("${rootDir}@script/aprovisionamiento/ansible") {
				ansiblePlaybook(
                                                playbook: "update_${params.vapp_name}.yml",
						inventory: 'hosts/inventory',
						extraVars: [
								vapp_name : "${params.vapp_name}",
								tmp_dir   : "${tmpDir}",
								config_dir: "${configDir}"
						])
				sh "cat ${tmpDir}/osUpdate"
				sh "touch ${tmpDir}/zbxInstall"
				sh "cat ${tmpDir}/zbxInstall"
				sh "touch ${tmpDir}/filebeatInstall"
				sh "cat ${tmpDir}/filebeatInstall"
				sh "touch ${tmpDir}/ossecInstall"
				sh "cat ${tmpDir}/ossecInstall"
			}
		}
		stage('Apagando VM') {
			dir("${rootDir}@script/vcloud/ansible") {
				ansiblePlaybook(playbook: 'powerOff.yml',
						inventory: 'hosts/inventory',
						extraVars: [
								vapp_name : "${params.vapp_name}",
								tmp_dir   : "${tmpDir}"
						])
			}
		}
		stage('Templatizando VM') {
			dir("${rootDir}@script/vcloud/ansible") {
				ansiblePlaybook(playbook: 'generate_template.yml',
						inventory: 'hosts/inventory',
						extraVars: [
								vapp_name : "${params.vapp_name}",
								tmp_dir   : "${tmpDir}",
								config_dir: "${configDir}"
						])
				ansiblePlaybook(playbook: 'cleanup.yml',
						inventory: 'hosts/inventory',
						extraVars: [
								tmp_dir: "${tmpDir}"
						])
			}
			currentBuild.result = 'SUCCESS'
		}
	} catch (Exception err) {
		dir("${rootDir}@script/vcloud/ansible") {
			ansiblePlaybook(playbook: 'generate_template.yml',
					inventory: 'hosts/inventory',
					extraVars: [
							vapp_name : "${params.vapp_name}",
							tmp_dir   : "${tmpDir}",
					                config_dir: "${configDir}"
					])
			ansiblePlaybook(playbook: 'cleanup.yml',
					inventory: 'hosts/inventory',
					extraVars: [
							tmp_dir: "${tmpDir}"
					])
		}
		currentBuild.result = 'FAILURE'
		throw err
	} finally {
		emailext body: "Se adjunta el log de la ejecucion, se accede a la ejecucion con el link ${env.BUILD_URL}", subject: "${currentBuild.result}: Actualizacion ${params.vapp_name}", to: 'Linuxantel@hg.com.uy', attachLog: true
	}
}
