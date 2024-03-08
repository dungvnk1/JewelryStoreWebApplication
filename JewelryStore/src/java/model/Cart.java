/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Acer
 */
public class Cart {
    private int cartID;
    private Product p;
    private int uID;
    private int quantity;

    public Cart() {
        
    }

    public Cart(int cartID, Product p, int uID, int quantity) {
        this.cartID = cartID;
        this.p = p;
        this.uID = uID;
        this.quantity = quantity;
    }

    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    @Override
    public String toString() {
        return "Cart{" + cartID + "p=" + p + ", quantity=" + quantity + '}';
    }
    
    
}
