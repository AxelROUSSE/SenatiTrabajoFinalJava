/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author AxelHOOLIC
 */
public class Conexion {
    Connection con;
    String URL="jdbc:mysql://localhost:3306/tiendapd";
    String USER="root";
    String PASS="";
    
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            System.err.println("Error de conexion" + e);
        }return con;
    }
    
}
