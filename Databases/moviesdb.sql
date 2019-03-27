DROP DATABASE IF EXISTS MOVIES;
CREATE DATABASE MOVIES CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI;
SHOW DATABASES;
USE MOVIES;

DROP TABLE IF EXISTS DIRECTOR;
CREATE TABLE DIRECTOR(
DIRECTOR_ID VARCHAR(6),
DIRFNAME VARCHAR(25) NOT NULL,
DIRSNAME VARCHAR(35) NOT NULL,
PICTURE LONGBLOB DEFAULT NULL,
PRIMARY KEY(DIRECTOR_ID))ENGINE=INNODB;

DROP TABLE IF EXISTS MOVIE;
CREATE TABLE MOVIE( 
MOVIE_ID VARCHAR(6),
MOVIE_TITLE VARCHAR(50) NOT NULL,
MOVIE_DESC VARCHAR(250),
MOVIE_IMG LONGBLOB DEFAULT NULL,  
TRAILER LONGBLOB DEFAULT NULL,            
YEAROFRELEASE CHAR(4), 
DIRECTOR_ID VARCHAR(6) NOT NULL,
FOREIGN KEY (DIRECTOR_ID) REFERENCES DIRECTOR (DIRECTOR_ID) ON DELETE CASCADE ON UPDATE CASCADE,
PRIMARY KEY (MOVIE_ID))ENGINE=INNODB;

DROP TABLE IF EXISTS ACTOR;
CREATE TABLE ACTOR(
ACTOR_ID VARCHAR(6),
FIRST_NAME VARCHAR(25),
SURNAME VARCHAR(35),
PICTURE LONGBLOB DEFAULT NULL,
PRIMARY KEY(ACTOR_ID))ENGINE=INNODB;

DROP TABLE IF EXISTS MOVIE_ACTOR;
CREATE TABLE MOVIE_ACTOR(
ACTOR_ID VARCHAR(6),
MOVIE_ID VARCHAR(6),
FOREIGN KEY (ACTOR_ID) REFERENCES ACTOR(ACTOR_ID) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (MOVIE_ID) REFERENCES MOVIE(MOVIE_ID) ON DELETE CASCADE ON UPDATE CASCADE,
PRIMARY KEY (ACTOR_ID, MOVIE_ID))ENGINE=INNODB;

DROP TABLE IF EXISTS GENRE;
CREATE TABLE GENRE(
GENRE_ID VARCHAR(6),
GENRE_TYPE VARCHAR(35) NOT NULL,
PRIMARY KEY(GENRE_ID))ENGINE=INNODB;

DROP TABLE IF EXISTS MOVIE_GENRE;
CREATE TABLE MOVIE_GENRE(
MOVIE_ID VARCHAR(6),
GENRE_ID VARCHAR(6),
FOREIGN KEY (MOVIE_ID) REFERENCES MOVIE(MOVIE_ID) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (GENRE_ID) REFERENCES GENRE(GENRE_ID) ON DELETE CASCADE ON UPDATE CASCADE,
PRIMARY KEY (MOVIE_ID, GENRE_ID))ENGINE=INNODB;

INSERT INTO DIRECTOR (DIRECTOR_ID,DIRFNAME,DIRSNAME,PICTURE) VALUES 
('1','Steven','Spielberg',LOAD_FILE("C:/directors/StevenSpielberg.jpg")),
('2','Christopher','Nolan',LOAD_FILE("C:/directors/christopher.jpg")),
('3','Martin','Scorsese',LOAD_FILE("C:/directors/martin.jpg")),
('4','James','Cameron',LOAD_FILE("C:/directors/jamesCameron.jpg")),
('5','David','Fincher',LOAD_FILE("C:/directors/davidFincher.jpg")),
('6','Brad','Bird',LOAD_FILE("C:/directors/bradBird.jpg")),
('7','Guy','Ritchie',LOAD_FILE("C:/directors/guy.jpg")),
('8','Mike','Mitchell',LOAD_FILE("C:/directors/mike.jpg"));

INSERT INTO MOVIE (MOVIE_ID,MOVIE_TITLE,MOVIE_DESC,MOVIE_IMG,TRAILER,YEAROFRELEASE,DIRECTOR_ID) VALUES 
('1','The BFG','An orphan human girl befriends a benevolent giant, dubbed the "Big Friendly Giant", who takes her to Giant Country, 
where they attempt to stop the man-eating giants that are invading the human world.',LOAD_FILE("C:/posters_and_trailers/bfg.jpg"),LOAD_FILE("C:/posters_and_trailers/bfg_trailer.mp4"),'2016',1),
('2','Lincoln','The film  covers the final four months of Lincoln''s life, focusing on his efforts in January 1865 to have the Thirteenth Amendment 
to the United States Constitution passed by the United States House of Representatives.',LOAD_FILE("C:/posters_and_trailers/linclon.jpg"),LOAD_FILE("C:/posters_and_trailers/linclon_trailer.mp4"),'2012',1),
('3','Memento','A man''s story who, has amnesia and short-term memory loss every five minutes. He is searching for the persons who 
attacked him and killed his wife, using an intricate system of photographs and tattoos to track information he cannot remember.',
LOAD_FILE("C:/posters_and_trailers/memento.jpg"),LOAD_FILE("C:/posters_and_trailers/memento_trailer.mp4"),'2000',2),
('4','The Prestige','The film story follows the two rival stage magicians in London at the end of the 19th century. Obsessed with creating the best stage illusion, 
they engage in competitive one-upmanship with tragic results and a renowned twist ending.',LOAD_FILE("C:/posters_and_trailers/prestige.jpg"),LOAD_FILE("C:/posters_and_trailers/prestige_trailer.mp4"),'2006',2),
('5','Ratatouille','Story of an anthropomorphic rat who is interested in cooking, who befriends with garbage boy.',
LOAD_FILE("C:/posters_and_trailers/ratatouille.jpg"),LOAD_FILE("C:/posters_and_trailers/rat_trailer.mp4"),'2007',6);

INSERT INTO ACTOR (ACTOR_ID,FIRST_NAME,SURNAME,PICTURE) VALUES 
('1','Mark','Rylance',LOAD_FILE("C:/actors/markRyalance.jpg")),
('2','Ruby','Barnhill',LOAD_FILE("C:/actors/RubyBarnhill.jpg")),
('3','Penelope','Wilton',LOAD_FILE("C:/actors/penelopeWilton.jpg")),
('4','Jemaine','Clement',LOAD_FILE("C:/actors/JemainClement.jpg")),
('5','Rebecca','Hall',LOAD_FILE("C:/actors/RebeccaHall.jpg")),
('6','Rafe','Spall',LOAD_FILE("C:/actors/RafeSpall.jpg")),
('7','Bill','Hader',LOAD_FILE("C:/actors/BillHader.jpg")),

('8','Daniel','Day-Lewis',LOAD_FILE("C:/actors/danielDayLewis.jpg")),
('9','Sally','Field',LOAD_FILE("C:/actors/SallyField.jpg")),
('10','David','Strathaim',LOAD_FILE("C:/actors/DavidStrathaim.jpg")),
('11','Joseph','Gordon-Levitt',LOAD_FILE("C:/actors/JosephGordonLevitt.jpg")),
('12','James','Spader',LOAD_FILE("C:/actors/JamesSpader.jpg")),
('13','Hal','Holbrook',LOAD_FILE("C:/actors/HalHolbrook.jpg")),
('14','Tommy-Lee','Jones',LOAD_FILE("C:/actors/tommyleejones.jpg")),

('15','Guy','Pearce',LOAD_FILE("C:/actors/GuyPearce.jpg")),
('16','Carrie-Anne','Moss',LOAD_FILE("C:/actors/CarrieAnneMoss.jpg")),
('17','Joe','Pantoliano',LOAD_FILE("C:/actors/JoePantoliano.jpg")),

('18','Hugh','Jackman',LOAD_FILE("C:/actors/hughjackman.jpg")),
('19','Christian','Bale',LOAD_FILE("C:/actors/christianbale.jpg")),
('20','Michael','Caine',LOAD_FILE("C:/actors/MichaelCaine.jpg")),
('21','Scarlett','Johansson',LOAD_FILE("C:/actors/ScarlettJohansson.jpg")),
('22','Brie','Larson',LOAD_FILE("C:/actors/brielarson.jpg")),
('23','Andy','Serkis',LOAD_FILE("C:/actors/andyserkis.jpg")),
('24','David','Bowie',LOAD_FILE("C:/actors/DavidBowie.jpg")),

('25','Patton','Oswalt',LOAD_FILE("C:/actors/PattonOswalt.jpg")),
('26','Ian','Holm',LOAD_FILE("C:/actors/IanHolm.jpg")),
('27','Lou','Romano',LOAD_FILE("C:/actors/LouRomano.jpg")),
('28','Janeane','Garofalo',LOAD_FILE("C:/actors/JaneaneGarofalo.jpg")),
('29','Peter','O''Tool',LOAD_FILE("C:/actors/PeterOToole.jpg")),
('30','Brad','Garrett',LOAD_FILE("C:/actors/BradGarrett.jpg")),
('31','Brian','Dennehy',LOAD_FILE("C:/actors/BrianDennehy.jpg")),
('32','Peter','Sohn',LOAD_FILE("C:/actors/PeterSohn.jpg")),
('33','Will','Arnett',LOAD_FILE("C:/actors/WillArnett.jpg"));

INSERT INTO MOVIE_ACTOR (ACTOR_ID,MOVIE_ID) VALUES 
('1','1'),('2','1'),('3','1'),('4','1'),('5','1'),('6','1'),('7','1'),
('8','2'),('9','2'),('10','2'),('11','2'),('12','2'),('13','2'),('14','2'),
('15','3'),('16','3'),('17','3'),
('18','4'),('19','4'),('20','4'),('21','4'),('22','4'),('23','4'),('24','4'),
('25','5'),('26','5'),('27','5'),('28','5'),('29','5'),('30','5'),('31','5'),('32','5'),('33','5');

INSERT INTO GENRE (GENRE_ID,GENRE_TYPE) VALUES 
('1','Fantasy Adventure'),
('2','Historical Drama'),
('3','Psychological Thriller'),
('4','Animation');

INSERT INTO MOVIE_GENRE (MOVIE_ID,GENRE_ID) VALUES 
('1','1'),('2','2'),('3','3'),('4','3'),('5','4');
