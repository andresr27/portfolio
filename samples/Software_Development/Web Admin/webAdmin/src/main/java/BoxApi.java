import uy.boxes.api.model.Box;

/**
 * Created by marcel on 07/07/16.
 */
public interface BoxApi {
    Box getData();

    void setPrice(long productId, float price);
    void setStock(long productId, int stock);
    void setMoney(float money);
    void dispatch(long productId);
}
