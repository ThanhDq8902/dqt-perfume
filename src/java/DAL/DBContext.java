/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author khans
 */
public class DBContext {

    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;
        if (instance == null || instance.trim().isEmpty()) {
            url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        }
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }
    private final String serverName = "localhost";
    private final String dbName = "prj301_se1638_HE160623";
    private final String portNumber = "1433";
    private final String instance = ""; //LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
    private final String userID = "sa";
    private final String password = "0978533728";
}
//class testing{
//    public static void main(String[] args) {
//        try {
//            new DBContext().getConnection();
//            System.out.println("connected");
//        } catch (Exception e) {
//            System.out.println("miss connected");
//        }
//    }
//    }
