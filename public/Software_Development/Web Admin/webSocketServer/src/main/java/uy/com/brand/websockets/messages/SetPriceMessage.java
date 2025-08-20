package uy.com.boxes.websockets.messages;

/**
 * Created by marcel on 21/07/16.
 */
public class SetPriceMessage extends Message {

    private double productPrice;

    public SetPriceMessage() {
        super(Type.SET_PRICE);
    }

    public SetPriceMessage(Long boxId, long productId, double productPrice) {
        super(Type.SET_PRICE);
        setProductId(productId);
        this.productPrice = productPrice;
        setBoxId(boxId);
    }

    public static Message fromJson(String json) {
        return GSON.fromJson(json, SetPriceMessage.class);
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

}
