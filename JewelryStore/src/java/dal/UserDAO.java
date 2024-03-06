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
import model.User;

/**
 *
 * @author Acer
 */
public class UserDAO extends DBContext {
    
    public User login(String user, String pass){
        String sql = "select * from Users\n"
                    + "WHERE UserName = ? AND Password = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt("UserID"),
                        rs.getString("UserName"), 
                        rs.getString("Password"), 
                        rs.getString("Fullname"), 
                        rs.getString("Email"), 
                        rs.getString("Birthday"),
                        rs.getString("Address"), 
                        rs.getString("Phone"), 
                        rs.getInt("RoleID"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;  
    }
    
    public User checkUserValid(String user){
        String sql = "select * from Users\n"
                    + "WHERE UserName = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt("UserID"),
                        rs.getString("UserName"), 
                        rs.getString("Password"), 
                        rs.getString("Fullname"),  
                        rs.getString("Email"), 
                        rs.getString("Birthday"),
                        rs.getString("Address"), 
                        rs.getString("Phone"), 
                        rs.getInt("RoleID"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;  
    }
    
    public void singup(String user, String pass, String fullName, String email, String birthday, String address, String phone){
        String sql = "INSERT INTO Users\n"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, 2)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            st.setNString(3, fullName);
            st.setString(4, email);
            st.setString(5, birthday);
            st.setNString(6, address);
            st.setString(7, phone);
            
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public List<User> getAll(){
        List<User> list = new ArrayList<>();
        String sql = "select * from Users";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new User(rs.getInt("UserID"),
                        rs.getString("UserName"), 
                        rs.getString("Password"), 
                        rs.getString("Fullname"), 
                        rs.getString("Email"), 
                        rs.getString("Birthday"),
                        rs.getString("Address"), 
                        rs.getString("Phone"), 
                        rs.getInt("RoleID")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;  
    }
    
    public User getUserByID(String id) {
        String sql = "select * from Users\n"
                    + "where UserID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getInt("UserID"),
                        rs.getString("UserName"), 
                        rs.getString("Password"),
                        rs.getNString("FullName"), 
                        rs.getString("Email"), 
                        rs.getString("Birthday"), 
                        rs.getString("Address"), 
                        rs.getString("Phone"), 
                        rs.getInt("RoleID"));
                return u;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public void insertUser(String userName, String password, String fullName, String email, String birthday, String address, String phone, String roleID){
        String sql = "insert into Users (UserName, Password, FullName, Email, Birthday, Address, Phone, RoleID)\n"
                + "values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, userName);
            st.setString(2, password);
            st.setString(3, fullName);
            st.setString(4, email);
            st.setString(5, birthday);
            st.setString(6, address);
            st.setString(7, phone);
            st.setString(8, roleID);
            st.executeUpdate();
        } catch (SQLException e) {
             System.out.println(e);
        }
    }
    
    public void editUser(String userName, String password, String fullName, String email, String birthday, String address, String phone, String roleID, String id){
        String sql = "UPDATE Users \n" +
                "SET [UserName] = ? ,\n" +
                "[Password] = ?,\n" +
                "[FullName] = ?,\n" +
                "[Email] = ?,\n" +
                "[Birthday] = ?,\n" +
                "[Address] = ?,\n" +
                "[Phone] = ?,\n" +
                "[RoleID] = ?\n" +
                "WHERE UserID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, userName);
            st.setString(2, password);
            st.setString(3, fullName);
            st.setString(4, email);
            st.setString(5, birthday);
            st.setString(6, address);
            st.setString(7, phone);
            st.setString(8, roleID);
            st.setString(9, id);
            st.executeUpdate();
        } catch (SQLException e) {
             System.out.println(e);
        }
    }
    
    public void deleteUser(String id){
        String sql = "delete from Users\n"
                    + "where UserID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
             System.out.println(e);
        }
    }
    
    public void editProfile(String userName, String fullName, String email, String birthday, String address, String phone, String id){
        String sql = "UPDATE Users\n"
                + "SET UserName = ?,\n"
                + "	FullName = ?,\n"
                + "	Email = ?,\n"
                + "	Birthday = ?,\n"
                + "	Address = ?,\n"
                + "	Phone = ?\n"
                + "WHERE UserID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, userName);
            st.setString(2, fullName);
            st.setString(3, email);
            st.setString(4, birthday);
            st.setString(5, address);
            st.setString(6, phone);
            st.setString(7, id);
            st.executeUpdate();
        } catch (SQLException e) {
             System.out.println(e);
        }
    }
    
    public void editProfilePassword(String password, String id){
        String sql = "UPDATE Users\n"
                + "SET Password = ?\n"
                + "WHERE UserID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, password);
            st.setString(2, id);
            st.executeUpdate();
        } catch (SQLException e) {
             System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        UserDAO ud = new UserDAO();
        ud.editProfilePassword("111","16");
        List<User> list = ud.getAll();
        for (User u : list){
            System.out.println(u);
        }
    }
}
