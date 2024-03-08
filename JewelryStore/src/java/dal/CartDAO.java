/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cart;
import model.Product;

/**
 *
 * @author Acer
 */
public class CartDAO extends DBContext {
    
    public List<Cart> getAllCart(int userID) {
        List<Cart> list = new ArrayList<>();
        String sql = "SELECT ca.id, p.pID, p.pName, p.pImage, p.pPrice, p.pQuantity, ca.ucID, ca.quantity FROM Cart ca"
                + " JOIN Product p ON ca.pcID = p.pID"
                + " WHERE ca.ucID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setpID(rs.getInt("pID"));
                p.setpName(rs.getString("pName"));
                p.setpImage(rs.getString("pImage"));
                p.setpPrice(rs.getDouble("pPrice"));
                p.setpQuantity(rs.getInt("pQuantity"));

                Cart c = new Cart();
                c.setCartID(rs.getInt("id"));
                c.setP(p);
                c.setuID(rs.getInt("ucID"));
                c.setQuantity(rs.getInt("quantity"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public void deleteCartByID(int ucID){
        String sql = "delete from Cart where ucID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, ucID);
            st.executeUpdate();
        } catch (SQLException e) {
             System.out.println(e);
        }
    }
    
    public List<Cart> getAllCartByID(int userID) {
        List<Cart> list = new ArrayList<>();
        String sql = "SELECT p.pID, p.pName, p.pImage, p.pPrice, p.pQuantity, ca.quantity FROM Cart ca"
                + " JOIN Product p ON ca.pcID = p.pID"
                + " WHERE ca.ucID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setpID(rs.getInt("pID"));
                p.setpName(rs.getString("pName"));
                p.setpImage(rs.getString("pImage"));
                p.setpPrice(rs.getDouble("pPrice"));
                p.setpQuantity(rs.getInt("pQuantity"));

                Cart c = new Cart();
                c.setP(p);
                c.setQuantity(rs.getInt("quantity"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void insertCartByID(int userID, int pcID, int quantity){
    String sql = "INSERT INTO Cart (ucID, pcID, quantity) VALUES (?, ?, ?)";
    try {
        PreparedStatement st = connection.prepareStatement(sql);
        st.setInt(1, userID);
        st.setInt(2, pcID);
        st.setInt(3, quantity);  
        st.executeUpdate();
    } catch (SQLException e) {
         System.out.println(e);
    }
    }
    
    public void updateCartByID(Cart c, int ucID) {
        String sql = "UPDATE Cart SET quantity = ? WHERE pcID = ? AND ucID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, c.getQuantity());
            st.setInt(2, c.getP().getpID());
            st.setInt(3, ucID);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void deleteItemByID(int id, int userID){ 
    String sql = "DELETE FROM Cart WHERE pcID = ? AND ucID = ?"; 
    try {
        PreparedStatement st = connection.prepareStatement(sql);
        st.setInt(1, id);
        st.setInt(2, userID); 
        st.executeUpdate();
    } catch (SQLException e) {
         System.out.println(e);
    }
}


    public static void main(String[] args) {
        CartDAO pd = new CartDAO();
        ProductDAO dao = new ProductDAO();
        List<Cart> list =  pd.getAllCartByID(18);
        for (Cart p : list){
            System.out.println(p);
        }
        
    }
}
