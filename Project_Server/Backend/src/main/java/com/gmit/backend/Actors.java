package com.gmit.backend;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.movies.MoviesApplication;
import com.company.movies.database.movies.actor.Actor;
import com.company.movies.database.movies.actor.ActorManager;

@RestController
@RequestMapping("/actors")
@CrossOrigin("*")
public class Actors {
	private ActorManager actors;

	public Actors(MoviesApplication app) {
		actors = app.getOrThrow(ActorManager.class);
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public List<Actor> getActors() {
		return actors
				.stream()
				.collect(Collectors.toList());
	}
}
