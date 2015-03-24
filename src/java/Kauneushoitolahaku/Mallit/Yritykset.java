/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kauneushoitolahaku.Mallit;

import Kauneushoitolahaku.Tietokanta.Yhteys;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Outi
 */
public class Yritykset {

    private int id;
    private String nimi;
    private String hintataso;
    private String sijainti;
    private int tarjontaId;

    private Yritykset(ResultSet tulos) throws SQLException {
        tulos.getInt("id");
        tulos.getString("nimi");
        tulos.getString("hintataso");
        tulos.getString("sijainti");
        tulos.getInt("tarjontaId");
    }

    public Yritykset(int id, String nimi, String hintataso, String sijainti, int tarjontaId) {
        this.id = id;
        this.nimi = nimi;
        this.hintataso = hintataso;
        this.sijainti = sijainti;
        this.tarjontaId = tarjontaId;
    }

    /**
     * Hakee tietokannasta yksittäisen kissan id-numeron perusteella
     */
    public static Yritykset haeYritys(int id) throws Exception {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;

        try {
            String sql = "SELECT * FROM yritys WHERE id = ?";
            yhteys = Yhteys.getYhteys();
            //kysely = yhteys.getKysely(sql);
            kysely.setInt(1, id);
            tulokset = kysely.executeQuery();

            if (tulokset.next()) {
                return new Yritykset(tulokset);
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

    /**
     * Hakee tietokannasta listan yrityksiä nimen perusteella
     */
    public static List<Yritykset> haeYritykset(String nimi)
            throws Exception {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;

        try {
            String sql = "SELECT * FROM yritys WHERE nimi = ?";
            yhteys = Yhteys.getYhteys();
            //kysely = yhteys.getKysely(sql);
            kysely.setString(1, nimi);
            tulokset = kysely.executeQuery();

            ArrayList<Yritykset> l = new ArrayList<Yritykset>();
            while (tulokset.next()) {
                l.add(new Yritykset(tulokset));
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

    /**
     * Tallentaa yrityksen tietokantaan
     */
    public boolean tallenna() throws Exception {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;

        try {
            String sql = "INSERT INTO yritys(nimi, hintataso, sijainti, tarjontaId) VALUES(?,?,?, ?) RETURNING id";
            yhteys = Yhteys.getYhteys();
            //kysely = yhteys.getKysely(sql);
            kysely.setString(1, nimi);
            kysely.setString(2, hintataso);
            kysely.setString(3, sijainti);
            kysely.setInt(4, tarjontaId);
            tulokset = kysely.executeQuery();

            if (tulokset.next()) {
                id = tulokset.getInt("id");
                return true;
            } else {
                return false;
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

    /**
     * Poistaa yrityksen tietokannasta
     */
    public boolean poista() throws Exception {
        Connection yhteys = null;
        PreparedStatement kysely = null;

        try {
            String sql = "DELETE FROM yritys where id = ?";
            yhteys = Yhteys.getYhteys();
            //kysely = yhteys.getKysely(sql);
            kysely.setInt(1, id);
            return kysely.execute();
        } finally {
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

    /**
     * Getterit ja setterit
     */
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNimi() {
        return this.nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getHintataso() {
        return this.hintataso;
    }

    public void setHintataso(String hintataso) {
        this.hintataso = hintataso;
    }

    public String getSijainti() {
        return this.sijainti;
    }

    public void setSijainti(String sijainti) {
        this.sijainti = sijainti;
    }
    public int getTarjontaId() {
        return this.tarjontaId;
    }

    public void setTarjontaId(int tarjontaId) {
        this.tarjontaId = tarjontaId;
    }
}
