package model;


public class Cliente extends Usuario {
   
    protected long clienteId;
    protected String endereco;
    
    public Cliente(long id, String nome, String email, String senha, long clienteId, String endereco) {
        super(id, nome, email, senha);
        this.endereco = endereco;
        this.clienteId = clienteId;
    }
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
