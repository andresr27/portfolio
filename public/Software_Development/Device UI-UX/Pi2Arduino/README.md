# Branded UI based on Kivy
# Vending Machine Python Client

SAMPLE CODE ONLY!

A working version of this code of the python client sending data from arduino to the JAVA Backend it's on it's way



=======

CONECTAR CLIENTE VPN


> sudo apt-get update
> sudo apt-get install openvpn


Solictar archivo de configuación (.ovpn) y copiar en la siguiente ruta:
Los archivos deben ser únicos para los distintos depositivos conectados al servico.


> sudo openvpn --config clientxxx.ovpn
> cp clientxxx.ovpn /etc/openvpn/client.conf
> sudo service openvpn start




CORRER BOX UI

Edit /etc/hosts y añadir:

18.x.x.x vpn.brand.com.uy
10.8.0.1 ws.brand.com.uy
10.8.0.1 admin.brand.com.uy

> git clone
> cd kotex
> python main.py


DESARROLLO

Antes de editar un archivo:

> git checkout test
> git pull

Despues de editar un archivo <file>

> git add <file>
> git commit -m "Commit Description"
> git push



CONECTAR UN CLIENTE A LA WEB

Solicitar otro archivo si es un nuevo dispositivo y conectar el cliente al servidor vpn.

http://admin.brand.com.uy:8080/webAdmin/#
