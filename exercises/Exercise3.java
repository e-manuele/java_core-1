package com.example.exercises;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise3 {
	private static final MovieService movieService = InMemoryMovieService.getInstance();

	public static void main(String[] args) {
		// Find the number of genres of each director's movies
		List<DirectorGenresPair> directorGenresPairList =
				movieService.findAllDirectors()
				.stream()
				.map(x-> new DirectorGenresPair(x,
						movieService.findAllMoviesByDirectorId(x.getId())
								.stream()
								.flatMap(y-> y.getGenres().stream())
								.distinct()
								.toList()
						))
				.collect(Collectors.toList());
		directorGenresPairList.forEach(System.out::println);

}}