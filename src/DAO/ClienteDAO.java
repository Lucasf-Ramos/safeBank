package DAO;

import java.sql.*;
import model.Cliente;

public class ClienteDAO {
    private Connection conn;

    public ClienteDAO() {
        this.conn = ConnectionFactory.getConnection();
    }

    public int inserirCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (usuario_id, endereco) VALUES (?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setLong(1, cliente.getId());
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
    
    public Cliente buscarClientePorId(long id) {
        String sql = "SELECT u.id, u.nome, u.email, u.senha, " +
                     "c.id as cliente_id, c.endereco " +
                     "FROM usuario u " +
                     "JOIN cliente c ON u.id = c.usuario_id " +
                     "WHERE c.id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Cliente cliente = new Cliente();

                cliente.setId(rs.getLong("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));

                cliente.setClienteId(rs.getLong("cliente_id"));
                cliente.setEndereco(rs.getString("endereco"));

                return cliente;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar cliente por ID: " + e.getMessage());
        }

        return null;
    }
}

