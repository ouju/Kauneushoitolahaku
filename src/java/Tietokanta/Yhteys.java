/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tietokanta;

import javax.activation.DataSource;
import javax.naming.InitialContext;

/**
 *
 * @author Outi
 */
public class Yhteys {

    InitialContext cxt = new InitialContext();
    DataSource yhteysVarasto = (DataSource) cxt.lookup("java:/comp/env/jdbc/ouju");
}
