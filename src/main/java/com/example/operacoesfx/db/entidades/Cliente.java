package com.example.operacoesfx.db.entidades;

public class Cliente {
    private int id;
    private String nome;
    private long documento;
    private int cep;
    private String endereco, numero, cidade, uf, bairro, fone, email;
    private double juros;

    public Cliente(int id, String nome, long documento, int cep, String endereco, String numero, String cidade, String uf, String bairro, String fone, String email, double juros) {
        this.id = id;
        this.nome = nome;
        this.documento = documento;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.cidade = cidade;
        this.uf = uf;
        this.bairro = bairro;
        this.fone = fone;
        this.email = email;
        this.juros = juros;
    }

    public Cliente(String nome, long documento, int cep, String endereco, String numero, String cidade, String uf, String bairro, String fone, String email, double juros) {
        this.nome = nome;
        this.documento = documento;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.cidade = cidade;
        this.uf = uf;
        this.bairro = bairro;
        this.fone = fone;
        this.email = email;
        this.juros = juros;
    }

    public Cliente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    @Override
    public String toString() {
        return nome;
    }
}
