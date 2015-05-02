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

/**
 *
 * @author Outi
 */
public class Tarjonta_yritys {

    private int id;
    private int tarjonta_id;
    private int yritys_id;

    public Tarjonta_yritys() {
    }

    public Tarjonta_yritys(int id, int tarjonta_id, int yritys_id) {
        this.id = id;
        this.tarjonta_id = tarjonta_id;
        this.yritys_id = yritys_id;
    }

    public static void nollaaYrityksenTarjonta(Yritykset yritys) throws SQLException {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;
        try {
            String sql = "DELETE FROM tarjonta_yritys WHERE yritys_id=?";
            yhteys = Yhteys.getYhteys();
            kysely = yhteys.prepareStatement(sql);
            kysely.setInt(1, yritys.getId());
            kysely.execute();
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

    public static ArrayList<String> haeYrityksenTarjonta(Yritykset yritys) throws SQLException {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;
        try {
            String sql = "SELECT tarjonta_id FROM tarjonta_yritys WHERE yritys_id=?";
            yhteys = Yhteys.getYhteys();
            kysely = yhteys.prepareStatement(sql);
            kysely.setInt(1, yritys.getId());
            tulokset = kysely.executeQuery();

            ArrayList<String> lista = new ArrayList<String>();
            while (tulokset.next()) {
                String tarjonta = Tarjonnat.haeId(tulokset.getInt(1)).getNimi();
                lista.add(tarjonta);
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

    public static void lisaa(Yritykset yritys, Tarjonnat tarjonta) throws SQLException {
        Connection yhteys = null;
        PreparedStatement kysely = null;
        ResultSet tulokset = null;
        try {
            String sql = "INSERT INTO tarjonta_yritys(tarjonta_id, yritys_id) VALUES(?,?) RETURNING id";
            yhteys = Yhteys.getYhteys();
            kysely = yhteys.prepareStatement(sql);
            kysely.setInt(1, tarjonta.getId());
            kysely.setInt(2, yritys.getId());
            tulokset = kysely.executeQuery();
            tulokset.next();
            int id = tulokset.getInt(1);
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
     * @return the yritys_id
     */
    public int getYritys_id() {
        return yritys_id;
    }

    /**
     * @param yritys_id the yritys_id to set
     */
    public void setYritys_id(int yritys_id) {
        this.yritys_id = yritys_id;
    }
}
