/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.CartDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Cart;

/**
 *
 * @author Acer
 */
public class AddQuantityCartServlet extends HttpServlet {
   
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
        int ucID = Integer.parseInt(uID);
        CartDAO cad = new CartDAO();
        ProductDAO pd = new ProductDAO();
        List<Cart> carts = cad.getAllCartByID(ucID);
        try {
            int pcID = Integer.parseInt(pID);

            for (Cart item : carts) {
                if (item.getP().getpID() == pcID) {
                    if (item.getQuantity() < pd.getProductByPID(pID).getpQuantity()) {
                        item.setQuantity(item.getQuantity() + 1);
                        cad.updateCartByID(item,ucID);
                    } else {
                        request.setAttribute("errNum", "We don't have any more items left!");
                    }
                }
            }

            double totalCost = 0;
            for (Cart c : carts) {
                totalCost += c.getP().getpPrice() * c.getQuantity();
            }
            request.setAttribute("totalCost", totalCost);

            request.setAttribute("listCart", carts);
            request.getRequestDispatcher("cart.jsp").forward(request, response);
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
