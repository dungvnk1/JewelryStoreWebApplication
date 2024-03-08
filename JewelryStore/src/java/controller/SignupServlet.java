/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.UserDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author Acer
 */
public class SignupServlet extends HttpServlet {
   
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
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String repass = request.getParameter("repass");
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String birthday = request.getParameter("birthday");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        
        if(!pass.equals(repass)){
            request.setAttribute("errPass", "Re-password does not match with password! Please sign up again!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else if(!birthday.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")){
            request.setAttribute("errDate", "Your birthday is not in correct form (yyyy-mm-dd)! Please sign up again!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else if(!email.contains("@")){
            request.setAttribute("errMail", "Your email is invalid! Please sign up again!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else{
            UserDAO ud = new UserDAO();
            User u = ud.checkUserValid(user);
            if(u != null){
                request.setAttribute("errUser", "Username has been used! Please sign up again!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            else {
                
                ud.singup(user, pass, fullName, email, birthday, address, phone);
                request.setAttribute("successSU", "Sign up successfully! Please sign in!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
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
