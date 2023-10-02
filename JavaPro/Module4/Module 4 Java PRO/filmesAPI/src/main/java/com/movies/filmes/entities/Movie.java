package com.movies.filmes.entities;

public class Movie {

    private Integer id;
    private String filme;
    private String diretor;
    private Integer ano;
    private Integer nota;


    public Movie(Integer id, String filme, String diretor, Integer ano, Integer nota) {
        this.id = id;
        this.filme = filme;
        this.diretor = diretor;
        this.ano = ano;
        this.nota = nota;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilme() {
        return filme;
    }

    public void setFilme(String filme) {
        this.filme = filme;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }
}
