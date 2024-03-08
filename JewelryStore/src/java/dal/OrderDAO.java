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
import model.Order;
import model.Product;
import model.User;

/**
 *
 * @author Acer
 */
public class OrderDAO extends DBContext {
    public List<Order> getAllOrder() {
        List<Order> list = new ArrayList<>();
        String sql = "SELECT \n"
                + "  O.oName, \n"
                + "  O.oAddress, \n"
                + "  O.oPhone, \n"
                + "  P.pName, \n"
                + "  P.pImage, \n"
                + "  P.pPrice, \n"
                + "  O.oTotal, \n"
                + "  O.oQuantity\n"
                + "FROM [Order] AS O\n"
                + "INNER JOIN Product AS P ON O.oPID = P.pID;";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String orderName = rs.getString("oName");
                String orderAddress = rs.getString("oAddress");
                String orderPhone = rs.getString("oPhone");
                String productName = rs.getString("pName");
                String productImage = rs.getString("pImage");
                double productPrice = rs.getDouble("pPrice");
                double total = rs.getDouble("oTotal");
                int quantity = rs.getInt("oQuantity");
                
                Product p = new Product();
                p.setpName(productName);
                p.setpImage(productImage);
                p.setpPrice(productPrice);
                
                Order order = new Order();
                order.setoName(orderName);
                order.setoAddress(orderAddress);
                order.setoPhone(orderPhone);
                order.setoProduct(p);
                order.setTotal(total);
                order.setQuantity(quantity);
                list.add(order);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    
    public List<Order> getAllOrderByID(int uID) {
        List<Order> list = new ArrayList<>();
        String sql = "SELECT \n"
                + "  O.oName, \n"
                + "  O.oAddress, \n"
                + "  O.oPhone, \n"
                + "  P.pName, \n"
                + "  P.pImage, \n"
                + "  P.pPrice, \n"
                + "  O.oTotal, \n"
                + "  O.oQuantity\n"
                + "FROM [Order] AS O\n"
                + "INNER JOIN Product AS P ON O.oPID = P.pID\n"
                + "INNER JOIN Users AS U ON O.oUID = U.UserID\n"
                + "WHERE U.UserID = ?;";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, uID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String orderName = rs.getString("oName");
                String orderAddress = rs.getString("oAddress");
                String orderPhone = rs.getString("oPhone");
                String productName = rs.getString("pName");
                String productImage = rs.getString("pImage");
                double productPrice = rs.getDouble("pPrice");
                double total = rs.getDouble("oTotal");
                int quantity = rs.getInt("oQuantity");
                
                Product p = new Product();
                p.setpName(productName);
                p.setpImage(productImage);
                p.setpPrice(productPrice);
                
                User u = new User();
                u.setUserID(uID);
                
                Order order = new Order();
                order.setoName(orderName);
                order.setoAddress(orderAddress);
                order.setoPhone(orderPhone);
                order.setoProduct(p);
                order.setTotal(total);
                order.setQuantity(quantity);
                order.setoUser(u);
                list.add(order);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public void insertOrder(String name, String address, String phone, int quantity, double total, int pID, int uID){
    String sql = "INSERT INTO [Order] (oName, oAddress, oPhone, oQuantity, oTotal, oPID, oUID) VALUES (?, ?, ?, ?, ?, ?, ?)";
    try {
        PreparedStatement st = connection.prepareStatement(sql);
        st.setString(1, name);
        st.setString(2, address);
        st.setString(3, phone);
        st.setInt(4, quantity);
        st.setDouble(5, total);
        st.setInt(6, pID);
        st.setInt(7, uID);
        st.executeUpdate();
    } catch (SQLException e) {
         System.out.println(e);
    }
    }
    
    public static void main(String[] args) {
        OrderDAO od = new OrderDAO();
        List<Order> lO = (List<Order>)od.getAllOrderByID(8);
        for (Order p : lO){
            System.out.println(p.toString());
        }
        
    }
}
