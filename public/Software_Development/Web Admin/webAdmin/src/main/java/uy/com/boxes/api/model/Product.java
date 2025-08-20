package uy.boxes.api.model;

import java.io.Serializable;

/**
 * @author marcel July 2016
 */
public class Product implements Serializable {
    private long productId;
    private String productName;
    private String productDesc;
    private int productPrice;
    private int productStock;

    private Long boxId;

    public Product(Long boxId, Long productId, String productName, String productDesc, int productPrice, int productStock) {
        this.productId = productId;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.boxId = boxId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "boxId='" + boxId + '\'' +
                "productId='" + productId + '\'' +
                "productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", productPrice=" + productPrice +
                ", productStock=" + productStock +
                '}';
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public Long getBoxId() {
        return boxId;
    }

    public void setBoxId(Long boxId) {
        this.boxId = boxId;
    }
}
