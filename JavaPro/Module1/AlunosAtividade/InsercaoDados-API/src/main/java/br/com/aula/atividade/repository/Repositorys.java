package br.com.aula.atividade.repository;

import br.com.aula.atividade.entities.Main;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class Repositorys {
    private final List<Main> listDB;

    public Repositorys() {
        this.listDB = new ArrayList<>();
    }

    public List<Main> findAll(String nome, Integer idade) {
            return listDB.stream()
                    .filter(m -> m.getNome().contains(nome))
                    .filter(m-> m.getIdade() == idade)
                    .collect(Collectors.toList());

    }

    public List<Main> findAll() {
        return listDB;
    }

    public Main findById(Integer id){
       return listDB.stream().filter(l -> l.getId().equals(id))
                .findFirst()
                .orElse(null);

    }

    public void add(Main main){
        this.listDB.add(main);
    }

    public int count(){
        return listDB.size();
    }

    public void update(Main main){
        listDB.stream()
                .filter(nome -> nome.getId().equals(main.getId()))
                .forEach(nome -> nome.setNome(main.getNome()));
        listDB.stream().filter(n -> n.getId().equals(main.getId()))
                .forEach(n -> n.setIdade(main.getIdade()));
    }

    public void delete(Integer id) {
        listDB.removeIf(nome -> nome.getId().equals(id));
    }



}
