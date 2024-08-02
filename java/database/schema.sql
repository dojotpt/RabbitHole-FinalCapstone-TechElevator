BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE album (
    album_id serial,
    title VARCHAR(128) NOT NULL,
    artist VARCHAR(128) NOT NULL,
    year INT,
    genre VARCHAR(28),
    notes TEXT,
    createdAt TIMESTAMP
);

COMMIT TRANSACTION;
