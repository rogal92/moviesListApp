package com.app.movies.Service;

import com.app.movies.controler.MovieNotFoundException;
import com.app.movies.domain.Movie;
import com.app.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbService {
    @Autowired
    public MovieRepository repository;

    public List<Movie> getMovies() {
        return repository.findAll();
    }

    public Movie getMovieById(Long id) throws MovieNotFoundException {
        return repository.findById(id).orElseThrow(MovieNotFoundException::new);
    }

    public Movie saveMovie(final Movie movie) {
        return repository.save(movie);
    }

    public void deleteMovieById(Long id) {
        repository.deleteById(id);
    }
}
