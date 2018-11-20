package com.example.shane.model;

/**
 * Created by Shane on 10-Jul-18.
 */

public class Product {

    private String productName;
    private String productDate;
    private String expirationDate;
    private int producerId;

    public Product(String productName, String productDate, String expirationDate) {
        this.productName = productName;
        this.productDate = productDate;
        this.expirationDate = expirationDate;
    }



    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDate() {
        return productDate;
    }

    public void setProductDate(String productDate) {
        this.productDate = productDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getProducerId() {
        return producerId;
    }

    public void setProducerId(int producerId) {
        this.producerId = producerId;
    }
}
