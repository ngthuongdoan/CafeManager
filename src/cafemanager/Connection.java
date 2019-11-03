/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafemanager;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author BlackVernon
 */
class Connection {

    public static ResultSet ConnectQuery(String ipAddress, String port, String databasename, String username, String password, String query) throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String dbUrl = "jdbc:sqlserver://" + ipAddress + ":" + port + ";instance=SQLSERVER;databaseName=" + databasename + ";user=" + username + ";password=" + password;
        java.sql.Connection con = DriverManager.getConnection(dbUrl);
        Statement s = con.createStatement();
        ResultSet rs;
        rs = s.executeQuery(query);
        return rs;
    }
    public static void ConnectUpdate(String ipAddress, String port, String databasename, String username, String password, String query) throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String dbUrl = "jdbc:sqlserver://" + ipAddress + ":" + port + ";instance=SQLSERVER;databaseName=" + databasename + ";user=" + username + ";password=" + password;
        java.sql.Connection con = DriverManager.getConnection(dbUrl);
        Statement s = con.createStatement();
        s.executeUpdate(query);
    }
}
