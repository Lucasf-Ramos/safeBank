
package model;

import model.enums.StatusDenuncia;

public class Denuncia {
    private long id;
    private String descricao;
    protected StatusDenuncia status; 
    private Transacao transferencia;

   
    public Denuncia(long id, String descricao, StatusDenuncia status, Transacao transferencia) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
        this.transferencia = transferencia;
    }

    public Denuncia() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusDenuncia getStatus() {
        return status;
    }
    public void setStatus(StatusDenuncia status) {
        this.status = status;
    }

    public Transacao getTransferencia() {
        return transferencia;
    }
    public void setTransferencia(Transacao transferencia) {
        this.transferencia = transferencia;
    }

    public void setTransacao(Transacao transacao) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


