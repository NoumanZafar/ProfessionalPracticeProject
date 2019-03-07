package com.gmit.backend;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.movies.MoviesApplication;
import com.company.movies.database.movies.actor.Actor;
import com.company.movies.database.movies.actor.ActorManager;

@RestController
@RequestMapping("/test")
public class Test {
	private ActorManager manager;
	
	public Test(MoviesApplication app) {
		manager=app.getOrThrow(ActorManager.class);
	}
	
	@GetMapping("data")
	public List<Actor> getData(){
		return manager.stream()
				.collect(Collectors.toList());
	}
}
