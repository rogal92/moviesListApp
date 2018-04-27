package com.app.movies.repository;

import com.app.movies.domain.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends CrudRepository<Movie, Long> {

    @Override
    Movie save(Movie movie);

    @Override
    Optional<Movie> findById(Long id);

    @Override
    List<Movie> findAll();

    @Override
    void deleteById(Long id);
}
