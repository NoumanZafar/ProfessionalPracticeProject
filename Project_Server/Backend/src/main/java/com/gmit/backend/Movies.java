package com.gmit.backend;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.movies.MoviesApplication;
import com.company.movies.database.movies.movie.Movie;
import com.company.movies.database.movies.movie.MovieImpl;
import com.company.movies.database.movies.movie.MovieManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.speedment.runtime.core.exception.SpeedmentException;

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
public class Movies {
	/**
	 * Interface {@link MovieManager}.
	 */
	private MovieManager movie;

	/**
	 * Constructor is used to connect to the table of movies database.
	 * 
	 * @param application Interface {@link MoviesApplication} of the whole database.
	 */
	public Movies(MoviesApplication application) {
		movie = application
				.getOrThrow(
						MovieManager.class);
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
		return movie
				.stream()
				.collect(Collectors
						.toList());
	}

	/**
	 * This method produce a POST HTTP request which is used to insert the data into
	 * database table called Movie. Request is produced on URI /movies/insert. This
	 * method gets the JSON data as string then change that string into JSON object
	 * and use the fields of JSON object to get the data for specific column of the
	 * table. Using {@link MovieImpl} data is inserted.
	 * 
	 * @param jsonData JSON Objects are taken as string
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public void insertMovie(@RequestBody String jsonData) {
		try {
			/**
			 * String is converted into JSON data and the JSON object is created
			 */
			JsonNode jsonObject = new ObjectMapper()
					.readTree(jsonData);

			movie.persist(new MovieImpl()
					/** Movie ID */
					.setMovieId(jsonObject
							.findValue("movieID")
							.asText())
					/** Movie Title */
					.setMovieTitle(jsonObject
							.findValue("movieTitle")
							.asText())
					/** Movie Description */
					.setMovieDesc(jsonObject
							.findValue("movieDesc")
							.asText())
					/** Movie Poster Image */
					.setMovieImg(generateImageBytes(jsonObject
							.findValue("movieImage")
							.asText()))
					/** Movie Trailer */
					.setTrailer(generateImageBytes(jsonObject
							.findValue("movieTrailer")
							.asText()))
					/** Movie Year Released */
					.setYearofrelease(jsonObject
							.findValue("movieReleaseYear")
							.asText())
					/** Movie Director */
					.setDirectorId(jsonObject
							.findValue("directorID")
							.asText()));
		} catch (final SpeedmentException | IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Get the Base64 String and convert the string into bytes array which
	 * equivalent to SQL's Blob.
	 * 
	 * @param base64String Base64 String of binary data.
	 * @return Decode the String into Byte array.
	 * @throws IOException Input/Output Exception
	 */
	public byte[] generateImageBytes(String base64String) throws IOException {
		return Base64
				.getMimeDecoder()
				.decode(base64String);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@CrossOrigin("*")
	public void deleteMovie(@RequestBody String jsonData) {
		try {
			/**
			 * String is converted into JSON data and the JSON object is created
			 */
			JsonNode jsonObject = new ObjectMapper()
					.readTree(jsonData);
			/*
			movie.stream()
				 .filter(Movie
						 .MOVIE_ID
						 .equalIgnoreCase(jsonObject
							.findValue("movieID")
							.asText()))
				.forEach(movie.remover());*/
			
			Optional<Movie> delete = movie.stream()
					.filter(Movie
							.MOVIE_ID
							.equalIgnoreCase(jsonObject
							.findValue("movieID")
							.asText()))
					.findFirst();
			delete.ifPresent(
					id -> movie
					.remove(id));

		} catch (final SpeedmentException | IOException ex) {
			ex.printStackTrace();
		}
	}
}
