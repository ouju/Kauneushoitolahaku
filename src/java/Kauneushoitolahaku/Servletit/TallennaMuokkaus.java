/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kauneushoitolahaku.Servletit;

import Kauneushoitolahaku.Mallit.Tarjonnat;
import Kauneushoitolahaku.Mallit.Tarjonta_yritys;
import Kauneushoitolahaku.Mallit.Yritykset;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Hallinnoi yrityksen tietojen muokkauksen tallentamista
 *
 * @author Outi
 */
public class TallennaMuokkaus extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        session = request.getSession(false);
        if (session.getAttribute("tunnus") == null) {
            response.sendRedirect("/Kauneushoitolahaku/kirjautuminen");
        }

        Yritykset yritys = new Yritykset();

        int id = Integer.parseInt(request.getParameter("id"));
        yritys.setId(id);
        yritys.setNimi(request.getParameter("nimi"));
        yritys.setHintataso(request.getParameter("hintataso"));
        yritys.setSijainti(request.getParameter("sijainti"));
        yritys.setOsoite(request.getParameter("osoite"));
        yritys.setKotisivut(request.getParameter("kotisivut"));
        yritys.setKuvaus(request.getParameter("kuvaus"));
        Tarjonta_yritys.nollaaYrityksenTarjonta(yritys);

        if (request.getParameter("hieronta") != null) {
            Tarjonnat tarjonta = new Tarjonnat();
            tarjonta.setId(1);
            Tarjonta_yritys.lisaa(yritys, tarjonta);
        }
        if (request.getParameter("hiukset") != null) {
            Tarjonnat tarjonta = new Tarjonnat();
            tarjonta.setId(2);
            Tarjonta_yritys.lisaa(yritys, tarjonta);
        }
        if (request.getParameter("kasvot") != null) {
            Tarjonnat tarjonta = new Tarjonnat();
            tarjonta.setId(3);
            Tarjonta_yritys.lisaa(yritys, tarjonta);
        }
        if (request.getParameter("kynnet") != null) {
            Tarjonnat tarjonta = new Tarjonnat();
            tarjonta.setId(4);
            Tarjonta_yritys.lisaa(yritys, tarjonta);
        }

        yritys.muokkaaYritysta();
        session.setAttribute("ilmoitus", "Yritystä muokattu onnistuneesti!");
        response.sendRedirect("/Kauneushoitolahaku/kirjautunut");
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
            Logger.getLogger(TallennaMuokkaus.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TallennaMuokkaus.class.getName()).log(Level.SEVERE, null, ex);
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
