/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kauneushoitolahaku.Servletit;

import Kauneushoitolahaku.Mallit.Yritys;
import java.io.IOException;
import java.io.PrintWriter;
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
//
//    /**
//     * Processes requests for both HTTP
//     * <code>GET</code> and
//     * <code>POST</code> methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String salasana = request.getParameter("password");
//        String kayttaja = request.getParameter("username");
//
//        if (kayttaja == null || salasana == null) {
//            //naytaJSP("kirjautuminen.html", request, response);
//            return;
//        }
//
//        //Tarkistetaan että vaaditut kentät on täytetty:
//        if (kayttaja == null || kayttaja.equals("")) {
//            request.setAttribute("virheViesti", "Kirjautuminen epäonnistui! Et antanut käyttäjätunnusta.");
//            //naytaJSP("kirjautuminen.html", request, response);
//            return;
//        }
//
//        request.setAttribute("kayttaja", kayttaja);
//
//        if (salasana == null || salasana.equals("")) {
//            request.setAttribute("virheViesti", "Kirjautuminen epäonnistui! Et antanut salasanaa.");
//            //naytaJSP("kirjautuminen.html", request, response);
//            return;
//        }
//        if ("pyhakko".equals(kayttaja) && "pyhakko99".equals(salasana)) {
//            response.sendRedirect("yritys");
//        } else {
//            request.setAttribute("virheViesti", "Kirjautuminen epäonnistui! Antamasi tunnus tai salasana on väärä.");
//            request.setAttribute("kayttaja", kayttaja);
//            //naytaJSP("kirjautuminen.html", request, response);
//        }
//
//        HttpSession session = request.getSession();
//        Yritys yritys = Yritys.etsiKayttajaTunnuksilla("pyhakko", request.getParameter("salasana"));
//
//        if (yritys != null) {
//            //Tallennetaan istuntoon käyttäjäolio
//            session.setAttribute("kirjautunut", yritys);
//        }
//    }
//}
//// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
///**
// * Handles the HTTP
// * <code>GET</code> method.
// *
// * @param request servlet request
// * @param response servlet response
// * @throws ServletException if a servlet-specific error occurs
// * @throws IOException if an I/O error occurs
// */
//@Override
//        protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP
//     * <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//        protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//        public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
}
