/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kauneushoitolahaku.Servletit;

import Kauneushoitolahaku.Mallit.Tarjonnat;
import Kauneushoitolahaku.Mallit.Tarjonta_yritys;
import Kauneushoitolahaku.Mallit.Yritykset;
import java.io.IOException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Hallinnoi yrityksen lisäyssivua
 *
 * @author Outi
 */
public class Lisays extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws Exception  
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        session = request.getSession(false);
        if (session.getAttribute("tunnus") == null) {
            response.sendRedirect("/Kauneushoitolahaku/kirjautuminen");
        }
        Yritykset uusi = new Yritykset();
        
        uusi.setNimi(request.getParameter("nimi"));
        uusi.setHintataso(request.getParameter("hintataso"));
        uusi.setSijainti(request.getParameter("sijainti"));
        uusi.setOsoite(request.getParameter("osoite"));
        uusi.setKotisivut(request.getParameter("kotisivut"));
        uusi.setKuvaus(request.getParameter("kuvaus"));
        int tyontekija = (Integer) session.getAttribute("tyontekija_id");
        uusi.setTyontekija_id(tyontekija);

        if (uusi.onkoKelvollinen(uusi)) {
            int id = uusi.lisaaYritys(uusi);
            
            if (request.getParameter("hieronta") != null) {
                Tarjonnat tarjonta = new Tarjonnat();
                tarjonta.setId(1);
                Tarjonta_yritys.lisaa(uusi, tarjonta);
            }
            if (request.getParameter("hiukset") != null) {
                Tarjonnat tarjonta = new Tarjonnat();
                tarjonta.setId(2);
                Tarjonta_yritys.lisaa(uusi, tarjonta);
            }
            if (request.getParameter("kasvot") != null) {
                Tarjonnat tarjonta = new Tarjonnat();
                tarjonta.setId(3);
                Tarjonta_yritys.lisaa(uusi, tarjonta);
            }
            if (request.getParameter("kynnet") != null) {
                Tarjonnat tarjonta = new Tarjonnat();
                tarjonta.setId(4);
                Tarjonta_yritys.lisaa(uusi, tarjonta);
            }
            //Asetetaan istuntoon ilmoitus siitä, että on lisätty

            session.setAttribute("ilmoitus", "Yritys lisätty onnistuneesti.");
            //lisättiin kantaan onnistuneesti, lähetetään käyttäjä eteenpäin
            response.sendRedirect("/Kauneushoitolahaku/kirjautunut");

        } else {
            Collection<String> virheet = uusi.getVirheet();

            request.setAttribute("virheet", virheet);
            request.setAttribute("yritys", uusi);
            Apuservlet.naytaJSP("lisays.jsp", request, response);
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
        } catch (Exception ex) {
            Logger.getLogger(Lisays.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Lisays.class.getName()).log(Level.SEVERE, null, ex);
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
