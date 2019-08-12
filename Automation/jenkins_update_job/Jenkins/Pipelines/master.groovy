#!groovy

/**
 * Pipeline que ejecuta el job actualizacion_template para cada vApp en catalogo
 *
 * Pasos del pipeline
 * Paso "Obtener nombres de vApps"
 *       Obtiene nombres de vApps de archivo de configuración vApp_params.ini
 * Paso "Actualización template de tpl_centos_7"
 *       Ejecuta el job actualizacion_template con el valor tpl_centos_7 en el parametro vapp_name
 * Paso "Actualización template de tpl_rhel_7.5"
 *       Ejecuta el job actualizacion_template con el valor tpl_rhel_7.5 en el parametro vapp_name
 * Paso "Actualización template de tpl_win_2012"
 *       Ejecuta el job actualizacion_template con el valor tpl_win_2012 en el parametro vapp_name
 * Paso "Actualización template de tpl_win_2016"
 *       Ejecuta el job actualizacion_template con el valor tpl_win_2016 en el parametro vapp_name
 **/

node {
	def configDir = "${env.CONFIG_DIR}"
	def execFailure = false
        /*withEnv(['PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/root/bin'])*/
	try {
		stage('Obtener nombres de vApps'){
			vAppNames = []
			def lines = new File("${configDir}/vApp_params.ini").readLines()
			for (String line : lines) {
				def iniSection = (line =~ /^\[.*\]/)
				for (String str : iniSection) { // iniSections tiene 1 o 0 elementos
					vAppNames += str.replace("[","").replace("]","")
				}
			}
			println "\nvApps que serán actualizadas:"
			for (String vApp : vAppNames) {
				println vApp
			}
		}
		for (String vApp : vAppNames) {
			stage("Actualización template de ${vApp}"){			
				try {
					build job: 'actualizacion_template', parameters: [string(name: 'vapp_name', value: "${vApp}")]
					println "Se ejecutó exitosamente el job actualizacion_template para la vApp ${vApp}"    	
				} catch (Exception err) {
					println "[ERROR] La ejecución del job actualizacion_template para la vApp ${vApp} falló. Detalles en salida de job actualizacion_template"
					execFailure = true
				}
			}
		}
		if (!execFailure) {
			currentBuild.result = 'SUCCESS'
		} else {
			currentBuild.result = 'FAILURE'
		}
	} catch (Exception err) {
		currentBuild.result = 'FAILURE'
		throw err
	} finally {
		emailext body: "Se adjunta el log de la ejecucion, se accede a la ejecucion con el link ${env.BUILD_URL}", subject: "${currentBuild.result}: Ejecucion actualizaciones templates", to: ' ar@wido.com.uy', attachLog: true
	}
}
