package DAO;

import model.Conta;
import model.Transacao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransacaoDAO {
    private final Connection conn;

    public TransacaoDAO() {
        this.conn = ConnectionFactory.getConnection();
    }

    public boolean realizarTransferenciaPorNumeroConta(Transacao transacao) {
        String numeroOrigem = transacao.getContaOrigem().getNumeroConta();
        String numeroDestino = transacao.getContaDestino().getNumeroConta();
        double valor = transacao.getValor();

        if (numeroOrigem.equals(numeroDestino)) {
            System.out.println("Não é possível transferir para a mesma conta.");
            return false;
        }

        try {
            conn.setAutoCommit(false);

            ContaDAO contaDAO = new ContaDAO();
            Conta contaOrigem = contaDAO.buscarContaPorNumero(numeroOrigem);
            Conta contaDestino = contaDAO.buscarContaPorNumero(numeroDestino);

            if (contaOrigem == null || contaDestino == null) {
                System.out.println("Conta de origem ou destino não encontrada.");
                conn.rollback();
                return false;
            }

            if (contaOrigem.getSaldo() < valor) {
                System.out.println("Saldo insuficiente.");
                conn.rollback();
                return false;
            }

            boolean atualizouOrigem = contaDAO.atualizarSaldo(contaOrigem.getId(), contaOrigem.getSaldo() - valor);
            boolean atualizouDestino = contaDAO.atualizarSaldo(contaDestino.getId(), contaDestino.getSaldo() + valor);

            if (!atualizouOrigem || !atualizouDestino) {
                System.out.println("Erro ao atualizar saldos.");
                conn.rollback();
                return false;
            }

            String sql = "INSERT INTO transferencia (conta_origem, conta_destino, valor, data_transferencia, protocolo) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setLong(1, contaOrigem.getId());
                stmt.setLong(2, contaDestino.getId());
                stmt.setDouble(3, valor);
                stmt.setTimestamp(4, new Timestamp(new Date().getTime()));
                stmt.setLong(5, transacao.getProtocolo());
                stmt.executeUpdate();
            }

            conn.commit();
            return true;

        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
            return false;
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Transacao> listarTransferenciasPorContaId(Conta conta) {
        List<Transacao> transacoes = new ArrayList<>();
        String sql = "SELECT * FROM transferencia WHERE conta_origem = ? OR conta_destino = ? ORDER BY data_transferencia DESC";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, conta.getId());
            stmt.setLong(2, conta.getId());
            ResultSet rs = stmt.executeQuery();

            ContaDAO contaDAO = new ContaDAO();

            while (rs.next()) {
                Conta origem = contaDAO.buscarContaPorId(rs.getLong("conta_origem"));
                Conta destino = contaDAO.buscarContaPorId(rs.getLong("conta_destino"));
                double valor = rs.getDouble("valor");
                Date data = rs.getTimestamp("data_transferencia");
                long protocolo = rs.getLong("protocolo");

                Transacao transacao = new Transacao(
                    rs.getLong("id"),
                    origem,
                    destino,
                    valor,
                    data,
                    protocolo
                );

                transacoes.add(transacao);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        

        return transacoes;
    }
    
    public Transacao buscarTransacaoPorId(long id) {
        String sql = "SELECT * FROM transferencia WHERE id = ?";
         
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

        
            if (rs.next()) {
            ContaDAO contaDAO = new ContaDAO();
            Conta origem = contaDAO.buscarContaPorId(rs.getLong("conta_origem"));
            Conta destino = contaDAO.buscarContaPorId(rs.getLong("conta_destino"));

            return new Transacao(
                rs.getLong("id"),
                origem,
                destino,
                rs.getDouble("valor"),
                rs.getTimestamp("data_transferencia"),
                rs.getLong("protocolo")
            );
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null;
}

}