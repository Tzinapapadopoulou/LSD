--CREATE DATABASE LSD1
USE LSD1;
CREATE TABLE LIKES (
LIKER VARCHAR(30) NOT NULL,
LIKED VARCHAR(30) NOT NULL);

INSERT INTO LIKES (LIKER, LIKED)
VALUES ('fotpapad', 'tzinaki'),
('agglasd', 'mairytet'),
('mariasigala', 'tzinaki'),
 ('mairytet', 'fotpapad');

/*DROP TABLE LIKES;*/
SELECT * FROM LIKES;

SELECT * FROM LIKES WHERE LIKED='ANNA' AND LIKER='MARIA';
