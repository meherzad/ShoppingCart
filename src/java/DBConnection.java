/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Meherzad
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;

public class DBConnection {

    Connection connection = null;
    Statement statement = null;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        connection.close();
    }

    DBConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Meherzad\\Documents\\NetBeansProjects\\ShoppingCart\\sample.db");
            //statement = connection.createStatement();
            System.out.println("aaaaaaaaaaaaaaaaaaaConnection created");
        } catch (Exception e) {
            System.out.println("Errorrrrrrr  " + e.getMessage());
            e.printStackTrace();
        }
    }

    void connectionOpen() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Meherzad\\Documents\\NetBeansProjects\\ShoppingCart\\sample.db");
        } catch (Exception e) {
            System.out.println("Errorrrrrrr  " + e.getMessage());
            e.printStackTrace();
        }
    }

    void connectionClose() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void createDB() {
        try {
            //connectionOpen();
            statement.executeUpdate("drop table if exists productMaster");
            statement.executeUpdate("create table productMaster "
                    + "(prodId INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "name string, price integer, quant integer)");
            System.out.println("Table created");
            //connectionClose();
        } catch (Exception e) {
            System.out.println("EEEEEEEEErrrrrrrrooorrrr   :" + e.getMessage());
            e.printStackTrace();
        }
    }

    boolean setRecords(String query) {
        try {
           // connectionOpen();
            statement = connection.createStatement();
            statement.executeUpdate(query);
           // connectionClose();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    ResultSet getRecords(String query) {
        ResultSet rs = null;
        try {
            //connectionOpen();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return rs;
    }
}
