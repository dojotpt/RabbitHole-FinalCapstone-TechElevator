BEGIN TRANSACTION;

DROP TABLE IF EXISTS album;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

-- registered_users
-- CONSTRAINT FK_users FOREIGN KEY (users.username)

CREATE TABLE album (
   album_id serial,
   registered_user_id int,
   title VARCHAR(128) NOT NULL,
   artist VARCHAR(128) NOT NULL,
   year_released INT,
   genre VARCHAR(28),
   notes TEXT,
   create_date TIMESTAMP,
   CONSTRAINT PK_album PRIMARY KEY (album_id)
   --CONSTRAINT FK_users FOREIGN KEY (user_id)
);



COMMIT TRANSACTION;
