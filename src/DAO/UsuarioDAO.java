package DAO;

import model.Usuario;
import model.Cliente;
import model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    private Connection conn;

    public UsuarioDAO() {
        this.conn = ConnectionFactory.getConnection();
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
