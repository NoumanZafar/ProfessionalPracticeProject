package com.company.movies.database.movies.genre.generated;

import com.company.movies.database.movies.genre.Genre;
import com.company.movies.database.movies.genre.GenreImpl;
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
 * com.company.movies.database.movies.genre.Genre} entity.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public abstract class GeneratedGenreSqlAdapter {
    
    private final TableIdentifier<Genre> tableIdentifier;
    
    protected GeneratedGenreSqlAdapter() {
        this.tableIdentifier = TableIdentifier.of("database", "movies", "genre");
    }
    
    @ExecuteBefore(RESOLVED)
    void installMethodName(@WithState(RESOLVED) SqlStreamSupplierComponent streamSupplierComponent,
            @WithState(RESOLVED) SqlPersistenceComponent persistenceComponent) {
        streamSupplierComponent.install(tableIdentifier, this::apply);
        persistenceComponent.install(tableIdentifier);
    }
    
    protected Genre apply(ResultSet resultSet) throws SpeedmentException {
        final Genre entity = createEntity();
        try {
            entity.setGenreId(   resultSet.getString(1) );
            entity.setGenreType( resultSet.getString(2) );
        } catch (final SQLException sqle) {
            throw new SpeedmentException(sqle);
        }
        return entity;
    }
    
    protected GenreImpl createEntity() {
        return new GenreImpl();
    }
}