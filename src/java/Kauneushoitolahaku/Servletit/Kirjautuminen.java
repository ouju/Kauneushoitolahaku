/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kauneushoitolahaku.Servletit;

import Kauneushoitolahaku.Mallit.Kirjautunut;
import java.io.IOException;
import java.io.PrintWriter;
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
public class Kirjautuminen extends HttpServlet {

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
    public void naytaJSP(String sivu, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(sivu);
        dispatcher.forward(request, response);

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String tunnus = request.getParameter("tunnus");
        String salasana = request.getParameter("salasana");
        HttpSession session = request.getSession();
        session = request.getSession(false);
//        if (tunnus == null || tunnus.isEmpty() || salasana == null) {
//            request.setAttribute("virheViesti", "Kirjautuminen epäonnistui! Et antanut käyttäjätunnusta.");
//            naytaJSP("kirjautuminen.jsp", request, response);
//            return;
//        }

        //Tarkistetaan että vaaditut kentät on täytetty:
        if ( tunnus == null ||tunnus.isEmpty() || tunnus.equals("")) {
            request.setAttribute("virheViesti", "Kirjaudu sisään antamalla käyttäjätunnus ja salasana!");
            naytaJSP("kirjautuminen.jsp", request, response);
            return;
        }



        if (salasana == null || salasana.equals("")) {
            request.setAttribute("virheViesti", "Kirjautuminen epäonnistui! Et antanut salasanaa.");
            naytaJSP("kirjautuminen.jsp", request, response);
            return;
        } 


        boolean yritys = Kirjautunut.tunnusJaSalasanaOikein(request.getParameter("tunnus"), request.getParameter("salasana"));
        if (yritys) {
            //Tallennetaan istuntoon käyttäjäolio
            session.setAttribute("tunnus", tunnus);
            response.sendRedirect("/Kauneushoitolahaku/kirjautunut");
        }else {
            request.setAttribute("virheViesti", "Kirjautuminen epäonnistui! Antamasi tunnus tai salasana on väärä.");
            //request.setAttribute("kayttaja", kayttaja);
            naytaJSP("kirjautuminen.jsp", request, response);
        }
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
        } catch (SQLException ex) {
            Logger.getLogger(Kirjautuminen.class.getName()).log(Level.SEVERE, null, ex);
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
     *
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Kirjautuminen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     *
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
