/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kauneushoitolahaku.Servletit;

import Kauneushoitolahaku.Mallit.Tarjonnat;
import Kauneushoitolahaku.Mallit.Tarjonta_yritys;
import Kauneushoitolahaku.Mallit.Yritykset;
import java.io.IOException;
import java.sql.SQLException;
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
public class Tarjonta extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
//        HttpSession session = request.getSession();
//        session = request.getSession(false);
//        
//        String idParam = request.getParameter("id");
//        int id;
//        try {
//            id = Integer.parseInt(idParam);
//        } catch (Exception e) {
//            id = 0;
//        }
//        
//        Yritykset yritys = new Yritykset();
//        
//        yritys.setId(id);
//        
//        yritys.setNimi(request.getParameter("nimi"));
//        yritys.setHintataso(request.getParameter("hintataso"));
//        yritys.setSijainti(request.getParameter("sijainti"));
//        yritys.setOsoite(request.getParameter("osoite"));
//        yritys.setKuvaus(request.getParameter("kuvaus"));
//        //yritys.setTarjonta_id(Integer.parseInt(request.getParameter("tarjonta_id")));
//        request.setAttribute("yritys", yritys);
//        request.setAttribute("tarjonnat", Tarjonta_yritys.haeYrityksenTarjonta(yritys));
//        //request.setAttribute("tarjonnat", Tarjonnat.haeKaikki());
//        naytaJSP("esittely.jsp", request, response);
    }
    
//    public void naytaJSP(String sivu, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher(sivu);
//        dispatcher.forward(request, response);
//    }

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
        } catch (SQLException ex) {
            Logger.getLogger(Tarjonta.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(Tarjonta.class.getName()).log(Level.SEVERE, null, ex);
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
