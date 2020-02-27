package uy.com.brand;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import uy.com.brand.api.model.Box;
import uy.com.brand.websockets.messages.*;
import uy.com.brand.websockets.websockets.db.DbManager;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Logger;

/**
 * Created by marcel on 14/07/16.
 * Edited by Andrés on 26/05/18
 */

@ServerEndpoint("/brand")
public class brandEndpoint {
    protected static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private Logger log = Logger.getLogger(this.getClass().getName());

    private static Map<String, Session> peers = Collections.synchronizedMap(new HashMap<>());
    private static Map<Long, ArrayList<String>> brandSession = Collections.synchronizedMap(new HashMap<>());

//    @Inject
    //InjectedSimpleBean bean;



    @OnOpen
    public void onOpen(Session session) throws IOException {
        peers.put(session.getId(), session);
        log.info("Session opened: " + session.getId());
        session.getBasicRemote().sendText("onOpen");
    }

    @OnMessage
    public String message(String message, Session session) {
        log.info("Message from " + session.getId()); //+ ": " + message);

        if(message != null && (message.startsWith("{") || message.startsWith("["))) {
            Message m = Message.fromJson(message);
            log.info("Received json msg of type " + m.getType());

            switch (m.getType()) {
                case SET_PRICE:
                    SetPriceMessage pm = (SetPriceMessage) SetPriceMessage.fromJson(message);
                    sendMessageToBox(m.getBoxId(), pm);
                    break;
                case DISPATCH:
		    //DispatchMessage dm = (DispatchMessage) DispatchMessage.fromJson(message);
                    Message dm = (Message) Message.fromJson(message);
	     	    log.info("Sending dispatch msg... " + dm.toString());
                    sendMessageToBox(m.getBoxId(), m);
                    break;
                case SET_MONEY:
                    MoneyMessage mm = (MoneyMessage) MoneyMessage.fromJson(message);
                    log.info("Sending money msg... " + mm.toString());
                    sendMessageToBox(m.getBoxId(), mm);
                    break;
                case SET_STOCK:
                    SetStockMessage sm = (SetStockMessage) SetStockMessage.fromJson(message);

                    sendMessageToBox(m.getBoxId(), sm);
                    break;

                // client methods
                case SET_STATUS:
                    // Save status to db or something...
                    Message statusMsg = (Message) Message.fromJson(message);
		    log.info("Sending Status msg... " + statusMsg.toString());	
                    processMessage(session, statusMsg);
                    break;

                // web methods
                case GET_brand:
                    // Save status to db or something...
                    Message brandList = querybrand();
		    //log.info( "Getting Status msg... " brandList.toJson());
                    sendMessageToRecipient(session.getId(), brandList);
                    break;
                default:
                    break;
            }
        }

        return null;
    }

    private Message querybrand() {
        DbManager db = new DbManager();
        List<Box> boxList = db.listbrand();
	
        String encoded = gson.toJson(boxList, new TypeToken<List<Box>>(){}.getType());
        Message message = new Message(Message.Type.GET_brand);
        message.setData(encoded);
	log.info("Getting Status msg... " + boxList.toString());        
	return message;

    }

    private void processMessage(Session session, Message sm) {
        log.info("Received status message type "+ sm.getType() + "from box: " + sm.getBoxId() + " session: " + session.getId() + ". Updating map...");

        if(brandSession.containsKey(sm.getBoxId()) && brandSession.get(sm.getBoxId()).size() > 0) {
            ArrayList<String> sessions = brandSession.get(sm.getBoxId());
            String previousSession = sessions.get(0);
            if(previousSession != null && previousSession.equals(session.getId())) {
                log.info("The session is already there");
            }
            else {
                log.warning(String.format("**** Active previous session found (%s) for boxId: " + sm.getBoxId() + " : " + previousSession, sessions.size()));
                sessions.add(session.getId());
            }
        }
        else {
            ArrayList<String> sessions = brandSession.get(sm.getBoxId());
            if(sessions == null)     sessions = new ArrayList<>();
            sessions.add(session.getId());
            brandSession.put(sm.getBoxId(), sessions);
        }


        // Save box to db
        DbManager db = new DbManager();
        Box box = Box.fromJson(sm.getData());
        if(box == null) {
            log.severe("Box data could not be read from message");
            return;
        }

        Box foundBox = db.queryBox(box.getId());
        if(foundBox == null) {
            log.info("Saving new box info from json data: " + box.toString());
            try {
                db.saveBox(box);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else {
            log.info("Updating box "+ box.getId() + " info from json data: " + box.toString());
            db.updateBox(box);
        }
    }

    private void sendMessageToBox(Long boxId, Message msg) {
        if(!brandSession.containsKey(boxId) || brandSession.get(boxId) == null || brandSession.get(boxId).size() == 0) {
            log.warning("Session not found for boxId: " + boxId);
            return;
        }
        String sessionId = brandSession.get(boxId).get(0);
        if(sessionId == null) {
            log.warning("Session not found for boxId: " + boxId);
            return;
        }
        log.info("Sending message to box " + boxId);
        sendMessageToRecipient(sessionId, msg);
    }

    private void sendMessageToRecipient(String recipientSessionId, Message msg) {
        Session session = peers.get(recipientSessionId);

        if(session == null) {
            log.warning("Session not found: " + recipientSessionId + ". Not sending message");
            return;
        }

        try {
            //log.info(msg.toJson());
            session.getBasicRemote().sendText(msg.toJson());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
    }

    @OnClose
    public void onClose(Session session) {
        log.info("Session close: " + session.getId());
        peers.remove(session.getId());

        Long foundKey = null;
        for (Map.Entry<Long, ArrayList<String>> entry : brandSession.entrySet()) {
            ArrayList<String> sessions = entry.getValue();
            for (String s : sessions) {
                if (Objects.equals(session.getId(), s)) {
                    sessions.remove(s);
                    foundKey = entry.getKey();
                    break;
                }
            }
        }

        if(foundKey != null) {
            log.info(String.format("Removing session id %s for box: %d", session.getId(), foundKey));
            //brandSession.remove(foundKey);
        }
        else {
            log.warning("Could not find the key for this session: " + session.getId());
        }
    }
}
