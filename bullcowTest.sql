DROP DATABASE IF EXISTS BULLCOWTest;

CREATE DATABASE BULLCOWTest;

USE BULLCOWTest;

CREATE TABLE `Game`(
GameId INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
CorrectAnswerKey INT NOT NULL,
GameStatus TINYINT NOT NULL
);

CREATE TABLE `Round` (
RoundId INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
Time TIMESTAMP NOT NULL,
GuessResultExact VARCHAR(45) NOT NULL,
GuessResultPartial VARCHAR(45) NOT NULL,
UserGuessKey INT NOT NULL,
GameId INT NOT NULL,
-- FK GameId
FOREIGN KEY fk_GameId (GameId)
	REFERENCES `Game` (GameId)
);

