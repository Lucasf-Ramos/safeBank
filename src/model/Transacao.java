package model;

import java.util.Date;
import java.util.Random;

public class Transacao {
    private long id;
    private Conta contaOrigem;
    private Conta contaDestino;
    private double valor;
    private Date data_transferencia;
    private long protocolo;

    

    public Transacao(long id, Conta contaOrigem, Conta contaDestino, double valor, Date data_transferencia, long protocolo) {
        this.id = id;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
        this.data_transferencia = data_transferencia;
        this.protocolo = protocolo;
    }

    public Transacao() {
        
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Conta getContaOrigem() {
        return contaOrigem;
    }
    public void setContaOrigem(Conta contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public Conta getContaDestino() {
        return contaDestino;
    }
    public void setContaDestino(Conta contaDestino) {
        this.contaDestino = contaDestino;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData_transferencia() {
        return data_transferencia;
    }

    public void setData_transferencia(Date data_transferencia) {
        this.data_transferencia = data_transferencia;
    }
    
    public long getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(long protocolo) {
        this.protocolo = protocolo;
    }
    
    public static long gerarNumeroProtocolo() {
        Random random = new Random();
        long protocolo = random.nextLong(9000) + 1000;   
        return protocolo;
    }
}