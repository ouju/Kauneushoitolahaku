/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kauneushoitolahaku.Mallit;

import Kauneushoitolahaku.Servletit.Apuservlet;
import Kauneushoitolahaku.Tietokanta.Yhteys;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Sisältää Tyontekija-tauluun liittyvät sql-kyselyt 
 * sekä getterit ja setterit
 *
 * @author Outi
 */
public class Tyontekija {

    private int id;
    private String tunnus;
    private String salasana;
    private Map<String, String> virheet = new HashMap<String, String>();

    /**
     * Konstruktori ilman parametrejä
     *
     */
    public Tyontekija() {
    }

    /**
     *
     * @param tulos
     * @throws SQLException
     */
    public Tyontekija(ResultSet tulos) throws SQLException {
        this.id = tulos.getInt("id");
        this.tunnus = tulos.getString("tunnus");
        this.salasana = tulos.getString("salasana");
    }

    /**
     * Konstruktori, jossa Tyontekija-taulun sarakkeet parametreinä
     *
     * @param id
     * @param tunnus
     * @param salasana
     */
    public Tyontekija(int id, String tunnus, String salasana) {
        this.id = id;
        this.tunnus = tunnus;
        this.salasana = salasana;
    }

    /**
     *
     * @param tunnus
     * @param salasana
     */
    public Tyontekija(String tunnus, String salasana) {
        this.tunnus = tunnus;
        this.salasana = salasana;
    }

    /**
     * Tarkistaa, löytyykö tunnus jo kannasta
     *
     * @param tunnus
     * @return boolean
     * @throws SQLException
     */
    public static boolean tunnusKaytossa(String tunnus) throws SQLException {
        String sql = "SELECT * FROM tyontekija WHERE tunnus = ?";
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, tunnus);
        ResultSet tulokset = kysely.executeQuery();

        if (tulokset.next()) {
            Apuservlet.suljeKTY(kysely, tulokset, yhteys);
            return true;
        } else {
            Apuservlet.suljeKTY(kysely, tulokset, yhteys);
            return false;
        }
    }

    /**
     * Etsii työntekijän id:n tunnuksen perusteella
     *
     * @param tunnus
     * @return työntekijän id
     * @throws SQLException
     */
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

        Apuservlet.suljeKTY(kysely, tulokset, yhteys);

        return tyontekija.getId();
    }

    /**
     * Lisää työntekijän kantaan
     *
     * @return @throws SQLException 
     * @throws SQLException
     */
    public int lisaaTyontekija() throws SQLException {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;

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
            Apuservlet.suljeKTY(kysely, tulokset, yhteys);
        }
        return this.getId();
    }

    /**
     * Poistaa työntekijän kannasta
     *
     * @throws Exception
     */
    public void poistaTunnukset() throws Exception {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        try {
            String sql = "DELETE FROM tyontekija WHERE id = ?";
            yhteys = Yhteys.getYhteys();
            kysely = yhteys.prepareStatement(sql);
            kysely.setInt(1, this.getId());
            kysely.execute();
        } finally {
            Apuservlet.suljeKY(kysely, yhteys);
        }
    }

    /**
     * Muokkaa työntekijän tunnusta ja/tai salasanaa
     *
     * @throws Exception
     */
    public void muokkaaTunnuksia() throws Exception {
        Connection yhteys = null;
        PreparedStatement kysely = null;

        try {
            String sql = "UPDATE tyontekija SET tunnus=?, salasana=? WHERE id=?";
            yhteys = Yhteys.getYhteys();
            kysely = yhteys.prepareStatement(sql);
            kysely.setString(1, this.getTunnus());
            kysely.setString(2, this.getSalasana());
            kysely.setInt(3, this.getId());

            kysely.executeUpdate();
        } finally {
            Apuservlet.suljeKY(kysely, yhteys);
        }
    }

    /**
     * Tarkistaa onko työntekijään liitetty yrityksiä
     *
     * @return @throws SQLException 
     * @throws SQLException
     */
    public boolean omistaakoYrityksia() throws SQLException {
        String sql = "SELECT * FROM yritys, tyontekija WHERE tyontekija_id = ? AND tyontekija_id=tyontekija.id";
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setInt(1, id);
        ResultSet tulokset = kysely.executeQuery();

        if (tulokset.next()) {
            Apuservlet.suljeKTY(kysely, tulokset, yhteys);
            return true;
        } else {
            Apuservlet.suljeKTY(kysely, tulokset, yhteys);
            return false;
        }
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
     * Antaa virheen jos tunnusta ei ole annettu 
     * tai se on jo käytössä
     * 
     * @param tunnus the tunnus to set
     * @throws SQLException
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
     * Antaa virheen jos salasanaa ei ole annettu
     * 
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
