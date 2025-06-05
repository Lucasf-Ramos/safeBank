package DAO;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConnectionFactory 
{
    public Connection getConnection(){
        Connection conn = null;
        try 
        {
            String url = "jdbc:mysql://localhost:3306/safebank?user=root&password=password";
            conn = DriverManager.getConnection(url);
        } catch (SQLException erro) 
        {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
        return conn;
    }
}
