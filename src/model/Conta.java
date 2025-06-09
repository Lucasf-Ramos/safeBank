package model;

import java.util.Random;

public class Conta {
    private long id;
    private String numeroConta;
    private String agencia;
    private double saldo;
    private Cliente cliente;

    public Conta(String numeroConta, String agencia, double saldo, Cliente cliente) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public long getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getNumeroConta() {return numeroConta;}

    public String getAgencia() {return agencia;}

    public double getSaldo() {return saldo;}

    public Cliente getCliente() {return cliente;}
    public long getClienteId() {return cliente.getClienteId();}

    
    public static String gerarNumeroConta() {
        Random random = new Random();
        int parte1 = random.nextInt(900000) + 100000; // 6 dígitos
        int parte2 = random.nextInt(90) + 10;         // 2 dígitos
        return parte1 + "-" + parte2;
    }

    public static String gerarAgenciaAleatoria() {
        Random random = new Random();
        int agencia = random.nextInt(9000) + 1000; // Gera um número de 4 dígitos (1000 a 9999)
        return String.valueOf(agencia);
    }
}
