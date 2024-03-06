/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Acer
 */
public class Product {
    private int pID;
    private String pName;
    private String pImage;
    private String pDescription;
    private double pPrice;
    private int pQuantity;

    public Product() {
    }

    public Product(int pID, String pName, String pImage, String pDescription, double pPrice, int pQuantity) {
        this.pID = pID;
        this.pName = pName;
        this.pImage = pImage;
        this.pDescription = pDescription;
        this.pPrice = pPrice;
        this.pQuantity = pQuantity;
    }

    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpImage() {
        return pImage;
    }

    public void setpImage(String pImage) {
        this.pImage = pImage;
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public double getpPrice() {
        return pPrice;
    }

    public void setpPrice(double pPrice) {
        this.pPrice = pPrice;
    }

    public int getpQuantity() {
        return pQuantity;
    }

    public void setpQuantity(int pQuantity) {
        this.pQuantity = pQuantity;
    }

    @Override
    public String toString() {
        return "Product{" + "pID=" + pID + ", pName=" + pName + ", pImage=" + pImage + ", pDescription=" + pDescription + ", pPrice=" + pPrice + '}';
    }
    
}
