package com.movies.filmes.repository;

import com.movies.filmes.entities.Movie;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MovieRepository {

    private final List<Movie> moviesList ;
    public MovieRepository(){
        this.moviesList = new ArrayList<>();
    }

    public void cadastrarFilme(Movie movie){
        this.moviesList.add(movie);
    }
    public int contador(){
        return moviesList.size();
    }

    public void remover(Integer id){
        moviesList.removeIf(i -> i.getId() == id);
    }

    public List<Movie> encontrarFilmeNome(final String filme ){

        return moviesList.stream().filter(flm -> flm.getFilme().equalsIgnoreCase(filme)).collect(Collectors.toList());
    }
    public List<Movie> encontrarFilmeDiretor(final  String diretor ){
        return moviesList.stream().filter(flm -> flm.getDiretor().equalsIgnoreCase(diretor)).collect(Collectors.toList());
    }
    public List<Movie> findAll(){
        return moviesList;
    }
    public Movie filtrarId(Integer id){
        return moviesList.stream().filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void atualizar(Movie movie){

        moviesList.stream()
                .filter(f->f.getId().equals(movie.getId()))
                .forEach(f->f.setFilme(movie.getFilme()));
        moviesList.stream()
                .filter(f->f.getId().equals(movie.getId()))
                .forEach(f->f.setDiretor(movie.getDiretor()));
        moviesList.stream()
                .filter(f->f.getId().equals(movie.getId()))
                .forEach(f->f.setAno(movie.getAno()));
        moviesList.stream()
                    .filter(f -> f.getId().equals(movie.getId()))
                    .forEach(f -> f.setNota(movie.getNota()));

    }

}
