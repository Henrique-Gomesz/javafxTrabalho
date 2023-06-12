package com.example.operacoesfx.db.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Operacao {
    private int id;
    private LocalDate data;
    private double juros;
    private double valorliq;
    private Cliente cliente;
    private List<Cheque> cheques;

    public Operacao(int id, LocalDate data, double juros, double valorliq, Cliente cliente) {
        this.id = id;
        this.data = data;
        this.juros = juros;
        this.valorliq = valorliq;
        this.cliente = cliente;
        cheques=new ArrayList();
    }

    public Operacao(LocalDate data, double juros, double valorliq, Cliente cliente) {
        this(0,data,juros,valorliq,cliente);
    }

    public Operacao() {
        this(0,LocalDate.now(),0,0,null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    public double getValorliq() {
        return valorliq;
    }

    public void setValorliq(double valorliq) {
        this.valorliq = valorliq;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cheque> getCheques() {
        return cheques;
    }
    public void addCheque(Cheque cheque)
    {
        cheques.add(cheque);
    }
}
