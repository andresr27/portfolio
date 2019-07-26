package uy.boxes.api.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author marcel
 */
public class Box implements Serializable {


    public enum Status {
        OK,
        ERROR,
        WARN,
        UNKNOWN,
        OFFLINE
    }

    private long id;
    private String name;
    private String locationName;
    private Double latitude;
    private Double longitude;
    private Status status;
    private String ipAddress;
    private String boxType;

    private List<Product> productList;

    private Calendar lastUpdated;

    public Box(long id, String name, String locationName, Status status, String ipAddress, String boxType) {
        this.id = id;
        this.name = name;
        this.locationName = locationName;
        this.status = status;
        this.ipAddress = ipAddress;
        this.boxType = boxType;

        productList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Box{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", locationName='" + locationName + '\'' +
                ", status=" + status +
                ", ipAddress='" + ipAddress + '\'' +
                ", boxType='" + boxType + '\'' +
                ", productList=" + productList +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getBoxType() {
        return boxType;
    }

    public void setBoxType(String boxType) {
        this.boxType = boxType;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Calendar getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Calendar lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public static Box fromJson(String json) {
        Gson GSON = new GsonBuilder().setPrettyPrinting().create();
        return GSON.fromJson(json, Box.class);
    }
}
