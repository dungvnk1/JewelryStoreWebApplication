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
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Product;

/**
 *
 * @author Acer
 */
public class CategoryServlet extends HttpServlet {
   
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
        String cID = request.getParameter("cID");
        ProductDAO pd = new ProductDAO();
        CategoryDAO cd = new CategoryDAO();
        List<Product> list = new ArrayList<>();
        
        List<Product> listP = pd.getProductByCID(cID);
        List<Category> listC = cd.getAllCategory();
        Product lastP = pd.getLast();

        HttpSession session = request.getSession();
        session.setAttribute("listCP", listP);

        List<Product> listPP = (List<Product>) session.getAttribute("listPP");
//            if (listPP != null) {
//                for (Product pp : listPP){
//                    for (Product cp : listP){
//                        if (cp.getpID() == pp.getpID()){
//                            list.add(pp);
//                        }
//                    }
//                }
//                request.setAttribute("listP", list);
//                request.setAttribute("listC", listC);
//                request.setAttribute("lastP", lastP);
//                request.setAttribute("tag", cID);
//                request.getRequestDispatcher("home.jsp").forward(request, response);
//            } else {
//                request.setAttribute("listP", listP);
//                request.setAttribute("listC", listC);
//                request.setAttribute("lastP", lastP);
//                request.setAttribute("tag", cID);
//                request.getRequestDispatcher("home.jsp").forward(request, response);
//            }

        request.setAttribute("listP", listP);
        request.setAttribute("listC", listC);
        request.setAttribute("lastP", lastP);
        request.setAttribute("tag", cID);
        request.getRequestDispatcher("home.jsp").forward(request, response);
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
