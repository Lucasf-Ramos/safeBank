
package DAO;

import model.Denuncia;
import model.enums.StatusDenuncia;
import model.Transacao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    private final Connection conn;

    public FuncionarioDAO() {
        this.conn = ConnectionFactory.getConnection();
    }

    // 1. Visualizar todas as denúncias com detalhes da transação
    public List<Denuncia> listarTodasDenuncias() {
        List<Denuncia> denuncias = new ArrayList<>();
        String sql = """
            SELECT d.id AS denuncia_id, d.descricao, d.status, 
                   t.id AS transacao_id, t.conta_origem, t.conta_destino, 
                   t.valor, t.data_transferencia, t.protocolo
            FROM denuncias d
            JOIN transferencia t ON d.transferencia_id = t.id
            ORDER BY d.status, d.id
        """;

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            ContaDAO contaDAO = new ContaDAO();

            while (rs.next()) {
                Transacao transacao = new Transacao();
                transacao.setId(rs.getLong("transacao_id"));
                transacao.setContaOrigem(contaDAO.buscarContaPorId(rs.getLong("conta_origem")));
                transacao.setContaDestino(contaDAO.buscarContaPorId(rs.getLong("conta_destino")));
                transacao.setValor(rs.getDouble("valor"));
                transacao.setData_transferencia(rs.getTimestamp("data_transferencia"));
                transacao.setProtocolo(rs.getLong("protocolo"));

                Denuncia denuncia = new Denuncia();
                denuncia.setId(rs.getLong("denuncia_id"));
                denuncia.setDescricao(rs.getString("descricao"));
                denuncia.setStatus(StatusDenuncia.valueOf(rs.getString("status")));
                denuncia.setTransacao(transacao);

                denuncias.add(denuncia);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return denuncias;
    }

    // 2. Atualizar o status de uma denúncia
    public boolean atualizarStatusDenuncia(long denunciaId, StatusDenuncia novoStatus) {
        String sql = "UPDATE denuncias SET status = ? WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, novoStatus.name());
            stmt.setLong(2, denunciaId);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

