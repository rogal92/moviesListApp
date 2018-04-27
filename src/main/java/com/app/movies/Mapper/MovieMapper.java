package com.app.movies.Mapper;

import com.app.movies.domain.Movie;
import com.app.movies.domain.MovieDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieMapper {

    public Movie mapToMovie(final MovieDto movieDto) {
        return new Movie(
                movieDto.getId(),
                movieDto.getTitle(),
                movieDto.getAuthor(),
                movieDto.getGenre(),
                movieDto.getProduction());
    }

    public MovieDto mapToMovieDto(final Movie movie) {
        return new MovieDto(
                movie.getId(),
                movie.getTitle(),
                movie.getAuthor(),
                movie.getGenre(),
                movie.getProduction());
    }

    public List<MovieDto> mapToMovieListDto(final List<Movie> movieList) {
        return movieList.stream()
                .map(movie -> new MovieDto(
                        movie.getId(),
                        movie.getTitle(),
                        movie.getAuthor(),
                        movie.getGenre(),
                        movie.getProduction()))
                .collect(Collectors.toList());
    }
}
