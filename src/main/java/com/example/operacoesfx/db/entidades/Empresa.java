package com.example.operacoesfx.db.entidades;

public class Empresa {
    private int id;

    private String razao;

    private String nomeFantasia;

    public Empresa(int id,String razao,String nomeFantasia){
        this.id = id;
        this.razao = razao;
        this.nomeFantasia = nomeFantasia;
    }
    public Empresa(String razao,String nomeFantasia){
        this.razao = razao;
        this.nomeFantasia = nomeFantasia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }




}
