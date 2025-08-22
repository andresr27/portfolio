| ⚠️  This was done more than 7 years ago and does not represent at my current documentations standard. |
|-------------------------------------------------------------------------------------------------------|
> >ssh jenkins.wido.com.uy

>cd jenkins_update_job/

>git pull

# El siguiente workflow es el que implementa el job master de Jenkins

>cd vcloud/ansible/

# Encender VM con Vapp name y datos especificados en el teplate

>ansible-playbook powerOn.yml -i hosts/inventory -e vapp_name=rhel_7_template -e tmp_dir=/var/lib/jenkins/tmp --vault-password-file /var/lib/jenkins/.vaultkey

>cd ../aprovisionamiento/ansible/

# Aprovisionar host OS

>ansible-playbook update_rhel_7_template.yml  -i hosts/inventory --vault-password-file /var/lib/jenkins/.vaultkey --list-hosts

>cd-

# Apagar VM

>ansible-playbook powerOff.yml -i hosts/inventory -e vapp_name=rhel_7_template -e tmp_dir=/var/lib/jenkins/tmp --vault-password-file /var/lib/jenkins/.vaultkey

## PENDIENTES

- Crear VM a partir del template a actualizar, previo a prender
- Guarda VM como templaate luego de actulizar y prender
