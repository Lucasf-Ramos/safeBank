package model.enums;

public enum StatusDenuncia {
    pendente,
    concluido,
    rejeitado;

    public String getDescricaoStatus() {
        switch (this) {
            case pendente: return "Pendente";
            case concluido: return "Concluído";
            case rejeitado: return "Rejeitado";
            default: return this.name();
        }
    }
}