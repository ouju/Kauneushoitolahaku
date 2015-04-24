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

    private int id;
    private String nimi;

    public Tarjonnat() {
    }

    public Tarjonnat(ResultSet tulos) throws SQLException {
        this.id = tulos.getInt("id");
        this.nimi = tulos.getString("nimi");
    }

    public static int haeTarjontaaNimella(String nimi) throws SQLException {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;

        try {
            String sql = "SELECT id FROM tarjonta where nimi=?";
            yhteys = Yhteys.getYhteys();
            kysely = yhteys.prepareStatement(sql);
            kysely.setString(1, nimi);
            tulokset = kysely.executeQuery();

            if (tulokset.next()) {
                Tarjonnat tarjonnat = new Tarjonnat();
                tarjonnat.setId(tulokset.getInt("id"));
                tarjonnat.setNimi(tulokset.getString("nimi"));
                System.out.println("TÄTÄTÄTTÄÄ "+tarjonnat.getId());
                return tarjonnat.getId();
            } else {
                return 000;
            }

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

    public static Tarjonnat haeId(int id) throws SQLException {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;

        try {
            String sql = "SELECT * FROM tarjonta where id=?";
            yhteys = Yhteys.getYhteys();
            kysely = yhteys.prepareStatement(sql);
            kysely.setInt(1, id);
            tulokset = kysely.executeQuery();

            if (tulokset.next()) {
                return new Tarjonnat(tulokset);
            } else {
                return null;
            }

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

    public static List<Tarjonnat> haeKaikki() throws SQLException {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;

        try {
            String sql = "SELECT * FROM tarjonta";
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

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nimi
     */
    public String getNimi() {
        return nimi;
    }
}
