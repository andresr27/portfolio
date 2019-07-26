import uy.boxes.api.model.Box;

/**
 * Created by marcel on 07/07/16.
 */
public interface BoxesApi {
    Box updateData(Box data);

    // Maybe update data doesn't need to receive the whole box, and only inet address, etc

}
