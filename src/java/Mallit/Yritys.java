package Mallit;

import Tietokanta.Yhteys;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    /*public static List<Yritys> getYritykset() throws SQLException {
        String sql = "SELECT id, tunnus, salasana from kayttajat";
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        ResultSet tulokset = kysely.executeQuery();

        ArrayList<Yritys> yritykset = new ArrayList<Yritys>();
        while (tulokset.next()) {
            //Luodaan tuloksia vastaava olio ja palautetaan olio:
            Yritys y = new Yritys(00, "Yritys", "yritys");
            y.setId(tulokset.getInt("id"));
            y.setTunnus(tulokset.getString("tunnus"));
            y.setSalasana(tulokset.getString("salasana"));

            yritykset.add(y);
        }
        //Suljetaan kaikki resutuloksetsit:
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

        return yritykset;
    }*/
}
