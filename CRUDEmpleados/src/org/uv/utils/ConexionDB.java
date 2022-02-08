package org.uv.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author citla
 */
public class ConexionDB {
    private static ConexionDB con = null;
    private Connection connection = null;
    private String url = "jdbc:postgresql://localhost:5432/dsa";
    private String uname = "postgres";
    private String password = "admin";
    private transient  Connection driverPostgres;
    
    public static ConexionDB getInstance(){
        if(con==null){
            con = new ConexionDB();
        }
        return con;
    }

    private ConexionDB(){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, uname, password);

        } catch (SQLException e) {
            System.err.println("Problema de conexión\n" + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean execute(String query){
        boolean res = false;
        try {
            Statement st = connection.createStatement();
            st.execute(query);
            res = true;
        } catch (Exception e) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, e);
        }
        return res;
    }
    
    public ResultSet getData(String sql) {
        ResultSet records = null;
        try {
            Statement st = connection.createStatement();
            records = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return records;
    }
    
     public Connection getConnection(){
        return connection;
    }
}
