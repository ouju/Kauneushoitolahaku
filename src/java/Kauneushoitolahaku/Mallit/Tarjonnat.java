/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kauneushoitolahaku.Mallit;

import Kauneushoitolahaku.Tietokanta.Yhteys;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Outi
 */
public class Tarjonnat {
    private String nimi;
    
    public static List<Tarjonnat> haeKaikki() throws SQLException {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;

        try {
            String sql = "SELECT * FROM yritys";
            yhteys = Yhteys.getYhteys();
            kysely = yhteys.prepareStatement(sql);
            tulokset = kysely.executeQuery();

            ArrayList<Tarjonnat> l = new ArrayList<Tarjonnat>();
            while (tulokset.next()) {
                Tarjonnat y = new Tarjonnat();
                y.setNimi(tulokset.getString("nimi"));
                l.add(y);
            }
            return l;

        } finally {
            try {
                tulokset.close();
            } catch (Exception e) {
            }
            try {
                kysely.close();
            } catch (Exception e) {
            }
            try {
                yhteys.close();
            } catch (Exception e) {
            }
        }
    }

    private void setNimi(String nimi) {
        this.nimi = nimi;
    }
}
