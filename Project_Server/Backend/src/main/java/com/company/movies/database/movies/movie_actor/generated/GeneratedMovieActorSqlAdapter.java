package com.company.movies.database.movies.movie_actor.generated;

import com.company.movies.database.movies.movie_actor.MovieActor;
import com.company.movies.database.movies.movie_actor.MovieActorImpl;
import com.speedment.common.annotation.GeneratedCode;
import com.speedment.common.injector.annotation.ExecuteBefore;
import com.speedment.common.injector.annotation.WithState;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.component.sql.SqlPersistenceComponent;
import com.speedment.runtime.core.component.sql.SqlStreamSupplierComponent;
import com.speedment.runtime.core.exception.SpeedmentException;
import java.sql.ResultSet;
import java.sql.SQLException;
import static com.speedment.common.injector.State.RESOLVED;

/**
 * The generated Sql Adapter for a {@link
 * com.company.movies.database.movies.movie_actor.MovieActor} entity.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public abstract class GeneratedMovieActorSqlAdapter {
    
    private final TableIdentifier<MovieActor> tableIdentifier;
    
    protected GeneratedMovieActorSqlAdapter() {
        this.tableIdentifier = TableIdentifier.of("database", "movies", "movie_actor");
    }
    
    @ExecuteBefore(RESOLVED)
    void installMethodName(@WithState(RESOLVED) SqlStreamSupplierComponent streamSupplierComponent,
            @WithState(RESOLVED) SqlPersistenceComponent persistenceComponent) {
        streamSupplierComponent.install(tableIdentifier, this::apply);
        persistenceComponent.install(tableIdentifier);
    }
    
    protected MovieActor apply(ResultSet resultSet) throws SpeedmentException {
        final MovieActor entity = createEntity();
        try {
            entity.setActorId( resultSet.getString(1) );
            entity.setMovieId( resultSet.getString(2) );
        } catch (final SQLException sqle) {
            throw new SpeedmentException(sqle);
        }
        return entity;
    }
    
    protected MovieActorImpl createEntity() {
        return new MovieActorImpl();
    }
}