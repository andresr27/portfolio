# SAMPLE ONLY
<<<<<<< HEAD:Python/Pi2Arduino/admin.py
# Andrés Renaud 2015-2017
# MVDrobotics 2014 -
=======
# Non working code
# MVDrobotics 2014 
# Andres Renaud 2015
>>>>>>> 18dbe4052c48e55fb9029cee6011db6953ba73dc:Python/brand-expender/admin.py
# This module will control behavior of product vending

import comm
import screen
import errno
import threading
import time
import os
from threading import Thread


#CONST

WELCOME          = 0
DISPACHING       = 1
NOT_MONEY        = 2
NOT_STOCK        = 3
COM_ERROR        = 5
TAKE_PROD        = 6
BLOCKED_MACHINE  = 7
UNKNOWN_ERROR    = 8
NO_SERVICE       = 10

# CURATED

class Admin(Thread):

    def __init__(self):
        Thread.__init__(self)
        self.scheduler = Scheduler()
        self.comm = comm.Comm()
        self.money = Money()
        self.status = BOX_INIT
        self.button = NO_BUTTON
        self.products = Products()

    def run(self):
        self=runBox(self)
        return self
    def getStatus(self):
        print "estado de la maquina: " + str(self.status)
        return self.status
    def setButton(self, button):
        self.button = button
        print "Se ha apretado el boton: " + str(self.button)
    def test(self, msg):
        print "log: " + msg

#this clase keeps de total amount of the money
class Money():

    def __init__(self):
        self.money = 0

    def setMoney(self, money):
        self.money = money

    def getMoney (self):
        return self.money

# Content eliminated to protect a friend's Bussiness
