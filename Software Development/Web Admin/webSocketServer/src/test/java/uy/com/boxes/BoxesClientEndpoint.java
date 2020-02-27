package uy.com.boxes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import uy.com.boxes.api.model.Box;
import uy.com.boxes.websockets.messages.Message;
import uy.com.boxes.websockets.messages.SetPriceMessage;
import uy.com.boxes.websockets.messages.StatusMessage;

import javax.websocket.*;
import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

@ClientEndpoint
public class BoxesClientEndpoint extends BaseClientEndpoint {

    private static Logger log = Logger.getLogger(BoxesClientEndpoint.class.getName());
    protected static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static CountDownLatch latch;
    private Box mBox;

    public BoxesClientEndpoint(String configFileName) {
        super();
        init(configFileName);
    }

    private void init(String configFileName) {
        try {
            InputStream is = getClass().getResource("/" + configFileName).openStream();        	    
            //String configJson = new String(Files.readAllBytes(Paths.get(configFileName)));
            //mBox = gson.fromJson(configJson, Box.class);
            mBox = gson.fromJson(new InputStreamReader(is), Box.class);
	    log.info("ConfigFileName info \n" + is);
	    //Message msg = new Message("START");	
            //log.info("ConfigMessage info \n" + msg.toJson());
            //super.sendMessage(msg);        
	} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    @OnOpen
    public void onOpen(Session session) {
        log.info("Connected with sessionId: " + session.getId());
        mSession = session;

        //TODO send the current status, right after connecting...
        sendMessage(new StatusMessage(mBox.getId(), Box.Status.UNKNOWN));
        log.info("Session info " + session.toString());
    }

    @OnMessage
    public String onMessage(String message, Session session) {
        log.info("Received:" + message);

        if(message == null || !(message.startsWith("{") || message.startsWith("["))) {
            log.fine("non json");
            return null;
        }
        Message m = Message.fromJson(message);
        switch (m.getType()) {
            case SET_PRICE:
                SetPriceMessage mm = (SetPriceMessage) SetPriceMessage.fromJson(message);
                setProductPrice(mm);
                break;
            case DISPATCH:
                break;
            case SET_MONEY:
                break;
            case SET_STOCK:
                break;
            default:

        }
        return null;
    }

    private void setProductPrice(SetPriceMessage msg) {
        log.warning(String.format("Setting product id: %d to price: %f", msg.getProductId(), msg.getProductPrice()));
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        log.info(String.format("Session %s close because of %s", session.getId(), closeReason));

        if(latch != null)
            latch.countDown();
    }



    public static void main(String[] args) {
        String configFileName = DEFAULT_CONFIG_FILE;
        if(args.length > 0) {
            configFileName = args[0];
            log.info("Config file included as arg: " + configFileName);
        }

        try {
            BoxesClientEndpoint endpoint = new BoxesClientEndpoint(configFileName);


            latch = new CountDownLatch(1);
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(endpoint, URI.create(uri));

            latch.await();
        } catch (DeploymentException | InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
