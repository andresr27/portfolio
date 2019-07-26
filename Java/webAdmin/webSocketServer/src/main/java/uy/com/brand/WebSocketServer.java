package uy.com.brand;

import org.glassfish.tyrus.server.Server;
import java.io.*;
import java.util.Properties;
import uy.com.brand.brandEndpoint;
import java.util.concurrent.CountDownLatch;

public class WebSocketServer {
    private static final String domain = "localhost";
    private static String JDBC_URL = "localhost";

    public static final String JDBC_SQLITE_URL = "jdbc:sqlite:resources/brand.db";

    public WebSocketServer() {
        super();

        //readProperties();
    }

    public static void main(String[] args) {
        WebSocketServer server = new WebSocketServer();
        server.runServer();
    }

    private void runServer() {
        Server server = new Server("localhost", 8025, "/websockets", null, brandEndpoint.class);
//        Server server = new Server(domain, 8025, "/websockets", null, brandEndpoint.class);

        try {
            server.start();
             System.out.println("Started ok");
            //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            //System.out.print("Please press a key to stop the server.");
            //reader.readLine();

            new CountDownLatch(1).await();

        } catch (Exception e) {
            throw new RuntimeException(e);
            
        } finally {
            server.stop();
        }
    }


    private void readProperties() {

        Properties prop = new Properties();
        InputStream input = null;
        try {

            input = new FileInputStream("config.properties");
            prop.load(input);

            System.out.println(prop.getProperty("JDBC_URL"));


        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
