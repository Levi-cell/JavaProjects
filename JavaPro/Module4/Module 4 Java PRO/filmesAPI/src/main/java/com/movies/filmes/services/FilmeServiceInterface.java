package com.movies.filmes.services;

import com.movies.filmes.entities.Movie;

import java.util.List;

public interface FilmeServiceInterface {
    public List<Movie> findAll (String filme, String diretor);
    public Movie filtrarId(Integer id);
    public Movie cadastrar(final Movie movie);
    public void update (final Movie movie);
    public void remover(Integer id);

}
