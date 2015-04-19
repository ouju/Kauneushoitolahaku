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
import javax.naming.NamingException;

/**
 *
 * @author Outi
 */
public class Yritykset {

    private int id;
    private String nimi;
    private String tunnus;
    private String hintataso;
    private String osoite;
    private String sijainti;
    private String kuvaus;
    private int tarjontaId;

    public Yritykset() {
    }

    public Yritykset(ResultSet tulos) throws SQLException {
        this.id = tulos.getInt("id");
        this.nimi = tulos.getString("nimi");
        this.hintataso = tulos.getString("hintataso");
        this.sijainti = tulos.getString("sijainti");
        this.osoite = tulos.getString("osoite");
        this.kuvaus = tulos.getString("kuvaus");
        this.tarjontaId = tulos.getInt("tarjonta_id");
    }

    public Yritykset(int id, String nimi, String hintataso, String sijainti, int tarjontaId) {
        this.id = id;
        this.nimi = nimi;
        this.hintataso = hintataso;
        this.sijainti = sijainti;
        this.tarjontaId = tarjontaId;
    }

    public Yritykset(String nimi, String tunnus, String hintataso, String sijainti, String osoite) {

        this.nimi = nimi;
        this.tunnus = tunnus;
        this.hintataso = hintataso;
        this.sijainti = sijainti;
        this.osoite = osoite;
    }
    
    public Yritykset(String nimi, String tunnus, String hintataso, String sijainti, String osoite, String kuvaus) {

        this.nimi = nimi;
        this.tunnus = tunnus;
        this.hintataso = hintataso;
        this.sijainti = sijainti;
        this.osoite = osoite;
        this.kuvaus = kuvaus;
    }

    public Yritykset haeYritysId(int id) throws Exception {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;

        try {
            String sql = "SELECT * FROM yritys WHERE id = ?";
            yhteys = Yhteys.getYhteys();
            kysely = yhteys.prepareStatement(sql);
            kysely.setInt(1, id);
            tulokset = kysely.executeQuery();

            if (tulokset.next()) {
                System.out.println(tulokset.getString("kuvaus"));
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
    public static List<Yritykset> haeNimella(String nimi)
            throws Exception {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;

        try {
            String sql = "SELECT * FROM yritys WHERE nimi = ? ORDER BY nimi";
            yhteys = Yhteys.getYhteys();
            kysely = yhteys.prepareStatement(sql);
            kysely.setString(1, nimi);
            tulokset = kysely.executeQuery();

            ArrayList<Yritykset> l = new ArrayList<Yritykset>();
            while (tulokset.next()) {
                Yritykset y = new Yritykset();
                y.setId(tulokset.getInt("id"));
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
    
    public static List<Yritykset> haeSijainti(String sijainti)
            throws Exception {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;

        try {
            String sql = "SELECT * FROM yritys WHERE sijainti = ? ORDER BY nimi";
            yhteys = Yhteys.getYhteys();
            kysely = yhteys.prepareStatement(sql);
            kysely.setString(1, sijainti);
            tulokset = kysely.executeQuery();

            ArrayList<Yritykset> lista = new ArrayList<Yritykset>();
            while (tulokset.next()) {
                Yritykset y = new Yritykset();
                y.setId(tulokset.getInt("id"));
                y.setNimi(tulokset.getString("nimi"));
                lista.add(y);
            }
            return lista;

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
    
    public static List<Yritykset> haeHintataso(String hintataso)
            throws Exception {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;

        try {
            String sql = "SELECT * FROM yritys WHERE hintataso = ? ORDER BY nimi";
            yhteys = Yhteys.getYhteys();
            kysely = yhteys.prepareStatement(sql);
            kysely.setString(1, hintataso);
            tulokset = kysely.executeQuery();

            ArrayList<Yritykset> lista = new ArrayList<Yritykset>();
            while (tulokset.next()) {
                Yritykset y = new Yritykset();
                y.setId(tulokset.getInt("id"));
                y.setNimi(tulokset.getString("nimi"));
                lista.add(y);
            }
            return lista;

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
    
    public static List<Yritykset> haeTarjontaa(String tarjonta)
            throws Exception {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;

        try {
            String sql = "SELECT * FROM yritys WHERE tarjonta_id = ? ORDER BY nimi";
            yhteys = Yhteys.getYhteys();
            kysely = yhteys.prepareStatement(sql);
            kysely.setString(1, tarjonta);
            tulokset = kysely.executeQuery();

            ArrayList<Yritykset> lista = new ArrayList<Yritykset>();
            while (tulokset.next()) {
                Yritykset y = new Yritykset();
                y.setId(tulokset.getInt("id"));
                y.setNimi(tulokset.getString("nimi"));
                lista.add(y);
            }
            return lista;

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

    public static ArrayList<Yritykset> haeYritys(String tunnus)
            throws Exception {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;
        Yritykset yritys = null;
        ArrayList<Yritykset> y = new ArrayList();
        try {
            String sql = "SELECT * FROM yritys WHERE tunnus = ?";
            yhteys = Yhteys.getYhteys();
            kysely = yhteys.prepareStatement(sql);
            kysely.setString(1, tunnus);
            tulokset = kysely.executeQuery();
            while (tulokset.next()) {
                String yNimi = tulokset.getString("nimi");
                String yHintataso = tulokset.getString("hintataso");
                String sijainti = tulokset.getString("sijainti");
                String osoite = tulokset.getString("osoite");
                int id = tulokset.getInt("id");

                yritys = new Yritykset(yNimi, tunnus, yHintataso, sijainti, osoite);
                yritys.setId(id);
                y.add(yritys);
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
        return y;
    }

    /**
     * Hakee tietokannasta listan yrityksistä
     */
    public static List<Yritykset> kaikkiYritykset() throws SQLException {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;

        try {
            String sql = "SELECT * FROM yritys ORDER BY nimi";
            yhteys = Yhteys.getYhteys();
            kysely = yhteys.prepareStatement(sql);
            tulokset = kysely.executeQuery();

            ArrayList<Yritykset> l = new ArrayList<Yritykset>();
            while (tulokset.next()) {
                Yritykset y = new Yritykset();
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
/*
    public static int lukumaara() throws NamingException, SQLException {
        String sql = "SELECT count(*) as lkm FROM yritys";
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        ResultSet tulokset = kysely.executeQuery();

        tulokset.next();
        int lkm = tulokset.getInt("lkm");

        //Suljetaan kaikki resurssit:
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

        return lkm;
    }
*/

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

    public String getTunnus() {
        return this.tunnus;
    }

    public void setTunnus(String tunnus) {
        this.tunnus = tunnus;
    }

    public String getOsoite() {
        return this.osoite;
    }

    public void setOsoite(String osoite) {
        this.osoite = osoite;
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

    /**
     * @return the kuvaus
     */
    public String getKuvaus() {
        return kuvaus;
    }

    /**
     * @param kuvaus the kuvaus to set
     */
    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }
}
