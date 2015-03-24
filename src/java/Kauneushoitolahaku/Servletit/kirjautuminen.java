/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kauneushoitolahaku.Servletit;

import Kauneushoitolahaku.Mallit.Kayttaja;
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
public class kirjautuminen extends HttpServlet {

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

        String salasana = request.getParameter("password");
        String kayttaja = request.getParameter("username");
        HttpSession session = request.getSession();
        session = request.getSession(false);
        if (kayttaja.isEmpty() || kayttaja == null || salasana == null) {
            request.setAttribute("virheViesti", "Kirjautuminen epäonnistui! Et antanut käyttäjätunnusta.");
            naytaJSP("kirjautuminen.jsp", request, response);
            return;
        }

        //Tarkistetaan että vaaditut kentät on täytetty:
        if (kayttaja.isEmpty() || kayttaja == null || kayttaja.equals("")) {
            request.setAttribute("virheViesti", "Kirjautuminen epäonnistui! Et antanut käyttäjätunnusta.");
            naytaJSP("kirjautuminen.jsp", request, response);
            return;
        }



        if (salasana == null || salasana.equals("")) {
            request.setAttribute("virheViesti", "Kirjautuminen epäonnistui! Et antanut salasanaa.");
            naytaJSP("kirjautuminen.jsp", request, response);
            return;
        }
        if ("pyhakko".equals(kayttaja) && "pyhakko99".equals(salasana)) {
            request.setAttribute("kayttaja", kayttaja);
            response.sendRedirect("yritys.jsp");
        } else {
            request.setAttribute("virheViesti", "Kirjautuminen epäonnistui! Antamasi tunnus tai salasana on väärä.");
            request.setAttribute("kayttaja", kayttaja);
            naytaJSP("kirjautuminen.jsp", request, response);
        }


        Kayttaja yritys = Kayttaja.etsiKayttajaTunnuksilla("pyhakko", request.getParameter("pyhakko99"));
        if (yritys != null) {
            //Tallennetaan istuntoon käyttäjäolio
            session.setAttribute("kirjautunut", yritys);
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
            Logger.getLogger(kirjautuminen.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(kirjautuminen.class.getName()).log(Level.SEVERE, null, ex);
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
