package model;

import java.util.Date;
import model.enums.StatusDenuncia;

public class Denuncia {
    private long id;
    private String descricao;
    private StatusDenuncia status; 
    private Date data;
    private Transacao transferencia;

   
    public Denuncia(long id, String descricao, StatusDenuncia status, Date data, Transacao transferencia) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
        this.data = data;
        this.transferencia = transferencia;
    }

    public Denuncia(String descricao, StatusDenuncia status, Date data, Transacao transferencia) {
        this.descricao = descricao;
        this.status = status;
        this.data = data;
        this.transferencia = transferencia;
    }

    public Denuncia() {
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}


