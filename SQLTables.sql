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

	CREATE TABLE LIKES (
	LIKER VARCHAR(30) NOT NULL,
	LIKED VARCHAR(30) NOT NULL);

	/*SELECT * FROM LIKES
	DELETE  FROM LIKES
	ALTER TABLE USERS
	ADD CONSTRAINT C1
	CHECK (SEX=1 OR SEX=2 OR SEX=3)

	ALTER TABLE USERS
	ALTER COLUMN MONTHY VARCHAR(30);

	select * from USERS
	DELETE FROM USERS
	SELECT COUNT(*) FROM USERS

	DBCC CHECKIDENT (USERS, RESEED, 0)


	

	