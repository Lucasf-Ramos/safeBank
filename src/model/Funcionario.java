package model;


public class Funcionario extends Usuario {
    
    protected long funcionarioId;
    protected String departamento;

    public Funcionario(long id, String nome, String email, String senha, long funcionarioId, String departamento) {
        super(id, nome, email, senha);
        this.funcionarioId = funcionarioId;
        this.departamento = departamento;
    }  
    
    public long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }
    
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
