CREATE DATABASE TRABUDZ;

DROP TABLE USERS;

     CREATE TABLE USERS (
        POSITION INTEGER IDENTITY(1,1) NOT NULL,
        FIRSTNAME VARCHAR(30), 
        LASTNAME VARCHAR(30),
        USERNAME VARCHAR(30),
        PASSWORDY VARCHAR(30),
        EMAIL VARCHAR(30),
        BIRTHDAY VARCHAR(30),
        SEX INT CHECK(SEX = 1 OR SEX = 2),
		DEST INT CHECK(DEST>=1 AND DEST<=20),
		MONTHY INT CHECK(MONTHY>=1 AND MONTHY<=12)
        PRIMARY KEY (POSITION)
    );


	select * from USERS