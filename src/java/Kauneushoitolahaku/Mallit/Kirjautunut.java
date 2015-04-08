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
    public void tallenna() throws Exception {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;

        try {
            String sql = "INSERT INTO yritys(nimi, hintataso, sijainti, osoite, tarjontaId) VALUES(?,?,?,?,?) RETURNING id";
            yhteys = Yhteys.getYhteys();
            kysely = yhteys.prepareStatement(sql);
            kysely.setString(1, this.getNimi());
            kysely.setString(2, this.getHintataso());
            kysely.setString(3, this.getSijainti());
            kysely.setString(4, this.getOsoite());
            kysely.setInt(5, this.getTarjontaId());
            tulokset = kysely.executeQuery();

            tulokset.next();
            this.id = tulokset.getInt(1);

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
    
    public void muokkaa() throws Exception {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;

        try {
            String sql = "UPDATE yritys SET nimi = ?, hintataso = ?, sijainti = ?, osoite = ? WHERE id = ?";
            yhteys = Yhteys.getYhteys();
            kysely = yhteys.prepareStatement(sql);
            kysely.setString(1, this.getNimi());
            kysely.setString(2, this.getHintataso());
            kysely.setString(3, this.getSijainti());
            kysely.setString(4, this.getOsoite());
            tulokset = kysely.executeQuery();

            tulokset.next();
            this.id = tulokset.getInt(1);

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
            kysely = yhteys.prepareStatement(sql);
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
            virheet.put("nimi", "Nimi ei saa olla tyhjä.");
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

        if (!"edullinen".equals(hintataso) || !"keskitaso".equals(hintataso) || !"hintavampi".equals(hintataso)) {
            virheet.put("hintataso", "Valitse edullinen, keskitaso tai hintavampi.");
        } else {
            virheet.remove("hintataso");
        }

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
}
