package br.com.aula.atividade.entities;

public class Main {
    private Integer id;
    private String nome;
    private Integer idade;


    public Main(Integer id, String nome, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
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

    public void setNome(String nome) {
        this.nome = nome;
    }
}
