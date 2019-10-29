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

    public static void Connect() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String ipAddress = "10.1.21.19";
            String dbUrl = "jdbc:sqlserver://" + ipAddress + ":1433;instance=SQLSERVER;databaseName=account;user=sa;password=sa2017";
            java.sql.Connection con = DriverManager.getConnection(dbUrl);
        } catch (ClassNotFoundException | SQLException e) {
        }
    }
}
