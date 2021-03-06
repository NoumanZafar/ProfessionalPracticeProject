package com.company.movies.database.movies.genre.generated;

import com.company.movies.database.movies.genre.Genre;
import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.config.identifier.ColumnIdentifier;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.field.StringField;
import com.speedment.runtime.typemapper.TypeMapper;

/**
 * The generated base for the {@link
 * com.company.movies.database.movies.genre.Genre}-interface representing
 * entities of the {@code genre}-table in the database.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public interface GeneratedGenre {
    
    /**
     * This Field corresponds to the {@link Genre} field that can be obtained
     * using the {@link Genre#getGenreId()} method.
     */
    StringField<Genre, String> GENRE_ID = StringField.create(
        Identifier.GENRE_ID,
        Genre::getGenreId,
        Genre::setGenreId,
        TypeMapper.identity(), 
        true
    );
    /**
     * This Field corresponds to the {@link Genre} field that can be obtained
     * using the {@link Genre#getGenreType()} method.
     */
    StringField<Genre, String> GENRE_TYPE = StringField.create(
        Identifier.GENRE_TYPE,
        Genre::getGenreType,
        Genre::setGenreType,
        TypeMapper.identity(), 
        false
    );
    
    /**
     * Returns the genreId of this Genre. The genreId field corresponds to the
     * database column database.movies.genre.GENRE_ID.
     * 
     * @return the genreId of this Genre
     */
    String getGenreId();
    
    /**
     * Returns the genreType of this Genre. The genreType field corresponds to
     * the database column database.movies.genre.GENRE_TYPE.
     * 
     * @return the genreType of this Genre
     */
    String getGenreType();
    
    /**
     * Sets the genreId of this Genre. The genreId field corresponds to the
     * database column database.movies.genre.GENRE_ID.
     * 
     * @param genreId to set of this Genre
     * @return        this Genre instance
     */
    Genre setGenreId(String genreId);
    
    /**
     * Sets the genreType of this Genre. The genreType field corresponds to the
     * database column database.movies.genre.GENRE_TYPE.
     * 
     * @param genreType to set of this Genre
     * @return          this Genre instance
     */
    Genre setGenreType(String genreType);
    
    enum Identifier implements ColumnIdentifier<Genre> {
        
        GENRE_ID   ("GENRE_ID"),
        GENRE_TYPE ("GENRE_TYPE");
        
        private final String columnName;
        private final TableIdentifier<Genre> tableIdentifier;
        
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
            return "genre";
        }
        
        @Override
        public String getColumnName() {
            return this.columnName;
        }
        
        @Override
        public TableIdentifier<Genre> asTableIdentifier() {
            return this.tableIdentifier;
        }
    }
}