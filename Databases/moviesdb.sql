DROP DATABASE IF EXISTS MOVIES;
CREATE DATABASE MOVIES CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI;
SHOW DATABASES;
USE MOVIES;

CREATE TABLE DIRECTOR(
DIRECTOR_ID TINYINT UNSIGNED ZEROFILL,
DIRFNAME VARCHAR(25) NOT NULL,
DIRSNAME VARCHAR(35) NOT NULL,
PRIMARY KEY(DIRECTOR_ID))ENGINE=INNODB;

CREATE TABLE MOVIE( 
MOVIE_ID TINYINT UNSIGNED ZEROFILL,
MOVIE_TITLE VARCHAR(50) NOT NULL,
MOVIE_DESC VARCHAR(250),
MOVIE_IMG LONGBLOB DEFAULT NULL,  
TRAILER LONGBLOB DEFAULT NULL,            
YEAROFRELEASE YEAR(4), 
LIKES INTEGER DEFAULT 0,
DIRECTOR_ID TINYINT UNSIGNED ZEROFILL NOT NULL,
FOREIGN KEY (DIRECTOR_ID) REFERENCES DIRECTOR (DIRECTOR_ID) ON DELETE NULL ON UPDATE CASCADE,
PRIMARY KEY (MOVIE_ID))ENGINE=INNODB;

CREATE TABLE ACTOR(
ACTOR_ID TINYINT UNSIGNED ZEROFILL,
FIRST_NAME VARCHAR(25),
SURNAME VARCHAR(35),
PRIMARY KEY(ACTOR_ID))ENGINE=INNODB;

CREATE TABLE MOVIE_ACTOR(
ACTOR_ID TINYINT UNSIGNED ZEROFILL,
MOVIE_ID TINYINT UNSIGNED ZEROFILL,
FOREIGN KEY (ACTOR_ID) REFERENCES ACTOR(ACTOR_ID) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (MOVIE_ID) REFERENCES MOVIE(MOVIE_ID) ON DELETE CASCADE ON UPDATE CASCADE,
PRIMARY KEY (ACTOR_ID, MOVIE_ID))ENGINE=INNODB;

CREATE TABLE GENRE(
GENRE_ID TINYINT UNSIGNED ZEROFILL,
GENRE_TYPE VARCHAR(15) NOT NULL,
PRIMARY KEY(GENRE_ID))ENGINE=INNODB;

CREATE TABLE MOVIE_GENRE(
MOVIE_ID TINYINT UNSIGNED ZEROFILL,
GENRE_ID TINYINT UNSIGNED ZEROFILL,
FOREIGN KEY (MOVIE_ID) REFERENCES MOVIE(MOVIE_ID) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (GENRE_ID) REFERENCES GENRE(GENRE_ID) ON DELETE CASCADE ON UPDATE CASCADE,
PRIMARY KEY (MOVIE_ID, GENRE_ID))ENGINE=INNODB;

INSERT INTO DIRECTOR (DIRECTOR_ID,DIRFNAME,DIRSNAME) VALUES 
(1,'Steven','Spielberg'),
(2,'Christopher','Nolan'),
(3,'Martin','Scorsese'),
(4,'James','Cameron'),
(5,'David','Fincher'),
(6,'Brad','Bird'),
(7,'Guy','Ritchie'),
(8,'Mike','Mitchell')
(9,'David','Fincher');

INSERT INTO MOVIE (MOVIE_ID,MOVIE_TITLE,MOVIE_DESC,MOVIE_IMG,TRAILER,YEAROFRELEASE,LIKES,DIRECTOR_ID) VALUES 
(1,'The BFG','An orphan human girl befriends a benevolent giant, dubbed the "Big Friendly Giant", who takes her to Giant Country, 
where they attempt to stop the man-eating giants that are invading the human world.',LOAD_FILE(""),LOAD_FILE(""),'2016',0,1),
(2,'Lincoln','The film  covers the final four months of Lincoln''s life, focusing on his efforts in January 1865 to have the Thirteenth Amendment 
to the United States Constitution passed by the United States House of Representatives.',LOAD_FILE(""),LOAD_FILE(""),'2012',0,1),
(3,'Memento','A man''s story who, has amnesia and short-term memory loss every five minutes. He is searching for the persons who 
attacked him and killed his wife, using an intricate system of photographs and tattoos to track information he cannot remember.',
LOAD_FILE(""),LOAD_FILE(""),'2000',0,2),
(4,'The Prestige','The film story follows the two rival stage magicians in London at the end of the 19th century. Obsessed with creating the best stage illusion, 
they engage in competitive one-upmanship with tragic results and a renowned twist ending.',LOAD_FILE(""),LOAD_FILE(""),'2006',0,2),
(5,'Ratatouille','Story of an anthropomorphic rat who is interested in cooking, who befriends with garbage boy.',
LOAD_FILE(""),LOAD_FILE(""),'2007',0,6);

INSERT INTO ACTOR (ACTOR_ID,FIRST_NAME,SURNAME) VALUES ();
