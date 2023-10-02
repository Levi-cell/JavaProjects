package br.com.aula.atividade.services;

import br.com.aula.atividade.entities.Main;
import br.com.aula.atividade.repository.Repositorys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class Services {

    @Autowired
    private Repositorys repository;

    public List<Main> findAll(String nome, Integer idade){
        if(nome != null || idade != null){
            repository.findAll(nome, idade);
        }

        return repository.findAll();
    }

    public Main filtrar (Integer id){
       return repository.findById(id);
    }

    public Integer post(Main main) {
        if (main.getId() == null) {
            main.setId((repository.count() + 1));
        }
        repository.add(main);
        return main.getId();

    }

    public void update(Main main) {
     repository.update(main);


    }
    public void delete(Integer id ) {
       repository.delete(id);
    }

}
