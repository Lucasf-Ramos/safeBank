package DAO;

import model.Conta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ContaDAO {
    private final Connection conn;

    public ContaDAO() {
        this.conn = ConnectionFactory.getConnection();
    }

    public boolean criarConta(Conta conta) {
        String sql = "INSERT INTO conta (numero_conta, agencia, saldo, cliente_id) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, conta.getNumeroConta());
            stmt.setString(2, conta.getAgencia());
            stmt.setDouble(3, conta.getSaldo());
            stmt.setLong(4, conta.getClienteId());

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    public Conta buscarContaPorClienteId(long clienteId) {
        String sql = "SELECT * FROM conta WHERE cliente_id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, clienteId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Conta conta = new Conta(
                    rs.getLong("id"),
                    rs.getString("numero_conta"),
                    rs.getString("agencia"),
                    rs.getDouble("saldo"),
                    null // pode buscar e setar o cliente se necessário
                );
                
                return conta;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // se não encontrar
    }

    public boolean atualizarSaldo(long contaId, double novoSaldo) {
        String sql = "UPDATE conta SET saldo = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, novoSaldo);
            stmt.setLong(2, contaId);

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Conta buscarContaPorNumero(String numeroConta) {
        String sql = "SELECT * FROM conta WHERE numero_conta = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, numeroConta);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Conta(
                rs.getLong("id"),
                rs.getString("numero_conta"),
                rs.getString("agencia"),
                rs.getDouble("saldo"),
                null
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
