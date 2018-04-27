package com.app.movies.controler;

import com.app.movies.Mapper.MovieMapper;
import com.app.movies.Service.DbService;
import com.app.movies.domain.MovieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/movie")
public class MovieControler {

    @Autowired
    DbService service;

    @Autowired
    MovieMapper mapper;

    @RequestMapping(method = RequestMethod.GET, value = "getMovies")
    public List<MovieDto> getMovies() {
        return service.getMovies().stream()
                .map(movie -> mapper.mapToMovieDto(movie))
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getMovie")
    public MovieDto getMovie(@RequestParam("id") Long id) throws MovieNotFoundException {
        return mapper.mapToMovieDto(service.getMovieById(id));
        //@RequestParam zamiast @PathVariable
    }

    @RequestMapping(method = RequestMethod.POST, value = "createMovie", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createMovie(@RequestBody MovieDto movieDto) {
        service.saveMovie(mapper.mapToMovie(movieDto));
    }

//    @RequestMapping(method = RequestMethod.PUT, value = "updateMovie")
//    public MovieDto updateMovie(@RequestBody MovieDto movieDto) {
//        return mapper.mapToMovieDto(service.saveMovie(mapper.mapToMovie(movieDto)));
//    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteMovie" )
    public void deleteById(@RequestParam("id") Long id) {
        service.deleteMovieById(id);
    }
    //@RequestParam zamiast @PathVariable
}
