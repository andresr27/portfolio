package uy.com.boxes.websockets.messages;

/**
 * Created by marcel on 21/07/16.
 */
public class SetStockMessage extends Message {
    private Integer productStock;

    public SetStockMessage(Long boxId, long productId, Integer productStock) {
        super(Type.SET_STOCK);
        setProductId(productId);
        this.productStock = productStock;
        setBoxId(boxId);
    }

    public static Message fromJson(String json) {
        return GSON.fromJson(json, SetStockMessage.class);
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

}
