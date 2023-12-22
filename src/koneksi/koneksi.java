/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jangh
 */
import javax.swing.JOptionPane;

public class koneksi {
    Connection cn;
    public static Connection BukaKoneksi(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/db_penjualan?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            return DriverManager.getConnection(url, "root", "");
        }catch (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"Can't Connect to your Database");
            return null;
        }
    }
}