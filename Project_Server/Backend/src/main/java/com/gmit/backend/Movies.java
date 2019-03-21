package com.gmit.backend;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.movies.MoviesApplication;
import com.company.movies.database.movies.movie.Movie;
import com.company.movies.database.movies.movie.MovieManager;

/**
 * This controller provides the mapping to get the list of movies. Using
 * MovieManager interface connect to the table of the database and produce JSON
 * data.
 * 
 * @author Nouman
 * @version 1.0
 * @since 1.8
 *
 */
@RestController
@RequestMapping("/movies")
@CrossOrigin("*")
//@CrossOrigin(origins = "http://localhost:4200")
public class Movies {
	/**
	 * Interface.
	 */
	private MovieManager movie;

	/**
	 * Constructor is used to connect to the table of movies database.
	 * 
	 * @param application Interface of the whole database.
	 */
	public Movies(MoviesApplication application) {
		movie = application.getOrThrow(MovieManager.class);
	}

	/**
	 * This is the method which return the JSON data of the movies table. This
	 * method produce and accept only HTTP GET request where the mapping is
	 * movies/list. Binary data is converted into Byte[] and passed into the JSON
	 * array of data.
	 * 
	 * @return JSON data of the movies table.
	 */
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public List<Movie> getMovies() {
		return movie.stream()
					.collect(Collectors.toList());
	}
}