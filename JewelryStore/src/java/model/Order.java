/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Acer
 */
public class Order {
    private int oID;
    private String oName;
    private String oAddress;
    private String oPhone;
    private int quantity;
    private double total;
    private Product oProduct;
    private User oUser;

    public Order() {
    }

    public Order(int oID, String oName, String oAddress, String oPhone, int quantity, double total, Product oProduct, User oUser) {
        this.oID = oID;
        this.oName = oName;
        this.oAddress = oAddress;
        this.oPhone = oPhone;
        this.quantity = quantity;
        this.total = total;
        this.oProduct = oProduct;
        this.oUser = oUser;
    }

    public int getoID() {
        return oID;
    }

    public void setoID(int oID) {
        this.oID = oID;
    }

    public String getoName() {
        return oName;
    }

    public void setoName(String oName) {
        this.oName = oName;
    }

    public String getoAddress() {
        return oAddress;
    }

    public void setoAddress(String oAddress) {
        this.oAddress = oAddress;
    }

    public String getoPhone() {
        return oPhone;
    }

    public void setoPhone(String oPhone) {
        this.oPhone = oPhone;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Product getoProduct() {
        return oProduct;
    }

    public void setoProduct(Product oProduct) {
        this.oProduct = oProduct;
    }

    public User getoUser() {
        return oUser;
    }

    public void setoUser(User oUser) {
        this.oUser = oUser;
    }

    @Override
    public String toString() {
        return "Order{" + "oID=" + oID + ", oName=" + oName + ", oAddress=" + oAddress + ", oPhone=" + oPhone + ", total=" + total + ", oProduct=" + oProduct + ", oUser=" + oUser + '}';
    }
    
    
}
