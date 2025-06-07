package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import model.Cliente;
import model.Conta;

public class ClienteDAO {
    private Connection conn;

    public ClienteDAO() {
        this.conn = ConnectionFactory.getConnection();
    }

    public boolean cadastrarClienteComConta(Cliente cliente) {
        if (emailJaExiste(cliente.getEmail())) {
            System.out.println("Email já cadastrado!");
            return false;
        }

        String sqlUsuario = "INSERT INTO usuario (nome, email, senha, tipo_usuario) VALUES (?, ?, ?, 'cliente')";
        String sqlCliente = "INSERT INTO cliente (usuario_id, endereco) VALUES (?, ?)";
        String sqlConta = "INSERT INTO conta (numero_conta, agencia, saldo, cliente_id) VALUES (?, ?, ?, ?)";

        try {
            conn.setAutoCommit(false); // Início da transação

            // Inserir na tabela usuario
            PreparedStatement stmtUsuario = conn.prepareStatement(sqlUsuario, Statement.RETURN_GENERATED_KEYS);
            stmtUsuario.setString(1, cliente.getNome());
            stmtUsuario.setString(2, cliente.getEmail());
            stmtUsuario.setString(3, cliente.getSenha());
            stmtUsuario.executeUpdate();

            ResultSet rsUsuario = stmtUsuario.getGeneratedKeys();
            if (rsUsuario.next()) {
                long usuarioId = rsUsuario.getLong(1);
                cliente.setId(usuarioId);
            } else {
                conn.rollback();
                return false;
            }

            // Inserir na tabela cliente
            PreparedStatement stmtCliente = conn.prepareStatement(sqlCliente, Statement.RETURN_GENERATED_KEYS);
            stmtCliente.setLong(1, cliente.getId());
            stmtCliente.setString(2, cliente.getEndereco());
            stmtCliente.executeUpdate();

            ResultSet rsCliente = stmtCliente.getGeneratedKeys();
            if (rsCliente.next()) {
                long clienteId = rsCliente.getLong(1);
                cliente.setClienteId(clienteId);
            } else {
                conn.rollback();
                return false;
            }

            // Criar e inserir conta associada ao cliente
            Conta conta = new Conta(
                Conta.gerarNumeroConta(), // método estático para gerar número
                Conta.gerarAgenciaAleatoria(), // agencia aleatoria
                0.0,                      // saldo inicial
                cliente.getClienteId()
            );

            PreparedStatement stmtConta = conn.prepareStatement(sqlConta);
            stmtConta.setString(1, conta.getNumeroConta());
            stmtConta.setString(2, conta.getAgencia());
            stmtConta.setDouble(3, conta.getSaldo());
            stmtConta.setLong(4, conta.getClienteId());

            stmtConta.executeUpdate();

            conn.commit(); // Confirma transação
            return true;

        } catch (SQLException e) {
            try {
                conn.rollback(); // Reverte alterações no banco se der erro
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;
        } finally {
            try {
                conn.setAutoCommit(true); // Restaura modo padrão
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Verifica se o email já está cadastrado
    private boolean emailJaExiste(String email) {
        String sql = "SELECT id FROM usuario WHERE email = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // true se encontrou
        } catch (SQLException e) {
            e.printStackTrace();
            return true; // por segurança, considera que já existe
        }
    }
}

