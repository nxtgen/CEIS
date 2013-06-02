/*
 * Servlet to check for user authenitcation.
 * 
 */
package com.ceis;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Authorize.AuthenticationManager;

/**
 *
 * @author j1008791
 */
public class AuthorizeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // get parameters from the request
        String email = request.getParameter("Email");
        String passwd = request.getParameter("Passwd");
        boolean isValid = false;
        String url = "";
        String message = "";
        
        
        if (!email.isEmpty() && !passwd.isEmpty())
            isValid = true;
            
        User anUser = new User(email, passwd);
        
        isValid = AuthenticationManager.Instance().Authorize(anUser);
        
        if (isValid)
            url = "/login_success.jsp";
        else {
            message = "Invalid Login/Password. Please try again";
            url = "/login_failure.jsp";
        }
        // store the User object in the session
        HttpSession session = request.getSession();
        session.setAttribute("message", message);

        RequestDispatcher dispatcher =
             getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Authentication Servlet";
    }// </editor-fold>
}
