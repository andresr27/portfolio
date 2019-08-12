# -*- coding: utf-8 -*-
# Andres Renaud 2014-2017
import kivy
kivy.require('1.9.0')


from kivy.app import App
from kivy.uix.screenmanager import Screen
from kivy.uix.boxlayout import BoxLayout
from kivy.animation import *
from kivy.clock import Clock
from kivy.uix.video import Video
from kivy.core.image import Image
from kivy.properties import NumericProperty
from kivy.clock import Clock
from threading import Thread
import os
import admin
import boxCli
import thread

<<<<<<< HEAD:Python/Pi2Arduino/main.py
VIDEO_WIDTH			= 1130				# original 1920
VIDEO_HEIGHT		= 635				# original 1080
VIDEO_LEFT_MARGIN	= 100 + 500 + 100	# kv left margin + button width + inter button video
VIDEO_TOP_MARGIN	= 90				# kv top margin
VIDEO_SOURCE		= 'video/video.mp4'
HIDE_INFO			= - 635
SHOW_INFO			= 1080 - 635 - 100
INIT_MONEY			= 0
IMG_BUTTON_RETIRE	= [
'imagenes/boton-monto-p.png',
'imagenes/boton-monto-t.png',
'imagenes/boton-monto-s.png'
]
IMG_BUTTON			= [
'imagenes/boton-monto-p.png',
'imagenes/boton-monto-t.png',
'imagenes/boton-monto-s.png'
]
IMG_BUTTON_MONTO	= [
'imagenes/boton-monto-p.png',
'imagenes/boton-monto-t.png',
'imagenes/boton-monto-s.png'
]
IMG_BUTTON_STOCK	= [
'imagenes/boton-stock-p.png',
'imagenes/boton-stock-t.png',
'imagenes/boton-stock-s.png'
]

MAX_PROD    = 3

#messages
WELCOME          = 0
DISPACHING       = 1
NOT_MONEY        = 2
NOT_STOCK        = 3
COM_ERROR        = 5
TAKE_PROD        = 6
BLOCKED_MACHINE  = 7
UNKNOWN_ERROR    = 8
NO_SERVICE       = 10
MSG_PROD_0       = 11
MSG_PROD_1       = 12
MSG_PROD_2       = 13
BOX_INIT         = 14
OUT_STOCK        = 2

=======
>>>>>>> 18dbe4052c48e55fb9029cee6011db6953ba73dc:Python/brand-expender/main.py
class StartScreen(Screen):
	showing_info = -1
	schedule = None
	money = -1
	last_pressed = -1
	button_enable = [False, False, False]
	seted_reenable = False

	def __init__(self, **kwargs):
		super(StartScreen, self).__init__(**kwargs)
		self.reproducirVideo()
                Clock.schedule_interval(self.slowCallback, 30)
		Clock.schedule_interval(self.fastCallback, 0.5)
		self.updateMoney()

	def reproducirVideo(self):
		os.system('omxplayer --loop --no-osd -o hdmi --win "%d %d %d %d" "%s" &' %
		(VIDEO_LEFT_MARGIN, VIDEO_TOP_MARGIN, VIDEO_LEFT_MARGIN + VIDEO_WIDTH, VIDEO_TOP_MARGIN + VIDEO_HEIGHT, VIDEO_SOURCE))

	def detenerVideo(self):
		os.system('kill $(pgrep omxplayer) &')

        def buttonHandle(instance,self,button):
		print button
		print instance.button_enable[button]
		print instance.last_pressed
		print box.admin.products.getProduct(button).getStock()
		if instance.button_enable[button] and instance.last_pressed == -1 and box.admin.products.getProduct(button).getStock()!=OUT_STOCK:
			box.admin.setButton(button)
			instance.last_pressed = button
			instance.button_enable[button] = False
			instance.ids.money_count.text='Despachando producto...'
			instance.reenable = Clock.schedule_once(instance.backToWork,10)
			instance.seted_reenable = True

	def buttonInfoHandle(instance,self,button):
		if instance.showing_info == button:
			# instance.reproducirVideo()
			# instance.schedule.cancel()
			return
		if instance.showing_info == -1:
			os.system('kill $(pgrep omxplayer) &')
		else:
			instance.ids['info_%d' % instance.showing_info].pos[1] = HIDE_INFO
			instance.schedule.cancel()
		instance.ids['info_%d' % button].pos[1] = SHOW_INFO
		instance.showing_info = button
		instance.schedule = Clock.schedule_once(instance.hideInfo, 10)

	def hideInfo(self, *args):
		self.ids['info_%d' % self.showing_info]CURATED.pos[1] = HIDE_INFO
		self.showing_info = -1
		self.reproducirVideo()

	def updateMoney(self):
		self.ids.money_count.text='Ha ingresado: $ '+str(self.money)



        def setBoxAdmin(self,money,productStock,productCost):

		box.admin.money.setMoney(money)
                for i in range (box.admin.products.getLength()):
                        #print "prod_borrar" + str(i) + " stock = " + str(products[i].getStock())
                        productStock.append(products[i].getStock())
                        #print "prod_borrar" + str(i) + " cost = " + str(products[i].getCost())
                        productCost.append(products[i].getCost())



<<<<<<< HEAD:Python/Pi2Arduino/main.py



=======
>>>>>>> 18dbe4052c48e55fb9029cee6011db6953ba73dc:Python/brand-expender/main.py
        def sendStatusMsg(self):
		 statusNum = box.admin.status
                 productStock = []
                 productCost = []
		 # Status must match known statuses in webSocketServer box Class
                 # else will be Unknown
                 # Should be moved to boxCli
 		 if statusNum == 0 :
		         status = "OK"
   		 elif statusNum == 10 :
		         status = "NO_SERVICE"
		 elif statusNum == 7 :
		         status = "BLOCKED_MACHINE"
   		 else:
		         status = "WARN"
                         print "Unhandled message type"

                 money = box.admin.money.getMoney()
                 products= box.admin.products.getProducts()
		 for i in range (box.admin.products.getLength()):
		         #print "prod_borrar" + str(i) + " stock = " + str(products[i].getStock())
		         productStock.append(products[i].getStock())
			 #print "prod_borrar" + str(i) + " cost = " + str(products[i].getCost())
		         productCost.append(products[i].getCost())

                 thread.start_new_thread(boxCli.sendBoxStatus,(status,money,productStock,productCost))
                 #boxCli.sendBoxStatus(box.admin)


	def slowCallback(self,dt):
                self.sendStatusMsg()   #FIXME


	def fastCallback(self,dt):
		money=box.admin.money.getMoney()
		if box.admin.status == BLOCKED_MACHINE:
			return

		if self.money != money:
			if money < self.money and self.last_pressed != -1:
				self.ids['but_%d' % self.last_pressed].background_normal = IMG_BUTTON_RETIRE[self.last_pressed]
				self.ids['but_%d' % self.last_pressed].background_down = IMG_BUTTON_RETIRE[self.last_pressed]
				if self.seted_reenable:
					self.reenable.cancel()CURATED
				Clock.schedule_once(self.backToWork,3)
				# puede retirar el producto
			self.money = money
			self.updateMoney()

		for i in range(3):
			if self.last_pressed == -1 and box.admin.products.getProduct(i).getStock() != OUT_STOCK:
				self.ids['but_%d' % i].background_normal = IMG_BUTTON[i]
				if money >= box.admin.products.getProduct(i).getCost():
					self.button_enable[i] = True
					self.ids['but_%d' % i].background_down = IMG_BUTTON[i]
				else:
					self.button_enable[i] = False
					self.ids['but_%d' % i].background_down = IMG_BUTTON_MONTO[i]
				# hacer algo más para que el usuario note que puede pulsar el botón
			else:
				if box.admin.products.getProduct(i).getStock() == OUT_STOCK:
					self.ids['but_%d' % i].background_normal = IMG_BUTTON_STOCK[i]
					self.ids['but_%d' % i].background_down = IMG_BUTTON_STOCK[i]


	def backToWork(self,dt):
		self.last_pressed = -1
		self.updateMoney()
		self.seted_reenable = False

class BoxAdmin(Thread):
	def __init__(self):
		Thread.__init__(self)
		self.status=1
		self.admin = admin.Admin()
		self.admin.deamon=True # Kill thread

	def run(self):
		try:
			self.admin.start() # mk thread
		except Exception, e:
			self.status=6
			print('No hay comm con arduino, status:<%s>' % self.status)
		return self.admin

<<<<<<< HEAD:Python/Pi2Arduino/main.py

=======
>>>>>>> 18dbe4052c48e55fb9029cee6011db6953ba73dc:Python/brand-expender/main.py

class MainApp(App):
	def build(self):
		return StartScreen()

def initWork():
	global box
<<<<<<< HEAD:Python/Pi2Arduino/main.py
        #global cli
	box=BoxAdmin()
	box.admin=box.run()
        #boxCli.init()
        thread.start_new_thread(boxCli.init,())
=======
	box=BoxAdmin()
	box.admin=box.run()
        thread.start_new_thread(boxCli.init,()) 	 
>>>>>>> 18dbe4052c48e55fb9029cee6011db6953ba73dc:Python/brand-expender/main.py

	MainApp().run()

if __name__ == '__main__':
	initWork()
