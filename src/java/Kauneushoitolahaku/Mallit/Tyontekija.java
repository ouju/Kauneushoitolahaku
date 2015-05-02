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
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Outi
 */
public class Tyontekija {

    private int id;
    private String tunnus;
    private String salasana;
    private Map<String, String> virheet = new HashMap<String, String>();

    public Tyontekija() {
    }

    public static boolean tunnusKaytossa(String tunnus) throws SQLException {
        String sql = "SELECT * FROM tyontekija WHERE tunnus = ?";
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, tunnus);
        ResultSet tulokset = kysely.executeQuery();

        if (tulokset.next()) {
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
            return true;
        } else {
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
            return false;
        }
    }

    public static int etsiTunnuksella(String tunnus) throws SQLException {
        String sql = "SELECT id FROM tyontekija WHERE tunnus = ?";
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, tunnus);
        ResultSet tulokset = kysely.executeQuery();
        Tyontekija tyontekija = null;

        if (tulokset.next()) {
            tyontekija = new Tyontekija();
            tyontekija.setId(tulokset.getInt("id"));
        }

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

        return tyontekija.getId();
    }

    public int lisaaTyontekija() throws SQLException {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        //PreparedStatement kysely2 = null;
        ResultSet tulokset = null;
        //ResultSet tulokset2 = null;

        try {
            String sql = "INSERT INTO tyontekija(tunnus, salasana) VALUES(?,?) RETURNING id";
            yhteys = Yhteys.getYhteys();
            kysely = yhteys.prepareStatement(sql);

            kysely.setString(1, this.getTunnus());
            kysely.setString(2, this.getSalasana());

            tulokset = kysely.executeQuery();

            tulokset.next();
            this.setId(tulokset.getInt(1));

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
        return this.getId();
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
     * @return the tunnus
     */
    public String getTunnus() {
        return tunnus;
    }

    /**
     * @param tunnus the tunnus to set
     */
    public void setTunnus(String tunnus) throws SQLException {
        this.tunnus = tunnus;

        if (tunnus.trim().length() == 0) {
            virheet.put(tunnus, "Aseta käyttäjätunnus!");
        } else if (tunnusKaytossa(tunnus)) {
            virheet.put(tunnus, "Tunnus on jo käytössä!");
        } else {
            virheet.remove("tunnus");
        }
    }

    /**
     * @return the salasana
     */
    public String getSalasana() {
        return salasana;
    }

    /**
     * @param salasana the salasana to set
     */
    public void setSalasana(String salasana) {
        this.salasana = salasana;

        if (salasana.trim().length() == 0) {
            virheet.put(salasana, "Aseta salasana!");
        } else {
            virheet.remove("salasana");
        }
    }

    /**
     * @return the virheet
     */
    public Collection<String> getVirheet() {
        return virheet.values();
    }

    /**
     * @param virheet the virheet to set
     */
    public void setVirheet(Map<String, String> virheet) {
        this.virheet = virheet;
    }
}
