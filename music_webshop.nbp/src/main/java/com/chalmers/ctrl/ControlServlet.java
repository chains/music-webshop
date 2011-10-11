/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chalmers.ctrl;

import com.chalmers.core.CD;
import com.chalmers.core.ShoppingCart;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * OLD
 * NOT USED
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
            throws ServletException, IOException, JAXBException {
        response.setContentType("text/html;charset=UTF-8");

        Database db = new Database();
        DBCtrl cdctrl = db.getCDController();

//        Testing purposes
//        System.out.println("Hello world");
//        CD cd = new CD(new Long(0), "Album 441", 90, "Rock", "Hopplej", 300, 40, "Artist med stort R");
//        cdctrl.create(cd);

        ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new ShoppingCart();
            request.getSession().setAttribute("cart", cart);
        }


        String action = request.getParameter("action");

        if ("viewCart".equals(action)) {
//            response.sendRedirect("/WEB-INF/jsp/viewCart.jspx");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/viewCart.jspx");
            rd.forward(request, response);
        } else if ("confirm".equals(action)) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/confirm.jspx");
            rd.forward(request, response);
        } else if ("pay".equals(action)) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/pay.jspx");
            rd.forward(request, response);
        } else if ("findGenre".equals(action)) {

            response.setContentType("text/xml;charset=UTF-8");
            String genre = request.getParameter("genre");
            PrintWriter out = response.getWriter();
            List<CD> ps = cdctrl.findEntities();

            //Remove CD's with wrong genre
            Iterator<CD> it = ps.iterator();
            while (it.hasNext()) {
                CD cd = it.next();
                if (!cd.getGenre().equals(genre)) {
                    it.remove();
                }
            }

            ProductList wrapper = new ProductList(ps);
            JAXBContext jc;
            try {
                jc = JAXBContext.newInstance(ProductList.class);
                Marshaller m = jc.createMarshaller();
                m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                // Dump XML data
                m.marshal(wrapper, out);
            } catch (JAXBException ex) {
                Logger.getLogger(ControlServlet.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                out.close();
            }

//            DBCDControl cdController = (DBCDControl)db.getCDController();
//            String genre = request.getParameter("genre");
//            PrintWriter out = response.getWriter();
//            StringBuilder fileData = new StringBuilder(1000);
//            // Now fetch from database
//            List<CD> allcd = new ArrayList<CD>();
//            allcd = cdController.findEntities();

//            for (CD item : allcd) {
//                if (item.getGenre().equalsIgnoreCase(genre)) {
//                    System.out.println(item.toString());
//                    fileData.append("<p>" + item.toString() + "</p>");
//                }
//            }

//            out.println(fileData.toString());
//
//            out.flush();
//            out.close();
        }

    }

    @XmlRootElement
    static class ProductList {

        @XmlElement
        private List<CD> cdList; // name shows up in XML

        public ProductList() {
        }

        public ProductList(List<CD> cdList) {
            this.cdList = cdList;
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
        try {
            processRequest(request, response);
        } catch (JAXBException ex) {
            Logger.getLogger(ControlServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (JAXBException ex) {
            Logger.getLogger(ControlServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
