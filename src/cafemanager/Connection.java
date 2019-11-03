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

    public static ResultSet Connect(String ipAddress, String port, String databasename, String username, String password) throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String dbUrl = "jdbc:sqlserver://" + ipAddress + ":" + port + ";instance=SQLSERVER;databaseName=" + databasename + ";user=" + username + ";password=" + password;
        java.sql.Connection con = DriverManager.getConnection(dbUrl);
        Statement s = con.createStatement();
//        ResultSet rs = s.executeQuery("select a.MaHoaDon from HoaDon as a, ChiTietMonAn as b, MonAn as c\n"
//                + "where\n"
//                + "	a.MaHoaDon=b.MaHoaDon and\n"
//                + "	c.MaMonAn=b.MaMonAn and\n"
//                + "	a.MaKH='KH-1'");
        ResultSet rs;
        rs = s.executeQuery("select a.MaChucVu from ChucVu as a where a.TenChucVu='Chu'");
        return rs;
    }

}
