package com.example.exercises;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.domain.Director;
import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;


/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class Exercise1 {
    private static final MovieService movieService = InMemoryMovieService.getInstance();

    public static void main(String[] args) {
        // Find the number of movies of each director
        Collection<Director> directorCollection = movieService.findAllDirectors();

		Collection<Movie> movieList =  movieService.findAllMovies();
        Map<Object, Long> countedDirector =
				movieList
                        .stream()
						.flatMap(x->x.getDirectors().stream())
						.collect(groupingBy(Director::getName,Collectors.counting()));
       System.out.println(countedDirector);
    }
}
