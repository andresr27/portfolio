# SAMPLE ONLY
# CURATED
# MVDrobotics 2014
# This module will control communication beween raspberry pi and MVDrobotics Arduino Shield (mvdShield)

#CONST
BOARD_PORT = "/dev/ttyACM0"
SPEED      = 115200
TIMEOUT    = 1
SYNC       = 254                  #byte de comienzo de los mensajes seriales
ESCAPE     = 253                #byte de desambiguacion en los mensajes seriales
BROADCAST  = 255   

#ESTADOS
BUSCAR, LEER_LARGO, LEER_MSG, CHECKSUM = range (0,4) #set automaticaly values to our state variables

import serial
import errno
import struct
import time    #SACAR!!
import admin

class Comm():
    
  #CURATED
