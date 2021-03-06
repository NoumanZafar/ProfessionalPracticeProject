package com.company.movies.database.movies.genre.generated;

import com.company.movies.database.movies.genre.Genre;
import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.manager.AbstractManager;
import com.speedment.runtime.field.Field;
import java.util.stream.Stream;

/**
 * The generated base implementation for the manager of every {@link
 * com.company.movies.database.movies.genre.Genre} entity.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public abstract class GeneratedGenreManagerImpl extends AbstractManager<Genre> implements GeneratedGenreManager {
    
    private final TableIdentifier<Genre> tableIdentifier;
    
    protected GeneratedGenreManagerImpl() {
        this.tableIdentifier = TableIdentifier.of("database", "movies", "genre");
    }
    
    @Override
    public TableIdentifier<Genre> getTableIdentifier() {
        return tableIdentifier;
    }
    
    @Override
    public Stream<Field<Genre>> fields() {
        return Stream.of(
            Genre.GENRE_ID,
            Genre.GENRE_TYPE
        );
    }
    
    @Override
    public Stream<Field<Genre>> primaryKeyFields() {
        return Stream.of(
            Genre.GENRE_ID
        );
    }
}