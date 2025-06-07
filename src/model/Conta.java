package model;

import java.util.Random;

public class Conta {
    private long id;
    private String numeroConta;
    private String agencia;
    private double saldo;
    private long clienteId;

    public Conta(long id, String numeroConta, String agencia, double saldo, long clienteId) {
        this.id = id;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.clienteId = clienteId;
    }
    
    public Conta(String numeroConta, String agencia, double saldo, long clienteId) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.clienteId = clienteId;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getNumeroConta() { return numeroConta; }
    public void setNumeroConta(String numeroConta) { this.numeroConta = numeroConta; }

    public String getAgencia() { return agencia; }
    public void setAgencia(String agencia) { this.agencia = agencia; }

    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }

    public long getClienteId() { return clienteId; }
    public void setClienteId(long clienteId) { this.clienteId = clienteId; }
    
    
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
