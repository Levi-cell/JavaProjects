package com.movies.filmes.services;

import com.movies.filmes.entities.Movie;
import com.movies.filmes.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FilmesServices implements FilmeServiceInterface{

    @Autowired
    private MovieRepository movieRepository;

   public List<Movie> findAll (String filme, String diretor){

    if(filme != null) {
        return movieRepository.encontrarFilmeNome(filme);
    } else if (diretor != null) {
        return movieRepository.encontrarFilmeDiretor(diretor);
    }
        return movieRepository.findAll();
}

    public Movie filtrarId(Integer id){
        return movieRepository.filtrarId(id);
    }

    public Movie cadastrar(final Movie movie) {

        if(movie.getNota() < 1 || movie.getNota() >5){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"Insira um valor entre 1-5");
        }

        if (movie.getId() == null) {
            movie.setId((movieRepository.contador() + 1));
        }
        movieRepository.cadastrarFilme(movie);
        return movie;
    }

    public void update (final Movie movie){
        movieRepository.atualizar(movie);
    }

    public void remover(Integer id){
        movieRepository.remover(id);
    }




}
