package com.company.movies.generated;

import com.company.movies.MoviesApplication;
import com.company.movies.MoviesApplicationBuilder;
import com.company.movies.database.movies.actor.Actor;
import com.company.movies.database.movies.actor.ActorManager;
import com.company.movies.database.movies.director.Director;
import com.company.movies.database.movies.director.DirectorManager;
import com.company.movies.database.movies.genre.Genre;
import com.company.movies.database.movies.genre.GenreManager;
import com.company.movies.database.movies.movie.Movie;
import com.company.movies.database.movies.movie.MovieManager;
import com.company.movies.database.movies.movie_actor.MovieActor;
import com.company.movies.database.movies.movie_actor.MovieActorManager;
import com.company.movies.database.movies.movie_genre.MovieGenre;
import com.company.movies.database.movies.movie_genre.MovieGenreManager;
import com.speedment.common.annotation.GeneratedCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 * The spring configuration file
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public class GeneratedMoviesConfiguration {
    
    protected final static String URL_PROPERTY = "jdbc.url";
    protected final static String USERNAME_PROPERTY = "jdbc.username";
    protected final static String PASSWORD_PROPERTY = "jdbc.password";
    protected @Autowired Environment env;
    
    @Bean
    public MoviesApplication getApplication() {
        final MoviesApplicationBuilder builder =
            new MoviesApplicationBuilder();
        
        if (env.containsProperty(URL_PROPERTY)) {
            builder.withConnectionUrl(env.getProperty(URL_PROPERTY));
        }
        
        if (env.containsProperty(USERNAME_PROPERTY)) {
            builder.withUsername(env.getProperty(USERNAME_PROPERTY));
        }
        
        if (env.containsProperty(PASSWORD_PROPERTY)) {
            builder.withPassword(env.getProperty(PASSWORD_PROPERTY));
        }
        
        return builder.build();
    }
    
    @Bean
    public ActorManager getActorManager(MoviesApplication app) {
        return app.getOrThrow(ActorManager.class);
    }
    
    @Bean
    public DirectorManager getDirectorManager(MoviesApplication app) {
        return app.getOrThrow(DirectorManager.class);
    }
    
    @Bean
    public GenreManager getGenreManager(MoviesApplication app) {
        return app.getOrThrow(GenreManager.class);
    }
    
    @Bean
    public MovieManager getMovieManager(MoviesApplication app) {
        return app.getOrThrow(MovieManager.class);
    }
    
    @Bean
    public MovieActorManager getMovieActorManager(MoviesApplication app) {
        return app.getOrThrow(MovieActorManager.class);
    }
    
    @Bean
    public MovieGenreManager getMovieGenreManager(MoviesApplication app) {
        return app.getOrThrow(MovieGenreManager.class);
    }
}