/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BlackVernon
 */
public class Connect {

//    private String ipAddress;

    public static ResultSet ConnectQuery(String ipAddress, String port, String databasename, String username, String password, String query) throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String dbUrl = "jdbc:sqlserver://" + ipAddress + ":" + port + ";instance=SQLSERVER;databaseName=" + databasename + ";user=" + username + ";password=" + password;
        
        java.sql.Connection con = DriverManager.getConnection(dbUrl);
        Statement s = con.createStatement();
        ResultSet rs;
        rs = s.executeQuery(query);
        return rs;
    }

    public static Connection getConnect(String ipAddress) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        String dbUrl = "jdbc:sqlserver://" + ipAddress + ":" + "1433" + ";instance=SQLSERVER;databaseName=" + "CAFE" + ";user=" + "sa" + ";password=" + "sa2017";
        Connection con = null;
        try {
            con = DriverManager.getConnection(dbUrl);
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public static void ConnectUpdate(String ipAddress, String port, String databasename, String username, String password, String query) throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String dbUrl = "jdbc:sqlserver://" + ipAddress + ":" + port + ";instance=SQLSERVER;databaseName=" + databasename + ";user=" + username + ";password=" + password;
        java.sql.Connection con = DriverManager.getConnection(dbUrl);
        Statement s = con.createStatement();
        s.executeUpdate(query);
    }

   
}
