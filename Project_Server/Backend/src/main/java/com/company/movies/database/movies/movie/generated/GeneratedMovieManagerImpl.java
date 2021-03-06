package com.company.movies.database.movies.movie.generated;

import com.company.movies.database.movies.movie.Movie;
import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.manager.AbstractManager;
import com.speedment.runtime.field.Field;
import java.util.stream.Stream;

/**
 * The generated base implementation for the manager of every {@link
 * com.company.movies.database.movies.movie.Movie} entity.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public abstract class GeneratedMovieManagerImpl extends AbstractManager<Movie> implements GeneratedMovieManager {
    
    private final TableIdentifier<Movie> tableIdentifier;
    
    protected GeneratedMovieManagerImpl() {
        this.tableIdentifier = TableIdentifier.of("database", "movies", "movie");
    }
    
    @Override
    public TableIdentifier<Movie> getTableIdentifier() {
        return tableIdentifier;
    }
    
    @Override
    public Stream<Field<Movie>> fields() {
        return Stream.of(
            Movie.MOVIE_ID,
            Movie.MOVIE_TITLE,
            Movie.MOVIE_DESC,
            Movie.MOVIE_IMG,
            Movie.TRAILER,
            Movie.YEAROFRELEASE,
            Movie.DIRECTOR_ID
        );
    }
    
    @Override
    public Stream<Field<Movie>> primaryKeyFields() {
        return Stream.of(
            Movie.MOVIE_ID
        );
    }
}