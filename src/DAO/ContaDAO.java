/*package DAO;

import model.Conta;
import java.sql.*;
import java.util.Random;

public class ContaDAO {
    private Connection conn;

    public ContaDAO() {
        this.conn = ConnectionFactory.getConnection();
    }
    
    public ContaDAO(Connection conn) {
    this.conn = conn;
    }

    public boolean criarConta(Conta conta) {
        String sql = "INSERT INTO conta (numero_conta, agencia, saldo, cliente_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, conta.getNumeroConta());
            stmt.setString(2, conta.getAgencia());
            stmt.setDouble(3, conta.getSaldo());
            stmt.setLong(4, conta.getClienteId());

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Conta buscarPorClienteId(long clienteId) {
        String sql = "SELECT * FROM conta WHERE cliente_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, clienteId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Conta(
                    rs.getLong("id"),
                    rs.getString("numero_conta"),
                    rs.getString("agencia"),
                    rs.getDouble("saldo"),
                    rs.getLong("cliente_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean atualizarSaldo(String numeroConta, double novoSaldo) {
        String sql = "UPDATE conta SET saldo = ? WHERE numero_conta = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, novoSaldo);
            stmt.setString(2, numeroConta);

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String gerarNumeroContaAleatorio() {
        Random random = new Random();
        String numeroConta;

        do {
            int partePrincipal = 100000 + random.nextInt(900000); // 6 dígitos
            int digitoVerificador = random.nextInt(10); // 0 a 9
            numeroConta = partePrincipal + "-" + digitoVerificador;
        } while (numeroContaExiste(numeroConta));

        return numeroConta;
    }

    public String gerarAgenciaAleatoria() {
        Random random = new Random();
        int agencia = 1000 + random.nextInt(9000); // 4 dígitos
        return String.valueOf(agencia);
    }

    private boolean numeroContaExiste(String numeroConta) {
        String sql = "SELECT 1 FROM conta WHERE numero_conta = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, numeroConta);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Se existe, retorna true
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true; // Em caso de erro, assume que existe para evitar duplicidade
    }
}*/

