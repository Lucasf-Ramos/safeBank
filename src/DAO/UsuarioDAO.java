package DAO;

import model.Usuario;
import model.Cliente;
import model.Funcionario;
import java.sql.*;

public class UsuarioDAO {
    private Connection conn;

    public UsuarioDAO() {
        this.conn = ConnectionFactory.getConnection();
    }
    
    public int inserirUsuario(Cliente cliente) {
    String sql = "INSERT INTO usuario (nome, email, senha, tipo) VALUES (?, ?, ?, ?)";

    try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getEmail());
        stmt.setString(3, cliente.getSenha());
        stmt.setString(4, "cliente");

        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1); // retorna o ID gerado
                }
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return -1; // erro
}

	
    public Usuario fazerLogin(String email, String senha) {
        String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String tipo = rs.getString("tipo_usuario");
                int id = rs.getInt("id");

                if ("cliente".equalsIgnoreCase(tipo)) {
                    return buscarClienteCompleto(id, rs);
                } else if ("funcionario".equalsIgnoreCase(tipo)) {
                    return buscarFuncionarioCompleto(id, rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Cliente buscarClienteCompleto(int usuarioId, ResultSet dadosUsuario) throws SQLException {
        String sql = "SELECT * FROM cliente WHERE usuario_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Cliente cliente = new Cliente(
                    usuarioId,
                    dadosUsuario.getString("nome"),
                    dadosUsuario.getString("email"),
                    dadosUsuario.getString("senha"),
                    rs.getLong("id"),
                    rs.getString("endereco"));

                return cliente;
            }
        }
        return null;
    }

    private Funcionario buscarFuncionarioCompleto(int usuarioId, ResultSet dadosUsuario) throws SQLException {
        String sql = "SELECT * FROM funcionario WHERE usuario_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Funcionario funcionario = new Funcionario(
                    usuarioId,
                    dadosUsuario.getString("nome"),
                    dadosUsuario.getString("email"),
                    dadosUsuario.getString("senha"),
                    rs.getLong("id"),
                    rs.getString("departamento"));
 

                return funcionario;
            }
        }
        return null;
    }
}
