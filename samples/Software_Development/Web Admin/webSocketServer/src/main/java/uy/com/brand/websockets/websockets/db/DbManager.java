package uy.com.brand.websockets.websockets.db;

import uy.com.brand.api.model.Box;
import uy.com.brand.api.model.Product;
import uy.com.brand.WebSocketServer;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.logging.Logger;

/**
 * Created by Marcel on 29/07/16.
 * Edited by Andrés on 27/05/18
 */
public class DbManager {
    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    private static Logger log = Logger.getLogger(DbManager.class.getName());

    public List<Box> listbrand() {
        List<Box> found = new ArrayList<>();
        Connection c = null;
        PreparedStatement stmt = null;
        try {
            c = getConnection();
            String sql = "SELECT * FROM brand";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("boxId");
                String name = rs.getString("name");
                String locationName = rs.getString("locationName");
                String status = rs.getString("status");
		Long money = rs.getLong("money");
                String ipAddress = rs.getString("ipAddress");
                String boxType = rs.getString("boxType");
                //float salary = rs.getFloat("salary");
                Double lat = rs.getDouble("latitude");
                Double lon = rs.getDouble("longitude");
                String lastUpdated = rs.getString("lastUpdated");
		//Date lastUpdated = sdf.parse(lastUpdatedString);
		//log.info("Parsing String lastUpdated: " + lastUpdated);
                Box box = new Box(id, name, locationName, Box.Status.valueOf(status), money,ipAddress, boxType);
                box.setLatitude(lat);
                box.setLongitude(lon);
		//box.setLastUpdated(lastUpdated);

                if (lastUpdated != null) {
                    try {
                        Date lastUpdatedCal = sdf.parse(lastUpdated);
			log.info("Parsing String lastUpdated: " + lastUpdatedCal);                        
			//Calendar cc = Calendar.getInstance();
                        //cc.setTimeInMillis(lastUpdatedCal.getTime());
                        //box.setLastUpdated(cc);
			box.setLastUpdated(lastUpdatedCal); //Changed In Box.java	
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.warning("Error while parsing date: " + lastUpdated);
                    }
                }

                List<Product> products = listProducts(box.getId());
                box.setProductList(products);

                found.add(box);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }

        log.info("List brand successful. Size: " + found.size());

        return found;
    }

    public List<Product> listProducts(Long boxId) {
        List<Product> found = new ArrayList<>();
        Connection c = null;
        PreparedStatement stmt = null;
        try {
            c = getConnection();
            String sql = "SELECT * FROM products WHERE boxId = ?";
            stmt = c.prepareStatement(sql);
            stmt.setLong(1, boxId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("productId");
                String name = rs.getString("productName");
                String desc = rs.getString("productDesc");
                //float salary = rs.getFloat("salary");
                Integer productPrice = rs.getInt("productPrice");
                Integer productStock = rs.getInt("productStock");

                Product p = new Product(boxId, id, name, desc, productPrice, productStock);
                found.add(p);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        log.info("List products for box successful. Size: " + found.size());
        return found;
    }

    public Box queryBox(Long boxId) {
        Box found = null;
        Connection c = null;
        PreparedStatement stmt = null;
        try {
            c = getConnection();
            String sql = "SELECT * FROM brand WHERE boxId = ?";
            stmt = c.prepareStatement(sql);
            stmt.setLong(1, boxId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("boxId");
                String name = rs.getString("name");
                String locationName = rs.getString("locationName");
                String status = rs.getString("status");
		Long money = rs.getLong("money");
                String ipAddress = rs.getString("ipAddress");
                String boxType = rs.getString("boxType");
                //float salary = rs.getFloat("salary");
                Double lat = rs.getDouble("latitude");
                Double lon = rs.getDouble("longitude");
                String lastUpdated = rs.getString("lastUpdated");
		//Date lastUpdated = sdf.parse(lastUpdatedString);
		//log.info("Parsing String lastUpdated: " + lastUpdated);
		found = new Box(boxId, name, locationName, Box.Status.valueOf(status), money, ipAddress, boxType);

                found.setLatitude(lat);
                found.setLongitude(lon);

                //FIXME last updated
                if (lastUpdated != null) {
                    try {
                        Date lastUpdatedCal = sdf.parse(lastUpdated);
                        //Calendar cc = Calendar.getInstance();
                        //cc.setTimeInMillis(lastUpdatedCal.getTime());
                        //found.setLastUpdated(cc);
			found.setLastUpdated(lastUpdatedCal);
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.warning("Error while parsing date: " + lastUpdated);
                    }
                }
                break;
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }

        log.info("Query box successful. Found: " + String.valueOf(found != null));

        return found;
    }

    public void updateBox(Box b) {
        // Update fields
        Box currentBox = queryBox(b.getId());
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
	String timestamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(Calendar.getInstance(timeZone).getTime());
	try {
        	currentBox.setLastUpdated(sdf.parse(timestamp));           
             } 
	catch (Exception e) {
                e.printStackTrace();
        	log.warning("Error while parsing date: " + timestamp);
        }        
	currentBox.setName(b.getName());
	currentBox.setStatus(b.getStatus());
        currentBox.setMoney(b.getMoney());
	currentBox.setLocationName(b.getLocationName());
 	currentBox.setLongitude(b.getLongitude());
        currentBox.setLatitude(b.getLatitude());

        if(b.getProductList() != null)
                currentBox.setProductList(b.getProductList());

        doUpdateBox(currentBox);
    }

    private void doUpdateBox(Box b) {
        Connection c = null;
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        try {
            c = getConnection();

            String sql = "UPDATE brand SET name = ?, status = ?, money = ?, locationName = ?, ipAddress = ?, lastUpdated = ?, latitude = ?, longitude = ? WHERE boxId = ?";  //	
            stmt = c.prepareStatement(sql);

            stmt.setLong(9, b.getId());

            if (b.getName() != null)
                stmt.setString(1, b.getName());
            else log.warning("LastNameUpdated null ?");
            
                     
	    if (b.getStatus() != null) stmt.setString(2, b.getStatus().toString());
            else stmt.setString(2, Box.Status.UNKNOWN.toString());

            //if (b.getMoney() != null)
            stmt.setDouble(3, b.getMoney());

            if (b.getLocationName() != null)
                stmt.setString(4, b.getLocationName());
            
	    stmt.setString(5, b.getIpAddress());
            
	    if (b.getLastUpdated() != null)
                stmt.setString(6, sdf.format(b.getLastUpdated().getTime()));
            else {
                log.warning("LastUpdated null ?");
            }

            if (b.getLatitude() != null)
                stmt.setDouble(7, b.getLatitude());

            if (b.getLongitude() != null)
                stmt.setDouble(8, b.getLongitude());
            
	    stmt.executeUpdate();   
   

            // TODO update products 
            if (b.getProductList() !=null) {
		 String sql2 = "UPDATE products SET productName = ?, productDesc = ?, productPrice = ?, productStock = ? WHERE boxID = ? AND productID = ?";
            	for (Product p : b.getProductList()) {
                	stmt = c.prepareStatement(sql2);
                	stmt.setLong(5, b.getId());
                	stmt.setLong(6, p.getProductId());
                	stmt.setString(1, p.getProductName());
                	stmt.setString(2, p.getProductDesc());
                	stmt.setInt(3, p.getProductPrice());
                	stmt.setInt(4, p.getProductStock());

                	stmt.executeUpdate();
           	}
            
	    } else {
                log.warning("Product List null ?");
            }	
            stmt.close();
	    
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        log.info("Box updated successfully");
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection c;
        Class.forName("org.sqlite.JDBC");
        //FIXME: find a relative way to point to the db file
        c = DriverManager.getConnection(WebSocketServer.JDBC_SQLITE_URL);
        c.setAutoCommit(false);
        return c;
    }

    public void saveBox(Box b) throws SQLException, ClassNotFoundException {
        Connection c = getConnection();
        PreparedStatement stmt = null;
        final boolean oldAutoCommit = getConnection().getAutoCommit();
        c.setAutoCommit(false);

        try {
            // Your update and insert code here
            System.out.println("Opened database successfully");

            String sql = "insert into brand (boxId, name, locationName, latitude, longitude, status, ipAddress, boxType, lastUpdated) " +
                    "values (?, ?, ?, ?, ?, ?, ?, ?, ?);";
            stmt = c.prepareStatement(sql);
            stmt.setLong(1, b.getId());
            stmt.setString(2, b.getName());
            stmt.setString(3, b.getLocationName());
            if (b.getLatitude() != null)
                stmt.setDouble(4, b.getLatitude());

            if (b.getLongitude() != null)
                stmt.setDouble(5, b.getLongitude());

            stmt.setString(6, b.getStatus().toString());
            stmt.setString(7, b.getIpAddress());
            stmt.setString(8, b.getBoxType());

            //Last update time
            Calendar now = Calendar.getInstance();
            stmt.setString(9, sdf.format(now.getTime()));

            stmt.executeUpdate();

            String sql2 = "insert into products (boxId, productId, productName, productDesc, productPrice, productStock) " +
                    "values (?, ?, ?, ?, ?, ?);";
            for (Product p : b.getProductList()) {
                stmt = c.prepareStatement(sql2);
                stmt.setLong(1, b.getId());
                stmt.setLong(2, p.getProductId());
                stmt.setString(3, p.getProductName());
                stmt.setString(4, p.getProductDesc());
                stmt.setInt(5, p.getProductPrice());
                stmt.setInt(6, p.getProductStock());

                stmt.executeUpdate();
            }

            stmt.close();

        } catch(Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
            log.severe("Rolling back");
            c.rollback();
        } finally {
            c.commit();
            c.setAutoCommit(oldAutoCommit);
            c.close();
        }
        System.out.println("Records created successfully");
    }


}
