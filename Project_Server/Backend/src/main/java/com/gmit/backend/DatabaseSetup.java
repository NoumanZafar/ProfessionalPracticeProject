package com.gmit.backend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.company.movies.MoviesApplication;
import com.company.movies.MoviesApplicationBuilder;

/**
 * This class is a configuration beans and solely purpose of the class
 * to connect to database on the cloud and produce JSON format data for
 * inputs and outputs for the client and from the client application using
 * Jackson2
 * 
 * @author Nouman Zafar
 * @version 1.0
 * @since 1.8
 *
 */
@Configuration
public class DatabaseSetup {
	/**
	 * This method is used as Bean to connect to database on cloud. This bean takes
	 * the USERNAME and PASSWORD in order to connect to cloud machine's WAMP server
	 * and access the database.
	 * 
	 * @return Connection to database.
	 */
	@Bean
	public MoviesApplication createConnection() {
		return new MoviesApplicationBuilder()
				.withUsername("nouman")
				.withPassword("nouman")
				.build();
	}

	/**
	 * This bean is used to produce inputs and outputs of the application in JSON
	 * format
	 * 
	 * @return JSON format data (inputs from client and outputs to the client
	 *         application)
	 */
	@Bean
	public Jackson2ObjectMapperBuilder jacksonBuilder() {
		return new Jackson2ObjectMapperBuilder()
				.indentOutput(true);
	}
}