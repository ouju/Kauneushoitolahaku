/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kauneushoitolahaku.Servletit;

import Kauneushoitolahaku.Mallit.Tyontekija;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Hallinnoi työntekijän tunnusten muokkausta
 *
 * @author Outi
 */
public class TunnustenMuokkaus extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws SQLException 
     * @throws Exception  
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, Exception {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        session = request.getSession(false);
        if (session.getAttribute("tunnus") == null) {
            response.sendRedirect("/Kauneushoitolahaku/kirjautuminen");
        }

        Tyontekija tyontekija = new Tyontekija();

        int id = (Integer) session.getAttribute("tyontekija_id");
        String tunnus = (String) session.getAttribute("tunnus");
        tyontekija.setId(id);
        tyontekija.setTunnus(request.getParameter("tunnus"));
        tyontekija.setSalasana(request.getParameter("salasana"));

        if (tyontekija.getTunnus() != null && !tyontekija.getTunnus().isEmpty()
                && tyontekija.getSalasana() != null && !tyontekija.getSalasana().isEmpty()
                && (tyontekija.getTunnus().equals(tunnus) || !Tyontekija.tunnusKaytossa(tyontekija.getTunnus()))) {
            tyontekija.muokkaaTunnuksia();
            session.setAttribute("ilmoitus", "Tunnuksia muokattu onnistuneesti.");
            response.sendRedirect("/Kauneushoitolahaku/kirjautunut");
        } else {
            Collection<String> virheet = tyontekija.getVirheet();

            request.setAttribute("virheet", virheet);
            request.setAttribute("yritys", tyontekija);
            Apuservlet.naytaJSP("omatTiedot.jsp", request, response);
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
            Logger.getLogger(TunnustenMuokkaus.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TunnustenMuokkaus.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TunnustenMuokkaus.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TunnustenMuokkaus.class.getName()).log(Level.SEVERE, null, ex);
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
