/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huykh
 */
public class CheckLogin {
    private Connection c;
    
    public CheckLogin(){
        try {
            c = new ConnectManager().getConnection();
        } catch (IOException | SQLException ex) {
            Logger.getLogger(CheckLogin.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    
    public boolean checkAccount(String username, String password){
        final String sql = "SELECT * FROM account WHERE username = ? AND password = ?";
        try (PreparedStatement pr = c.prepareStatement(sql)) {
            pr.setString(1, username);
            pr.setString(2, password);
            ResultSet rs = pr.executeQuery();
            return rs.isBeforeFirst();
        } catch (SQLException ex) {
            Logger.getLogger(CheckLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(CheckLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
