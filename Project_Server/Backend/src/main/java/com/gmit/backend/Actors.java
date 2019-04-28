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
import com.company.movies.database.movies.actor.Actor;
import com.company.movies.database.movies.actor.ActorImpl;
import com.company.movies.database.movies.actor.ActorManager;
import com.company.movies.database.movies.movie.Movie;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.speedment.runtime.core.exception.SpeedmentException;

/**
 * This class is a REST Controller which allows to connect to databases table
 * called Actor.
 * 
 * @author Nouman
 * @version 1.0
 * @since 1.8
 *
 */
@RestController
@RequestMapping("/actors")
/**
 * Allow the browser to get the requests from different platforms and pass the
 * requests on.
 *
 */
@CrossOrigin("*")
public class Actors {
	/**
	 * Manager of the table called Actor.
	 */
	private ActorManager actors;

	/**
	 * Connect to the table using Database interface {@link MoviesApplication}
	 * 
	 * @param app {@link MoviesApplication}
	 */
	public Actors(MoviesApplication app) {
		actors = app
				.getOrThrow(
						ActorManager.class);
	}

	/**
	 * This method produce a GET request and fetch all the data from Actor table and
	 * add that data into list. to access the data use the path provided
	 * /actors/list
	 * 
	 * @return list of actors fetched from database table.
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Actor> getActors() {
		return actors.stream()
				.collect(
						Collectors
						.toList());
	}

	/**
	 * This method produce a POST HTTP request using URI /actors/insert. After
	 * getting the data from client side on the URI as string change that data to
	 * JSON and then make a JSON object and from that JSON object fetch the
	 * different fields. Using the {@link ActorManager} Interface and in that
	 * Interface method called persist create a new Object of Actor using
	 * {@link ActorImpl} and set the fields with the data from JSON Object.
	 * 
	 * @param jsonData JSON data as string from client side.
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insertActor(@RequestBody String jsonData) {
		try {
			JsonNode jsonObject = new ObjectMapper()
					.readTree(jsonData);
			
			actors.persist(new ActorImpl()
					/** Actor ID */
					.setActorId(jsonObject
							.findValue("actorID")
							.asText())
					/** Actor First Name */
					.setFirstName(jsonObject
							.findValue("actorFname")
							.asText())
					/** Actor Surname */
					.setSurname(jsonObject
							.findValue("actorSurname")
							.asText())
					/** Actor Picture */
					.setPicture(generateImageBytes(jsonObject
							.findValue("picture")
							.asText())));
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
			actors.stream()
				 .filter(Actor
						 .ACTOR_ID
						 .equalIgnoreCase(jsonObject
							.findValue("actorID")
							.asText()))
				.forEach(actors .remover());*/
			
			Optional<Actor> delete = actors.stream()
					.filter(Actor
							.ACTOR_ID
							.equalIgnoreCase(jsonObject
							.findValue("actorID")
							.asText()))
					.findFirst();
			delete.ifPresent(
					id -> actors
					.remove(id));

		} catch (final SpeedmentException | IOException ex) {
			ex.printStackTrace();
		}
	}
}
