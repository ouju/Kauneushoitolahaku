/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kauneushoitolahaku.Servletit;

import Kauneushoitolahaku.Mallit.Yritykset;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Outi
 */
public class Esittely extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        session = request.getSession(false);
        /*ArrayList<Yritykset> yritys = Yritykset.haeYritys((String)session.getAttribute("tunnus"));
        System.out.println((String)session.getAttribute("tunnus"));*/
        String idParam = request.getParameter("id");
        int id;
        try {
          id = Integer.parseInt(idParam);
        } catch(Exception e) {
          // Id-numero nolla ei käytännössä koskaan löydy kannasta, 
          // joten koodin suoritus päätyy
          // alla olevan if-lauseen else-haaraan
          id = 0;
        }
        Yritykset yritys = new Yritykset();
        yritys = yritys.haeYritysId(id);
        System.out.println(id + yritys.getOsoite());
        
//        yritys.setNimi(request.getParameter("nimi"));
//        yritys.setHintataso(request.getParameter("hintataso"));
//        yritys.setSijainti(request.getParameter("sijainti"));
//        yritys.setOsoite(request.getParameter("osoite"));
//        yritys.setKuvaus(request.getParameter("kuvaus"));
        
        request.setAttribute("yritys", yritys);
        naytaJSP("esittely.jsp", request, response);

        //response.sendRedirect("/Kauneushoitolahaku/Esittely");
    }
    
    public void naytaJSP(String sivu, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(sivu);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Esittely.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Esittely.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
