/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kauneushoitolahaku.Mallit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Outi
 */
public class Yritys {

    private int id;
    private String tunnus;
    private String salasana;

    public Yritys(int id, String tunnus, String salasana) {
        this.id = id;
        this.tunnus = tunnus;
        this.salasana = salasana;
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

    

    public static Yritys etsiKayttajaTunnuksilla(String kayttaja, String salasana) throws SQLException {
        String sql = "SELECT id, nimimerkki, salasana from yritys where nimimerkki = ? AND salasana = ?";
        Yritys kirjautunut = null;
        /*Connection yhteys = Tietokanta.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, kayttaja);
        kysely.setString(2, salasana);
        ResultSet rs = kysely.executeQuery();

        //Alustetaan muuttuja, joka sisältää löydetyn käyttäjän
        

        if (rs.next()) {
            //Kutsutaan sopivat tiedot vastaanottavaa konstruktoria 
            //ja asetetaan palautettava olio:
            kirjautunut = new Yritys();
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
*/
        //Käyttäjä palautetaan vasta täällä, kun resurssit on suljettu onnistuneesti.
        return kirjautunut;
    }
}
