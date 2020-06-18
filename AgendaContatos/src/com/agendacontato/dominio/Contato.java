package com.agendacontato.dominio;


public class Contato {
    private int id;
    private String nome;
    private String telefone;
    private int tipo;

    public Contato(String nome, String telefone, int tipo) {
        this.tipo = tipo;
        this.nome = nome;
        this.telefone = telefone;
    }

    public Contato() {
    }

    public Contato(int id) {
        this.id = id;
    }

    public Contato(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
