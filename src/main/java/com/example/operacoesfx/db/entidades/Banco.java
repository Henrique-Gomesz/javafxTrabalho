package com.example.operacoesfx.db.entidades;

public class Banco {
    private int id;
    private int numero;
    private String nome;

    public Banco() {
        this(0,0,"");
    }

    public Banco(int id, int numero, String nome) {
        this.id = id;
        this.numero = numero;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
