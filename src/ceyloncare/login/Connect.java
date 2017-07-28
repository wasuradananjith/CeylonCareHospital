/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceyloncare.login;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Wasura Dananjith
 */
// Makes the database connection with the server
public class Connect {
    
    Connection con = null;
    
    public static Connection ConnectDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/hospital","root","");
            return con;   
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }      
    }
}
