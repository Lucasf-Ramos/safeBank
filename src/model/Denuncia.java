
package model;

import model.enums.StatusDenuncia;

public class Denuncia {
    private long id;
    private String descricao;
    private StatusDenuncia status; 
    private long transferenciaId;


    public Denuncia(long id, String descricao, StatusDenuncia status, long transferenciaId) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
        this.transferenciaId = transferenciaId;
    }

    public Denuncia(String descricao, StatusDenuncia status, long transferenciaId) {
        this.descricao = descricao;
        this.status = status;
        this.transferenciaId = transferenciaId;
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

    public long getTransferenciaId() {
        return transferenciaId;
    }
    public void setTransferenciaId(long transferenciaId) {
        this.transferenciaId = transferenciaId;
    }
}


