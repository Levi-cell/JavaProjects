package br.com.aula.atividade.controllers;

import br.com.aula.atividade.entities.Main;
import br.com.aula.atividade.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RestController
@RequestMapping("/atividade")
public class Controller {


    @Autowired
    private Services services;


    @GetMapping
    public List<Main> findAll(@RequestParam(required = false) String nome, Integer idade){
       return services.findAll(nome,idade);

    }

    @GetMapping("/{id}")
    public Main filtrar(@PathVariable("id") Integer id){
        return services.filtrar(id);
    }


    @PostMapping
    public ResponseEntity<Integer> post(@RequestBody Main inicio){
        Integer id = services.post(inicio);
        return new ResponseEntity<>(id,HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity update(@RequestBody Main inicio){
        services.update(inicio);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id ){
        services.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
