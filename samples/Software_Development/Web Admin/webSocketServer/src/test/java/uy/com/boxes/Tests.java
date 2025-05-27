package uy.com.boxes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import uy.com.boxes.api.model.Box;
import uy.com.boxes.api.model.Product;
import uy.com.boxes.BoxesClientEndpoint;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by marcel on 04/07/16.
 */
public class Tests {
    private static Logger log = Logger.getLogger("Tests");
    public static final String configFile = "resources/box2.json";
    protected static final String uri = "ws://localhost:8025" + "/websockets/boxes";
  @Test	public void testSocketServer() {
                

		//App classUnderTest = new App();
                //assertNotNull("app should have a greeting",
                //classUnderTest.getGreeting());

			Gson gson = new Gson();

			List<Box> boxList = new ArrayList<>();

			Box b = new Box(1, "Yerba Zara", "Presidencia", Box.Status.OK,0,"200.45.58.12","tipo 1");
			int productPrice = 20;
			int productStock = 10;
			long boxId = b.getId();
			b.getProductList().add(new Product(boxId, 1L, "Yerba Zara 200g", "Paquete de yerba zara de 200 grms. ", productPrice, productStock));
			b.getProductList().add(new Product(boxId, 2l, "Yerba Zara 100g", "Paquete de yerba zara de 100 grms. ", 12, 8));
			b.getProductList().add(new Product(boxId, 3l, "Yerba Zara 1/2 Kg", "Paquete de yerba zara de medio kilmsg. ", 40, 5));
			boxList.add(b);    
			
		
			Type listOfTestObject = new TypeToken<List<Box>>(){}.getType();
			String listJson = gson.toJson(boxList, listOfTestObject);
            //String  boxJson = gson.toJson(b, listOfTestObject);
			
            
			//BoxesClientEndpoint box = new BoxesClientEndpoint(configFile);//b.toString());
			log.info("JSON " + b.toString());
                        //box.sendMessage(b.toString());
			List<Box> list2 = gson.fromJson(listJson, listOfTestObject);
			String unpadded = "12345";

			String padded = "000000000000000000000".substring(0, 15 - unpadded.length()) + unpadded;
			log.info("Final " + padded + " largo " + padded.length());

			unpadded = "123456789";
			padded = "000000000000000000000".substring(0, 15 - unpadded.length()) + unpadded;
			log.info("Final " + padded + " largo " + padded.length());	

			
			//log.info("Message box to send " + session.getId() + ": " + message);
			log.info("Message box to send: " + b.toString()); 
			
			
 	}

}
