package DAO;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory 
{
    private static final String URL = "jdbc:mysql://localhost:3306/safebank"; 
    private static final String USUARIO = "root";     
    private static final String SENHA = "password";      

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados:");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
