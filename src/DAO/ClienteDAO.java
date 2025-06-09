package DAO;

import java.sql.*;
import model.Cliente;

public class ClienteDAO {
    private Connection conn;

    public ClienteDAO() {
        this.conn = ConnectionFactory.getConnection();
    }

    private int inserirCliente(Cliente cliente, int usuarioId) {
    String sql = "INSERT INTO cliente (usuario_id, endereco) VALUES (?, ?)";

    try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        stmt.setInt(1, usuarioId);
        stmt.setString(2, cliente.getEndereco());

        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1); // retorna o cliente_id gerado
                }
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return -1;
    }
}

