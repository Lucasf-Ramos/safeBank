package model;


public class Cliente extends Usuario {
   
    protected long clienteId;
    protected String endereco;
    
    public Cliente(long id, String nome, String email, String senha, long clienteId, String endereco) {
        super(id, nome, email, senha);
        this.clienteId = clienteId;
        this.endereco = endereco;
    }

    public Cliente(String nome, String email, String senha, String endereco) {
        super(0, nome, email, senha);
        this.endereco = endereco;
    }

    public long getClienteId() {
        return clienteId;
    }

    public void setClienteId(long clienteId) {
        this.clienteId = clienteId;
    }
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
