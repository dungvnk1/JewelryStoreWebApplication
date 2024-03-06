/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.CategoryDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Category;
import model.Product;

/**
 *
 * @author Acer
 */
public class EditServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String pID = request.getParameter("id");
        String pName = request.getParameter("name");
        String pImage = request.getParameter("image");
        String pPrice = request.getParameter("price");
        String pQuantity = request.getParameter("quantity");
        String pDescription = request.getParameter("description");
        String pCategory = request.getParameter("category");
        
//        ProductDAO pd = new ProductDAO();
//        pd.editProduct(pName, pImage, pPrice, pDescription, pQuantity, pCategory, pID);
//        request.getRequestDispatcher("manageProduct").forward(request, response);
        
        
        try {
            double priceN = Double.parseDouble(pPrice);
            int quantityN = Integer.parseInt(pQuantity);
            if (priceN <= 0) {
                request.setAttribute("errPrice", "Price must be bigger than 0!");
            }
            if (quantityN <= 0) {
                request.setAttribute("errQuantity", "Quantity must be bigger than 0!");
            } 
            if (quantityN > 0 && priceN > 0){
                ProductDAO pd = new ProductDAO();
                pd.editProduct(pName, pImage, pPrice, pDescription, pQuantity, pCategory, pID);
            }
            
            request.getRequestDispatcher("manageProduct").forward(request, response);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
