package com.company.movies.database.movies.actor.generated;

import com.company.movies.database.movies.actor.Actor;
import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.config.identifier.ColumnIdentifier;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.util.OptionalUtil;
import com.speedment.runtime.field.StringField;
import com.speedment.runtime.typemapper.TypeMapper;
import java.util.Optional;

/**
 * The generated base for the {@link
 * com.company.movies.database.movies.actor.Actor}-interface representing
 * entities of the {@code actor}-table in the database.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public interface GeneratedActor {
    
    /**
     * This Field corresponds to the {@link Actor} field that can be obtained
     * using the {@link Actor#getActorId()} method.
     */
    StringField<Actor, String> ACTOR_ID = StringField.create(
        Identifier.ACTOR_ID,
        Actor::getActorId,
        Actor::setActorId,
        TypeMapper.identity(), 
        true
    );
    /**
     * This Field corresponds to the {@link Actor} field that can be obtained
     * using the {@link Actor#getFirstName()} method.
     */
    StringField<Actor, String> FIRST_NAME = StringField.create(
        Identifier.FIRST_NAME,
        o -> OptionalUtil.unwrap(o.getFirstName()),
        Actor::setFirstName,
        TypeMapper.identity(), 
        false
    );
    /**
     * This Field corresponds to the {@link Actor} field that can be obtained
     * using the {@link Actor#getSurname()} method.
     */
    StringField<Actor, String> SURNAME = StringField.create(
        Identifier.SURNAME,
        o -> OptionalUtil.unwrap(o.getSurname()),
        Actor::setSurname,
        TypeMapper.identity(), 
        false
    );
    
    /**
     * Returns the actorId of this Actor. The actorId field corresponds to the
     * database column database.movies.actor.ACTOR_ID.
     * 
     * @return the actorId of this Actor
     */
    String getActorId();
    
    /**
     * Returns the firstName of this Actor. The firstName field corresponds to
     * the database column database.movies.actor.FIRST_NAME.
     * 
     * @return the firstName of this Actor
     */
    Optional<String> getFirstName();
    
    /**
     * Returns the surname of this Actor. The surname field corresponds to the
     * database column database.movies.actor.SURNAME.
     * 
     * @return the surname of this Actor
     */
    Optional<String> getSurname();
    
    /**
     * Sets the actorId of this Actor. The actorId field corresponds to the
     * database column database.movies.actor.ACTOR_ID.
     * 
     * @param actorId to set of this Actor
     * @return        this Actor instance
     */
    Actor setActorId(String actorId);
    
    /**
     * Sets the firstName of this Actor. The firstName field corresponds to the
     * database column database.movies.actor.FIRST_NAME.
     * 
     * @param firstName to set of this Actor
     * @return          this Actor instance
     */
    Actor setFirstName(String firstName);
    
    /**
     * Sets the surname of this Actor. The surname field corresponds to the
     * database column database.movies.actor.SURNAME.
     * 
     * @param surname to set of this Actor
     * @return        this Actor instance
     */
    Actor setSurname(String surname);
    
    enum Identifier implements ColumnIdentifier<Actor> {
        
        ACTOR_ID   ("ACTOR_ID"),
        FIRST_NAME ("FIRST_NAME"),
        SURNAME    ("SURNAME");
        
        private final String columnName;
        private final TableIdentifier<Actor> tableIdentifier;
        
        Identifier(String columnName) {
            this.columnName      = columnName;
            this.tableIdentifier = TableIdentifier.of(    getDbmsName(), 
                getSchemaName(), 
                getTableName());
        }
        
        @Override
        public String getDbmsName() {
            return "database";
        }
        
        @Override
        public String getSchemaName() {
            return "movies";
        }
        
        @Override
        public String getTableName() {
            return "actor";
        }
        
        @Override
        public String getColumnName() {
            return this.columnName;
        }
        
        @Override
        public TableIdentifier<Actor> asTableIdentifier() {
            return this.tableIdentifier;
        }
    }
}