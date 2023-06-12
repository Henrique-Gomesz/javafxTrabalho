package com.example.operacoesfx.db.entidades;

import java.time.LocalDate;

public class Cheque {
    private int id,agencia,conta;
    private long documento;
    private String correntista;
    private double valor;
    private LocalDate data;
    private Banco banco;

    public Cheque() {
    }

    public Cheque(int id, int agencia, int conta, long documento, String correntista, double valor, LocalDate data, Banco banco) {
        this.id = id;
        this.agencia = agencia;
        this.conta = conta;
        this.documento = documento;
        this.correntista = correntista;
        this.valor = valor;
        this.data = data;
        this.banco = banco;
    }

    public Cheque(int agencia, int conta, long documento, String correntista, double valor, LocalDate data, Banco banco) {
        this.agencia = agencia;
        this.conta = conta;
        this.documento = documento;
        this.correntista = correntista;
        this.valor = valor;
        this.data = data;
        this.banco = banco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public String getCorrentista() {
        return correntista;
    }

    public void setCorrentista(String correntista) {
        this.correntista = correntista;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

}
