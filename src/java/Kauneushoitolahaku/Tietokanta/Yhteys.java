/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kauneushoitolahaku.Tietokanta;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Ottaa yhteyden tietokantaan
 *
 * @author Outi
 */
public class Yhteys {

    /**
     *
     * @return yhteys
     * @throws SQLException
     */
    public static Connection getYhteys() throws SQLException {
        DataSource yhteysVarasto = null;
        try {
            InitialContext cxt = new InitialContext();
            yhteysVarasto = (DataSource) cxt.lookup("java:/comp/env/jdbc/tietokanta");
        } catch (NamingException ex) {
            Logger.getLogger(Yhteys.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("getting connection...");

        return yhteysVarasto.getConnection();
    }
}
