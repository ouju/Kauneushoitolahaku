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
public class Kirjautunut {

    private int id;
    private String tunnus;
    private String salasana;
    private String nimi;
    private String hintataso;
    private String osoite;
    private String sijainti;
    private String kotisivut;
    private String kuvaus;
    private int tarjontaId;
    private Map<String, String> virheet = new HashMap<String, String>();

    public Kirjautunut() {
    }

    public Kirjautunut(int id, String tunnus, String salasana) {
        this.id = id;
        this.tunnus = tunnus;
        this.salasana = salasana;
    }

    /**
     * Tallentaa yrityksen tietokantaan
     */
    public void lisaa(String tunnus) throws Exception {
        Connection yhteys = null;
        PreparedStatement kysely1 = null;
        PreparedStatement kysely2 = null;
        ResultSet tulokset1 = null;
        ResultSet tulokset2 = null;

        try {
            String salasana = "SELECT salasana FROM yritys WHERE tunnus = ?";
            String sql = "INSERT INTO yritys(nimi, hintataso, sijainti, osoite, kuvaus, tunnus, salasana) VALUES(?,?,?,?,?,?,?) RETURNING id";
            yhteys = Yhteys.getYhteys();
            kysely2 = yhteys.prepareStatement(salasana);
            kysely2.setString(1, tunnus);
            tulokset2 = kysely2.executeQuery();
            tulokset2.next();
            if (tulokset2 != null || !tulokset2.getString(1).isEmpty()) {
                kysely1 = yhteys.prepareStatement(sql);
                kysely1.setString(1, this.getNimi());
                kysely1.setString(2, this.getHintataso());
                kysely1.setString(3, this.getSijainti());
                kysely1.setString(4, this.getOsoite());
                kysely1.setString(5, this.getKuvaus());
                kysely1.setString(6, tunnus);
                kysely1.setString(7, tulokset2.getString(1));
                //kysely.setInt(6, this.getTarjontaId());
                tulokset1 = kysely1.executeQuery();

                tulokset1.next();
                this.id = tulokset1.getInt(1);
            }
        } finally {
            if (tulokset1 != null) {
                tulokset1.close();
                tulokset2.close();
                kysely1.close();
                kysely2.close();
            }


            yhteys.close();
        }
    }

    public void muokkaa() throws Exception {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        //ResultSet tulokset = null;

        String sql = "UPDATE yritys SET nimi=?, hintataso=?, sijainti=?, osoite=?, kuvaus=? WHERE nimi=?";
        yhteys = Yhteys.getYhteys();
        kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, this.getNimi());
        kysely.setString(2, this.getHintataso());
        kysely.setString(3, this.getSijainti());
        kysely.setString(4, this.getOsoite());
        kysely.setString(5, this.getKuvaus());
        kysely.setString(6, this.getNimi());
        kysely.executeUpdate();
        System.out.println(this.getNimi());

        //tulokset.close();
        kysely.close();
        yhteys.close();

    }

    /**
     * Poistaa yrityksen tietokannasta
     */
    public boolean poista() throws Exception {
        Connection yhteys = null;
        PreparedStatement kysely = null;

        try {
            String sql = "DELETE FROM yritys where nimi = ?";
            yhteys = Yhteys.getYhteys();
            kysely = yhteys.prepareStatement(sql);
            kysely.setString(1, nimi);
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

    public static boolean tunnusJaSalasanaOikein(String tunnus, String salasana) throws SQLException {
        String sql = "SELECT tunnus, salasana from yritys where tunnus=? and salasana=?";
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

    public static Kirjautunut etsiKayttajaTunnuksilla(String kayttaja, String salasana) throws SQLException {
        String sql = "SELECT id,tunnus, salasana from yritys";
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, kayttaja);
        kysely.setString(2, salasana);
        ResultSet rs = kysely.executeQuery();

        //Alustetaan muuttuja, joka sisältää löydetyn käyttäjän
        Kirjautunut kirjautunut = null;

        //next-metodia on kutsuttava aina, kun käsitellään 
        //vasta kannasta saatuja ResultSet-olioita.
        //ResultSet on oletuksena ensimmäistä edeltävällä -1:llä rivillä.
        //Kun sitä kutsuu ensimmäisen kerran siirtyy se ensimmäiselle riville 0.
        //Samalla metodi myös palauttaa tiedon siitä onko seuraavaa riviä olemassa.
        if (rs.next()) {
            //Kutsutaan sopivat tiedot vastaanottavaa konstruktoria 
            //ja asetetaan palautettava olio:
            kirjautunut = new Kirjautunut();
            kirjautunut.setId(rs.getInt("id"));
            kirjautunut.setTunnus(rs.getString("username"));
            kirjautunut.setSalasana(rs.getString("password"));
        }

        //Jos kysely ei tuottanut tuloksia käyttäjä on nyt vielä null.

        //Suljetaan kaikki resurssit:
        try {
            rs.close();
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

        //Käyttäjä palautetaan vasta täällä, kun resurssit on suljettu onnistuneesti.
        return kirjautunut;
    }

    public boolean onkoKelvollinen() {
        return this.virheet.isEmpty();
    }

    public Collection<String> getVirheet() {
        return virheet.values();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTunnus() {
        return tunnus;
    }

    public void setTunnus(String tunnus) {
        this.tunnus = tunnus;
    }

    public String getSalasana() {
        return salasana;
    }

    public void setSalasana(String salasana) {
        this.salasana = salasana;
    }

    /**
     * @return the nimi
     */
    public String getNimi() {
        return nimi;
    }

    /**
     * @param nimi the nimi to set
     */
    public void setNimi(String nimi) {
        this.nimi = nimi;

        if (nimi.trim().length() == 0) {
            virheet.put(nimi, "Nimi ei saa olla tyhjä.");
        } else {
            virheet.remove("nimi");
        }
    }

    /**
     * @return the hintataso
     */
    public String getHintataso() {
        return hintataso;
    }

    /**
     * @param hintataso the hintataso to set
     */
    public void setHintataso(String hintataso) {
        this.hintataso = hintataso;
    }

    /**
     * @return the osoite
     */
    public String getOsoite() {
        return osoite;
    }

    /**
     * @param osoite the osoite to set
     */
    public void setOsoite(String osoite) {
        this.osoite = osoite;
    }

    /**
     * @return the sijainti
     */
    public String getSijainti() {
        return sijainti;
    }

    /**
     * @param sijainti the sijainti to set
     */
    public void setSijainti(String sijainti) {
        this.sijainti = sijainti;
    }

    /**
     * @return the tarjontaId
     */
    public int getTarjontaId() {
        return tarjontaId;
    }

    /**
     * @param tarjontaId the tarjontaId to set
     */
    public void setTarjontaId(int tarjontaId) {
        this.tarjontaId = tarjontaId;
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
