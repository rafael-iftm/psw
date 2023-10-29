package br.edu.iftm.tspi.cadastro.domain;

import lombok.Data;

@Data
public class Cadastro {

    private String nome;
    private String email;

    public Cadastro() {

    }

    public Cadastro(String email, String nome) {
        this.email = email;
        this.nome = nome;
    }
}