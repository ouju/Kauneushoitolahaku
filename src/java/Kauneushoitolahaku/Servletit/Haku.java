/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kauneushoitolahaku.Servletit;

import Kauneushoitolahaku.Mallit.Yritykset;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Outi
 */
public class Haku extends HttpServlet {

//    public void naytaJSP(String sivu, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher(sivu);
//        dispatcher.forward(request, response);
//
//    }

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

        String hakuNimella = request.getParameter("haeNimella");
        String hakuHinnalla = request.getParameter("haeHintataso");
        String hakuSijainnilla = request.getParameter("haeSijainti");
        
        List<Yritykset> y = new ArrayList();
        int lkm = 0;
        
        if (hakuNimella != null && hakuNimella.length() > 0) {
            y = Yritykset.haeNimella(hakuNimella);
        } else if (hakuSijainnilla != null && hakuSijainnilla.length() > 0) {
            y = Yritykset.haeSijainti(hakuSijainnilla);
        } else if (hakuHinnalla != null && hakuHinnalla.length() > 0) {
            y = Yritykset.haeHintataso(hakuHinnalla);
        } else if (request.getParameter("hieronta") != null) {
            y = Yritykset.haeTarjontaa(1);
        } else if (request.getParameter("hiukset") != null) {
            y = Yritykset.haeTarjontaa(2);
        } else if (request.getParameter("kasvot") != null) {
            y = Yritykset.haeTarjontaa(3);
        } else if (request.getParameter("kynnet") != null) {
            y = Yritykset.haeTarjontaa(4);
        } else {
            y = Yritykset.kaikkiYritykset();
        }
        
        if (y.isEmpty()) {
            request.setAttribute("viesti", "Yrityksiä ei löytynyt");
            Apuservlet.naytaJSP("haku.jsp", request, response);
        } else {
            lkm = y.size();
            if (lkm == 1) {
                request.setAttribute("lkm", "Haulla löytyi seuraava yritys:");
            } else {
                request.setAttribute("lkm", "Haulla löytyi seuraavat " + lkm + " yritystä:");
            }
            request.setAttribute("listaus", y);
            Apuservlet.naytaJSP("haku.jsp", request, response);
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
            Logger.getLogger(Haku.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Haku.class.getName()).log(Level.SEVERE, null, ex);
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
