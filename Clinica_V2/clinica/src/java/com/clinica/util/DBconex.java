/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clinica.util;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class DBconex {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/bdclinica";
    private static String user = "root";
    private static String pass = "mysql";

    public DBconex() {
    }

    public static Connection getConexion() {
        Connection cn = null;
        try {
            Class.forName(driver);
            cn = DriverManager.getConnection(url, user, pass);
            return cn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexion: " + e.getMessage());
        }
        return cn;
    }
}