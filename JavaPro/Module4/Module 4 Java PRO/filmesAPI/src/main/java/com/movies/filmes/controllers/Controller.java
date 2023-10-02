package com.movies.filmes.controllers;

import com.movies.filmes.entities.Movie;
import com.movies.filmes.repository.MovieRepository;
import com.movies.filmes.services.FilmesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class Controller {

    @Autowired
    private FilmesServices services;
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public List<Movie> findAll(@RequestParam(required = false)String filme, String diretor){

       return services.findAll(filme, diretor);

    }
    @GetMapping("/{id}")
    public Movie filtrar(@PathVariable("id") Integer id){
        return services.filtrarId(id);
    }

    @PostMapping
    public ResponseEntity<Integer> post(@RequestBody final Movie movie) {

        if( movieRepository.findAll().stream().anyMatch(f->f.getFilme().equalsIgnoreCase(movie.getFilme())) &&
                movieRepository.findAll().stream().anyMatch(d->d.getDiretor().equalsIgnoreCase(movie.getDiretor()))){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "O filme já está cadastrado");
        }
        services.cadastrar(movie);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PatchMapping
    public ResponseEntity update (@RequestBody final Movie filme){
        if(filme.getNota() < 1 || filme.getNota() > 5){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Nota inválida, Insira um valor entre 1-5");
        }
        services.update(filme);
        final String atualizado = "Alteração feita com sucesso";
        return new ResponseEntity<>(atualizado,HttpStatus.NO_CONTENT);
    }
    @DeleteMapping
    public ResponseEntity remove(Integer id){
        services.remover(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}


