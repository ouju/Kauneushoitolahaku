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
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private String kotisivut;
    private String kuvaus;
    private int tarjonta_id;
    private int tyontekija_id;
    private Map<String, String> virheet = new HashMap<String, String>();

    public Yritykset() {
    }

    public Yritykset(ResultSet tulos) throws SQLException {
        this.id = tulos.getInt("id");
        this.nimi = tulos.getString("nimi");
        this.hintataso = tulos.getString("hintataso");
        this.sijainti = tulos.getString("sijainti");
        this.osoite = tulos.getString("osoite");
        this.kuvaus = tulos.getString("kuvaus");
        this.kotisivut = tulos.getString("kotisivut");
        //this.tarjonta_id = tulos.getInt("tarjonta_id");
    }

    public Yritykset(String nimi, String hintataso, String sijainti, String osoite, String kotisivut, String kuvaus, int tyontekija_id) {
        this.nimi = nimi;
        this.hintataso = hintataso;
        this.sijainti = sijainti;
        this.osoite = osoite;
        this.kotisivut = kotisivut;
        this.kuvaus = kuvaus;
        this.tyontekija_id = tyontekija_id;
    }

    public Yritykset(int id, String nimi, String hintataso, String sijainti, String osoite, String kotisivut, String kuvaus, int tarjonta_id) {
        this.id = id;
        this.nimi = nimi;
        this.hintataso = hintataso;
        this.sijainti = sijainti;
        this.osoite = osoite;
        this.kotisivut = kotisivut;
        this.kuvaus = kuvaus;
        this.tarjonta_id = tarjonta_id;
    }

    public static ArrayList<Yritykset> haeTunnuksella(int tyontekija_id) throws Exception {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;
        Yritykset yritys = null;
        ArrayList<Yritykset> y = new ArrayList();
        try {
            String sql = "SELECT * FROM yritys WHERE tyontekija_id = ? ORDER BY nimi";
            yhteys = Yhteys.getYhteys();
            kysely = yhteys.prepareStatement(sql);
            kysely.setInt(1, tyontekija_id);
            tulokset = kysely.executeQuery();
            while (tulokset.next()) {
                String nimi = tulokset.getString("nimi");
                String hintataso = tulokset.getString("hintataso");
                String sijainti = tulokset.getString("sijainti");
                String osoite = tulokset.getString("osoite");
                String kotisivut = tulokset.getString("kotisivut");
                String kuvaus = tulokset.getString("kuvaus");
                int id = tulokset.getInt("id");
                yritys = new Yritykset(nimi, hintataso, sijainti, osoite, kotisivut, kuvaus, tyontekija_id);
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

    public static boolean tunnusJaSalasanaOikein(String tunnus, String salasana) throws SQLException {
        String sql = "SELECT tunnus, salasana from tyontekija where tunnus=? and salasana=?";
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, tunnus);
        kysely.setString(2, salasana);
        ResultSet tulokset = kysely.executeQuery();
        if (tulokset.next()) {
            tulokset.close();
            kysely.close();
            yhteys.close();
            return true;
        }
        return false;
    }

    public Yritykset haeYritysId(int id) throws Exception {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;

        try {
            String sql = "SELECT * FROM yritys WHERE id = ? ORDER BY nimi";
            yhteys = Yhteys.getYhteys();
            kysely = yhteys.prepareStatement(sql);
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

    public static List<Yritykset> haeTarjontaa(int tarjonta_id)
            throws Exception {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;

        try {
            String sql = "SELECT yritys.nimi FROM tarjonta_yritys, yritys WHERE tarjonta_id = ? AND yritys_id=yritys.id ORDER BY nimi";
            yhteys = Yhteys.getYhteys();
            kysely = yhteys.prepareStatement(sql);
            kysely.setInt(1, tarjonta_id);
            tulokset = kysely.executeQuery();

            ArrayList<Yritykset> lista = new ArrayList<Yritykset>();
            while (tulokset.next()) {
                Yritykset y = new Yritykset();
                //y.setId(tulokset.getInt("id"));
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

    public int lisaaYritys(Yritykset yritys) throws Exception {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;
        try {
            String sql = "INSERT INTO yritys(nimi, hintataso, sijainti, osoite, kotisivut, kuvaus, tyontekija_id) VALUES(?,?,?,?,?,?,?) RETURNING id";
            yhteys = Yhteys.getYhteys();
            kysely = yhteys.prepareStatement(sql);
            kysely.setString(1, yritys.getNimi());
            kysely.setString(2, yritys.getHintataso());
            kysely.setString(3, yritys.getSijainti());
            kysely.setString(4, yritys.getOsoite());
            kysely.setString(4, yritys.getKotisivut());
            kysely.setString(5, yritys.getKuvaus());
            kysely.setInt(6, yritys.getTyontekija_id());
            tulokset = kysely.executeQuery();
            tulokset.next();
            yritys.id = tulokset.getInt(1);
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
        return id;
    }

    public boolean onkoKelvollinen(Yritykset yritys) {
        return yritys.virheet.isEmpty();
    }

    /**
     * Poistaa yrityksen tietokannasta
     */
    public void poistaYritys() throws Exception {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        try {
            String sql = "DELETE FROM yritys WHERE id = ?";
            yhteys = Yhteys.getYhteys();
            kysely = yhteys.prepareStatement(sql);
            kysely.setInt(1, this.getId());
            kysely.execute();
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

    public void muokkaaYritysta() throws Exception {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        
        try {
            String sql = "UPDATE yritys SET nimi=?, hintataso=?, sijainti=?, osoite=?, kotisivut=?, kuvaus=? WHERE id=?";
            yhteys = Yhteys.getYhteys();
            kysely = yhteys.prepareStatement(sql);
            kysely.setString(1, this.getNimi());
            kysely.setString(2, this.getHintataso());
            kysely.setString(3, this.getSijainti());
            kysely.setString(4, this.getOsoite());
            kysely.setString(5, this.getKotisivut());
            kysely.setString(6, this.getKuvaus());
            kysely.setInt(7, this.getId());
            
            kysely.executeUpdate();
        } finally {
            kysely.close();
            yhteys.close();
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

        if (nimi.trim().length() == 0) {
            virheet.put(nimi, "Yrityksellä tulee olla nimi.");
        } else {
            virheet.remove("nimi");
        }
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

    /**
     * @return the tunnus
     */
    public String getTunnus() {
        return tunnus;
    }

    /**
     * @param tunnus the tunnus to set
     */
    public void setTunnus(String tunnus) {
        this.tunnus = tunnus;
    }

    /**
     * @return the tarjonta_id
     */
    public int getTarjonta_id() {
        return tarjonta_id;
    }

    /**
     * @param tarjonta_id the tarjonta_id to set
     */
    public void setTarjonta_id(int tarjonta_id) {
        this.tarjonta_id = tarjonta_id;
    }

    /**
     * @return the tyontekija_id
     */
    public int getTyontekija_id() {
        return tyontekija_id;
    }

    /**
     * @param tyontekija_id the tyontekija_id to set
     */
    public void setTyontekija_id(int tyontekija_id) {
        this.tyontekija_id = tyontekija_id;
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

    /**
     * @return the kotisivut
     */
    public String getKotisivut() {
        return kotisivut;
    }

    /**
     * @param kotisivut the kotisivut to set
     */
    public void setKotisivut(String kotisivut) {
        this.kotisivut = kotisivut;
    }
}
