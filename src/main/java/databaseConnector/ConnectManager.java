package databaseConnector;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author huykh
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectManager {
    private Connection connection;
    public ConnectManager() throws IOException, SQLException{
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("./src/main/java/databaseInfo.properties"));
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String pass = properties.getProperty("password");
            this.connection = DriverManager.getConnection(url,username,pass);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConnectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void close() throws SQLException{
        if (this.connection != null){
            connection.close();
        }
    }
    
    public Connection getConnection(){
        return connection;
    }
}
