package com.example.exercises;

import java.util.List;
import java.util.stream.Stream;

import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise7 {
	private static final MovieService movieService = InMemoryMovieService.getInstance();

	public static void main(String[] args) {
		// Find the list of movies having the genres "Drama" and "Comedy" only
//		//Stream<Integer> resultingStream = Stream.concat(stream1, stream2);
		List<Movie> dramaOrComedyMovies =
				Stream.concat(
				movieService.findAllMoviesByGenre("Drama").stream(),
				movieService.findAllMoviesByGenre("Comedy").stream()
				).toList();

		dramaOrComedyMovies.forEach(System.out::println);
	}

}
