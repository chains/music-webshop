/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.ctrl;

import com.chalmers.core.CD;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
public class ControlServlet extends HttpServlet {

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

        Database db = new Database();
        DBCtrl cdctrl = db.getCDController();

//        Testing purposes
//        System.out.println("Hello world");
//        CD cd = new CD(new Long(0), "Black", 90, "Rock", "Description", 300, 40, "Metallica");
//        cdctrl.create(cd);

        String action = request.getParameter("action");

        if ("viewCart".equals(action)) {
//            response.sendRedirect("/WEB-INF/jsp/viewCart.jspx");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/xhtml/viewCart.xhtml");
            rd.forward(request, response);
        } else if ("confirm".equals(action)) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/xhtml/confirm.xhtml");
            rd.forward(request, response);
        } else if ("pay".equals(action)) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/xhtml/pay.xhtml");
            rd.forward(request, response);
        } else if ("findGenre".equals(action)) {

            String genre = request.getParameter("genre");
            PrintWriter out = response.getWriter();
            StringBuilder fileData = new StringBuilder(1000);
            // Now fetch from database
            List<CD> allcd = new ArrayList<CD>();
            allcd = cdctrl.findEntities();
            
            for(CD item : allcd){
                System.out.println(item.toString());
                fileData.append("<p>" + item.toString() + "</p>");
            }

            out.println(fileData.toString());
            
            //out.println(fileData.toString());
            
            out.flush();
            out.close();

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
