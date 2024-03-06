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
    public List<Cart> getAllCart() {
        List<Cart> list = new ArrayList<>();
        String sql = "select p.pID, p.pName, p.pImage, p.pPrice, p.pQuantity, ca.quantity from Cart ca\n" 
                +"join Product p on ca.pcID = p.pID";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
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
    
    public void insertCart(int pcID, int quantity){
        String sql = "insert into Cart (pcID, quantity)\n"
                + "values (?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pcID);
            st.setInt(2, quantity);  
            st.executeUpdate();
        } catch (SQLException e) {
             System.out.println(e);
        }
    }
    
    public void updateCart(Cart c){
        String sql = "UPDATE Cart SET quantity = ? WHERE pcID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, c.getQuantity());
            st.setInt(2, c.getP().getpID());
            st.executeUpdate();
        } catch (SQLException e) {
             System.out.println(e);
        }
    }
    
    public void deleteCart(){
        String sql = "delete from Cart";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
             System.out.println(e);
        }
    }
    
    public void deleteItem(int id){
        String sql = "delete from Cart where pcID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
             System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        CartDAO pd = new CartDAO();
        ProductDAO dao = new ProductDAO();
        Cart c = new Cart(20,dao.getProductByPID("3"),10+3);
        
        pd.updateCart(c);
        pd.deleteItem(20);
        List<Cart> list = pd.getAllCart(); 
        for (Cart p : list){
            System.out.println(p);
        }
        
    }
}
