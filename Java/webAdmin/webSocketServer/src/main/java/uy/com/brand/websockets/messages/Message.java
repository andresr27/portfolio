package uy.com.boxes.websockets.messages;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by marcel on 15/07/16.
 */
public class Message {
    protected static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public enum Type {
        //CLIENT TO SERVER
        START,
        SET_STATUS,
        GET_BOXES,

        //SERVER TO CLIENT
        SET_PRICE,
        SET_STOCK,
        SET_MONEY,
        DISPATCH
    }

    private Type type;
    private String data;
    //private String jsonData;

    private Long boxId = null;
    private Long productId = null;


    public Message(Type type) {
        this.type = type;
    }

    public Message(Type type, Long boxId, Long productId) {
        this.type = type;
        this.boxId = boxId;
        this.productId = productId;
    }

    public Message(Type type, Long boxId) {
        this.type = type;
        this.boxId = boxId;
    }

    public String toJson() {
        return GSON.toJson(this, this.getClass());
    }

    public static Message fromJson(String json) {
        	         
	return GSON.fromJson(json, Message.class);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getBoxId() {
        return boxId;
    }

    public void setBoxId(Long boxId) {
        this.boxId = boxId;
    }
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
