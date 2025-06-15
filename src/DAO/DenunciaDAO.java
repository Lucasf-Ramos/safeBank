package DAO;

import model.Denuncia;
import model.Transacao;
import model.enums.StatusDenuncia;
import java.util.Date;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DenunciaDAO {
    private final Connection conn;

    public DenunciaDAO() {
        this.conn = ConnectionFactory.getConnection();
    }

    public boolean registrarDenuncia(Denuncia denuncia) {
        String sql = "INSERT INTO denuncias (descricao, status, data, transferencia_id) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, denuncia.getDescricao());
            stmt.setString(2, denuncia.getStatus().name());  // Pegando o nome do ENUM
            stmt.setTimestamp(3, new Timestamp(new Date().getTime()));
            stmt.setLong(4, denuncia.getTransferencia().getId());
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
                denuncia.setStatus(StatusDenuncia.valueOf(statusStr));

                long transacaoId = rs.getLong("transferencia_id");
                Transacao transacao = transacaoDAO.buscarTransacaoPorId(transacaoId);
                denuncia.setTransferencia(transacao);

                denuncias.add(denuncia);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar denúncias: " + e.getMessage());
        }

        return denuncias;
    }

    public Denuncia buscarPorId(long id) {
        String sql = "SELECT * FROM denuncias WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            TransacaoDAO transacaoDAO = new TransacaoDAO();

            if (rs.next()) {
                Denuncia denuncia = new Denuncia();
                denuncia.setId(rs.getLong("id"));
                denuncia.setDescricao(rs.getString("descricao"));
                denuncia.setData(rs.getDate("data"));
                denuncia.setStatus(StatusDenuncia.valueOf(rs.getString("status")));

                long transacaoId = rs.getLong("transferencia_id");
                Transacao transacao = transacaoDAO.buscarTransacaoPorId(transacaoId);
                denuncia.setTransferencia(transacao);

                return denuncia;
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar denúncia por ID: " + e.getMessage());
        }

        return null;
    }
   
    public boolean atualizarStatus(long id, StatusDenuncia novoStatus) {
        String sql = "UPDATE denuncias SET status = ? WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, novoStatus.name());
            stmt.setLong(2, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar status da denúncia: " + e.getMessage());
            return false;
        }
    }
    
    public List<Denuncia> listarDenunciasPorClienteId(long clienteId) {
        List<Denuncia> denuncias = new ArrayList<>();
        String sql = "SELECT d.id AS denuncia_id, d.descricao, d.status, d.transferencia_id " +
                     "FROM denuncias d " +
                     "JOIN transferencia t ON d.transferencia_id = t.id " +
                     "JOIN conta c ON t.conta_origem = c.id OR t.conta_destino = c.id " +
                     "WHERE c.cliente_id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, clienteId);
            ResultSet rs = stmt.executeQuery();
            TransacaoDAO transacaoDAO = new TransacaoDAO();

            while (rs.next()) {
                Denuncia denuncia = new Denuncia();
                denuncia.setId(rs.getLong("denuncia_id"));
                denuncia.setDescricao(rs.getString("descricao"));
                denuncia.setStatus(StatusDenuncia.valueOf(rs.getString("status")));

                long transacaoId = rs.getLong("transferencia_id");
                Transacao transacao = transacaoDAO.buscarTransacaoPorId(transacaoId);
                denuncia.setTransferencia(transacao);

                denuncias.add(denuncia);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar denúncias por cliente: " + e.getMessage());
        }
        return denuncias;
    }
}

