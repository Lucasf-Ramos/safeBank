
package DAO;

import model.Denuncia;
import model.Transacao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.enums.StatusDenuncia;

public class DenunciaDAO {
    private final Connection conn;

    public DenunciaDAO() {
        this.conn = ConnectionFactory.getConnection();
    }

    public boolean registrarDenuncia(Denuncia denuncia) {
        String sql = "INSERT INTO denuncias (descricao, status, transferencia_id) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, denuncia.getDescricao());
            stmt.setString(2, denuncia.getStatus().Status());
            stmt.setLong(3, denuncia.getTransferencia().getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao registrar denúncia: " + e.getMessage());
            return false;
        }
    }

   public List<Denuncia> listarTodas() {
    List<Denuncia> denuncias = new ArrayList<>();
    String sql = "SELECT * FROM denuncias";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        ResultSet rs = stmt.executeQuery();
        TransacaoDAO transacaoDAO = new TransacaoDAO();

        while (rs.next()) {
            Denuncia denuncia = new Denuncia();
            denuncia.setId(rs.getLong("id"));
            denuncia.setDescricao(rs.getString("descricao"));

            
            String statusStr = rs.getString("status");
            denuncia.setStatus(StatusDenuncia.valueOf(statusStr)); // converte String para enum

            long transacaoId = rs.getLong("transferencia_id");
            Transacao transacao = transacaoDAO.buscarTransacaoPorId(transacaoId);
            denuncia.setTransacao(transacao);

            denuncias.add(denuncia);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return denuncias;
}


    public boolean atualizarStatus(long id, String novoStatus) {
        String sql = "UPDATE denuncias SET status = ? WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, novoStatus);
            stmt.setLong(2, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar status da denúncia: " + e.getMessage());
            return false;
        }
    }
}
