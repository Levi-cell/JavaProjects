package com.students.school;

public class Alunos {
    private Integer id;
    private String nome;
    private Integer idade;
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public int getIdade(){
        return idade;
    }
    public void setIdade(Integer idade){
        this.idade = idade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public String toString(){
        return this.getNome();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
