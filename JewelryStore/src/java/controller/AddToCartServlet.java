/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.CartDAO;
import dal.ProductDAO;
import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Cart;
import model.Product;
import model.User;

/**
 *
 * @author Acer
 */
public class AddToCartServlet extends HttpServlet {

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
        String pID = request.getParameter("pID");
        String uID = request.getParameter("uID");
        
        
        if (uID.equals("")) {
            request.setAttribute("loginFirst", "Please login before seeing your cart!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            ProductDAO pd = new ProductDAO();
            CartDAO cad = new CartDAO();
            UserDAO ud = new UserDAO();
            int pcID = Integer.parseInt(pID);
            int ucID = Integer.parseInt(uID);
            Product p = pd.getProductByPID(pID);
            User u = ud.getUserByID(uID);
            if (cad.getAllCartByID(ucID) == null) {
                cad.insertCartByID(ucID, pcID, 1);
            } else {
                List<Cart> carts = cad.getAllCartByID(ucID);
                boolean foundProduct = false; // Flag to track if product is found in existing cart

                for (Cart item : carts) {
                    if (item.getP().getpID() == pcID) {
                        item.setQuantity(item.getQuantity() + 1);
                        session.setAttribute("a", item.getQuantity());
                        session.setAttribute("b", item.getuID());
                        session.setAttribute("c", item.getP().getpID());
                        cad.updateCartByID(item, ucID);
                        foundProduct = true;
                    }
                }

                if (!foundProduct) { // If product not found, add new entry with quantity 1
                    cad.insertCartByID(ucID, pcID, 1);
                }
            }
            List<Cart> listCart = cad.getAllCartByID(ucID);

            double totalCost = 0;
            for (Cart c : listCart) {
                totalCost += c.getP().getpPrice() * c.getQuantity();
            }
            request.setAttribute("totalCost", totalCost);

            session.setAttribute("listCart", listCart);

            request.getRequestDispatcher("cart.jsp").forward(request, response);
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
