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
import model.Product;

/**
 *
 * @author Acer
 */
public class ProductDAO extends DBContext {
    
    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt("pID"),rs.getString("pName"), rs.getString("pImage"), rs.getString("pDescription"), rs.getDouble("pPrice"), rs.getInt("pQuantity"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public Product getLast(){
        String sql = "select top 1 * from Product\n"
                    + "order by pID desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt("pID"),rs.getString("pName"), rs.getString("pImage"), rs.getString("pDescription"), rs.getDouble("pPrice"), rs.getInt("pQuantity"));     
            }
        } catch (SQLException e) {
            System.out.println(e);
        } 
        return null;
    }
    
    public List<Product> getProductByCID(String cID) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product\n"
                    + "where cateID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt("pID"),rs.getString("pName"), rs.getString("pImage"), rs.getString("pDescription"), rs.getDouble("pPrice"), rs.getInt("pQuantity"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public Product getProductByPID(String pID) {
        String sql = "select * from Product\n"
                    + "where pID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, pID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt("pID"),rs.getString("pName"), rs.getString("pImage"), rs.getString("pDescription"), rs.getDouble("pPrice"), rs.getInt("pQuantity"));
                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public List<Product> searchByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product\n"
                    + "where pName like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + txtSearch + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt("pID"),rs.getString("pName"), rs.getString("pImage"), rs.getString("pDescription"), rs.getDouble("pPrice"), rs.getInt("pQuantity"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public void deleteProduct(String pID){
        String sql = "delete from Product\n"
                    + "where pID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, pID);
            st.executeUpdate();
        } catch (SQLException e) {
             System.out.println(e);
        }
    }
    
    public void insertProduct(String name, String image, String price, String quantity, String description, String category){
        String sql = "insert into Product (pName, pImage, pPrice, pQuantity, pDescription, cateID)\n"
                + "values (?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, image);
            st.setString(3, price);            
            st.setString(4, quantity);            
            st.setString(5, description);
            st.setString(6, category);
            st.executeUpdate();
        } catch (SQLException e) {
             System.out.println(e);
        }
    }
    
    public void editProduct(String name, String image, String price, String description, String quantity, String category, String id){
        String sql = "UPDATE [dbo].[Product]\n"
                + "   SET [pName] = ?\n"
                + "      ,[pImage] = ?\n"
                + "      ,[pDescription] = ?\n"
                + "      ,[pPrice] = ?\n"
                + "      ,[pQuantity] = ?\n"
                + "      ,[cateID] = ?\n"
                + " WHERE pID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, image);
            st.setString(3, description);
            st.setString(4, price);
            st.setString(5, quantity);            
            st.setString(6, category);
            st.setString(7, id);
            st.executeUpdate();
        } catch (SQLException e) {
             System.out.println(e);
        }
    }
    
    public List<Product> filterByPrice(String minP, String maxP) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product\n"
                    + "where pPrice between ? and ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, minP);
            st.setString(2, maxP);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt("pID"),rs.getString("pName"), rs.getString("pImage"), rs.getString("pDescription"), rs.getDouble("pPrice"), rs.getInt("pQuantity"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    } 
    
    public int getNumberPage(){
        String sql = "select count(*) from Product";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);
                int countPage = 0;
                countPage = total/6;
                if(total%6!=0){
                    countPage++;
                }
                return countPage;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }
    
    public List<Product> getPaging(int index) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Product\n" +
                        "order by pID\n" +
                        "OFFSET ? ROWS\n" +
                        "FETCH FIRST 6 ROWS ONLY";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, (index-1)*6);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt("pID"),rs.getString("pName"), rs.getString("pImage"), rs.getString("pDescription"), rs.getDouble("pPrice"), rs.getInt("pQuantity"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public int getTotalProduct(){
        String sql = "select sum(pQuantity) from Product";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);
                return total;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }
    
    public String getMinNumberProduct(){
        String sql = "SELECT pName\n" +
                        "FROM Product\n" +
                        "WHERE pQuantity = (SELECT MIN(pQuantity) FROM Product);";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String p = rs.getString(1);
                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public String getMaxNumberProduct(){
        String sql = "SELECT pName\n" +
                        "FROM Product\n" +
                        "WHERE pQuantity = (SELECT MAX(pQuantity) FROM Product);";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String p = rs.getString(1);
                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
//    public void updateProduct() {
//        String sql = "UPDATE Product\n"
//                + "SET pQuantity = pQuantity - (\n"
//                + "    SELECT quantity\n"
//                + "    FROM Cart\n"
//                + "    WHERE Product.pID = Cart.pcID\n"
//                + ")\n"
//                + "WHERE pID IN (\n"
//                + "    SELECT pcID\n"
//                + "    FROM Cart\n"
//                + ");";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            
//            st.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }
    
    public void updateProduct(int userID) {
        String sql = "UPDATE Product\n"
                + "SET pQuantity = pQuantity - (\n"
                + "    SELECT quantity\n"
                + "    FROM Cart\n"
                + "    WHERE Product.pID = Cart.pcID AND Cart.ucID = ?\n"
                + ")\n"
                + "WHERE pID IN (\n"
                + "    SELECT pcID\n"
                + "    FROM Cart\n"
                + "    WHERE Cart.ucID = ?\n"
                + ");";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userID);
            st.setInt(2, userID);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    
    public void deleteProductItem(){
        String sql = "delete from Product\n"
                    + "where pQuantity < 1";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
             System.out.println(e);
        }
    }
    
//    public List<Product> productFilter(String cID, String minP, String maxP){
//        List<Product> list = new ArrayList<>();
//        String sql = "select * from Product\n"
//                    + "where cateID = ? and pPrice between ? and ?";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setString(1, cID);
//            st.setString(2, minP);
//            st.setString(3, maxP);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                Product p = new Product(rs.getInt("pID"),rs.getString("pName"), rs.getString("pImage"), rs.getString("pDescription"), rs.getDouble("pPrice"));
//                list.add(p);
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return list;
//    }
    
    public static void main(String[] args) {
        ProductDAO pd = new ProductDAO();
        List<Product> list = pd.getAllProduct();
        for (Product p : list){
            System.out.println(p);
        }
        System.out.println(pd.getMinNumberProduct());
    }
}
