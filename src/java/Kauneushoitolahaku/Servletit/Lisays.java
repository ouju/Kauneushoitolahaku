/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kauneushoitolahaku.Servletit;

import Kauneushoitolahaku.Mallit.Kirjautunut;
import Kauneushoitolahaku.Mallit.Yritykset;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
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
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        session = request.getSession(false);
        if(session.getAttribute("tunnus")==null){
            response.sendRedirect("/Kauneushoitolahaku/kirjautuminen");
        }
        //PrintWriter out = response.getWriter();
     //   try {
            Kirjautunut uusi = new Kirjautunut();
            uusi.setNimi(request.getParameter("nimi"));
            uusi.setHintataso(request.getParameter("hintataso"));
            uusi.setSijainti(request.getParameter("sijainti"));
            uusi.setOsoite(request.getParameter("osoite"));
            if (uusi.onkoKelvollinen()) {
                uusi.lisaa((String)session.getAttribute("tunnus"));

                //Asetetaan istuntoon ilmoitus siitä, että on lisätty
                
                session.setAttribute("ilmoitus", "Yritys lisätty onnistuneesti.");
                //lisättiin kantaan onnistuneesti, lähetetään käyttäjä eteenpäin
                response.sendRedirect("/Kauneushoitolahaku/kirjautunut");

            } else {
                Collection<String> virheet = uusi.getVirheet();

                request.setAttribute("virheet", virheet);
                request.setAttribute("yritys", uusi);
                naytaJSP("lisays.jsp", request, response);
            }
       // } finally {
       //     out.close();
       // }
    }
/*
    public void haeIlmoitus(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String ilmoitus = (String) session.getAttribute("ilmoitus");

        if (ilmoitus != null) {
            // Samalla kun viesti haetaan, se poistetaan istunnosta,
            // ettei se näkyisi myöhemmin jollain toisella sivulla uudestaan.
            session.removeAttribute("ilmoitus");

            request.setAttribute("ilmoitus", ilmoitus);
        }
    }
*/
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
