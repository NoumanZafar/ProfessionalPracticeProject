package com.company.movies.database.movies.director.generated;

import com.company.movies.database.movies.director.Director;
import com.company.movies.database.movies.director.DirectorImpl;
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
 * com.company.movies.database.movies.director.Director} entity.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public abstract class GeneratedDirectorSqlAdapter {
    
    private final TableIdentifier<Director> tableIdentifier;
    
    protected GeneratedDirectorSqlAdapter() {
        this.tableIdentifier = TableIdentifier.of("database", "movies", "director");
    }
    
    @ExecuteBefore(RESOLVED)
    void installMethodName(@WithState(RESOLVED) SqlStreamSupplierComponent streamSupplierComponent,
            @WithState(RESOLVED) SqlPersistenceComponent persistenceComponent) {
        streamSupplierComponent.install(tableIdentifier, this::apply);
        persistenceComponent.install(tableIdentifier);
    }
    
    protected Director apply(ResultSet resultSet) throws SpeedmentException {
        final Director entity = createEntity();
        try {
            entity.setDirectorId( resultSet.getString(1) );
            entity.setDirfname(   resultSet.getString(2) );
            entity.setDirsname(   resultSet.getString(3) );
        } catch (final SQLException sqle) {
            throw new SpeedmentException(sqle);
        }
        return entity;
    }
    
    protected DirectorImpl createEntity() {
        return new DirectorImpl();
    }
}