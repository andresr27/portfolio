#!/usr/bin/python
import json
import websocket
import thread
import time
import sys
import admin
#from  main import setBoxAdmin

JSON_FILE = 'brand_Tag.json'

#URI = "ws://localhost:8025/websockets/brand"
#URI = "ws://admin.wido.com.uy:8025/websockets/brand"
URI = "ws://ws.brand.com.uy:8025/websockets/brand"


mBox = None

class Box():
    id = 0
    name = ""
    locationName = ""
    ipAddress = ""
    boxType = ""
    ipAddress = ""

    status = ""
    money = 0
    productList = []

class Product():
    productName = ""
    productDesc = ""
    productPrice = -1
    productStock = -1

def as_box(d):
    #print "as_box",d
    if "productStock" in d:
        return d
    else:
        p = Box()
        p.__dict__.update(d)
    return p

class Message():
    type = ""
    data = None
    boxId = 0
    status = ""
    productPrice = 0
    productStock = 0
    money = 0

def as_message(d):
    p = Message()
    p.__dict__.update(d)
    return p

def getBox():
	return mBox

def sendCurrentStatus():
	sendStatusMessage(mBox)

def sendStatusMessage(box):
    if box is None:
        print "Null box. Not sentind message"
        return
    m = Message()
    m.type = "SET_STATUS"
    m.boxId = mBox.id
    m.data = json.dumps(mBox.__dict__)
    #print "Box json:" + json.dumps(mBox.__dict__)
    print "Sending status message from box: " + str(mBox.id) + " " + box.name
    send_message(m)


        

def on_message(ws, message):
    #print "Received msg: " + message
    if not message:
        print "Empty or null message"

    if not message.startswith("[") and not message.startswith("{"):
        print "non json msg"
        return

    o = json.loads(message, object_hook=as_message)
    print "Message type:" + o.type

    if o.type == "SET_PRICE":
        setProductPrice(o)
    elif o.type == "SET_STOCK":
        setProductStock(o)
    elif o.type == "DISPATCH":
        dispatchProduct(o)
    elif o.type == "SET_MONEY":
        setBoxMoney(o)
    else:
        print "Unhandled message type"

def on_error(ws, error):
    print error

def on_close(ws):
    print "### closed ###"
    time.sleep(30)
    print "Restarting connection..."
    startClient()

def on_open(ws):
    def run(*args):
        # Set Price, Stock, and Money from JsonTag
        setBoxAdmin()
        while True:
            sendCurrentStatus()
            time.sleep(120)
        ws.close()
        print "thread terminating..."
    thread.start_new_thread(run, ())
    # Post status

def changeStatusTo(newStatus):
    global mBox
    with open(JSON_FILE) as data_file:
        mBox = json.loads(data_file.read(), object_hook=as_box)
    mBox.status = newStatus
    #mBox.money = newMoney
    sendCurrentStatus()

def setBoxAdmin():
    global mBox
    productStock = []
    productCost = []
    with open(JSON_FILE) as data_file:
        mBox = json.loads(data_file.read(), object_hook=as_box)
    money=mBox.money
    for i in range(3): #FIXME 
        print "Setting Admin Stock " + str(mBox.productList[i]["productStock"]) 	
        productStock.append(mBox.productList[i]["productStock"])
    	productCost.append(mBox.productList[i]["productPrice"])
   
    setBoxAdmin(money,productStock,productCost)
      
        

def sendBoxStatus(status,money,productStock,productCost):
    global mBox
    with open(JSON_FILE) as data_file:
        mBox = json.loads(data_file.read(), object_hook=as_box)
    mBox.status = status
    mBox.money = money
    for i in range(3):
        print "Cli prod Stock " + str(productStock[i])
        mBox.productList[i-1]["productStock"] = productStock[i]
        # mBox.productList[i].productStock = productStock[i]
	
	print "Cli prod Cost " + str(productCost[i])
        mBox.productList[i-1]["productPrice"] = productCost[i]
	#mBox.productList[i].productPrice = productCost[i]

    sendCurrentStatus()


def setProductPrice(Id , price):
    global mBox
    mBox.productList[Id-1]["productPrice"]=price

def setProductStock(msg):
    #TODO setProductStock
    print "Set product id:" + str(msg.productId) + " stock to:" + str(msg.productStock)

def dispatchProduct(msg):
    #TODO dispatchProduct
    print "Dispatch product id:" + str(msg.productId)

def setBoxMoney(msg):
    print "Setting Box money to:" + str(msg.money);
    mBox.money = msg.money
    dumpBoxToJson()
    #TODO setBoxMoney on logic level


def dumpBoxToJson():
    with open(JSON_FILE, 'w') as outfile:
        json.dump(mBox.__dict__, outfile, True, 4, False)

def send_message(msg):
    try:
        print "Sending message as json:" + json.dumps(msg.__dict__)
        ws.send(json.dumps(msg.__dict__))
    except:
        print("Unexpected error:", sys.exc_info()[0])

def startClient():
    global ws
    #websocket.enableTrace(True)

    ws = websocket.WebSocketApp(URI,
                                on_message=on_message,
                                on_error=on_error,
                                on_close=on_close)
    ws.on_open = on_open
    ws.run_forever()

def init():
    
    global mBox
    with open(JSON_FILE) as data_file:
        mBox = json.loads(data_file.read(), object_hook=as_box)

    print str(mBox.id) + " " + mBox.name + " location=" + mBox.locationName + " money=" + str(mBox.money)

    # This is for when the array is defined as an array of Product
    #for p in mBox.productList:
    #    print "ProductName=" + p.productName + " ProductStock=" + str(p.productStock)

    for p in mBox.productList:
       print "ProductName=" + p["productName"] + " ProductStock=" + str(p["productStock"])

    #print mBox.__dict__

    startClient()

if __name__ == "__main__":
    init()

