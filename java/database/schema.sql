BEGIN TRANSACTION;

-- Drop tables in the correct order
DROP TABLE IF EXISTS  album_collections, users, album, collections;

-- Create the users table
CREATE TABLE users (
    user_id SERIAL,
    username VARCHAR(50) NOT NULL UNIQUE,
    password_hash VARCHAR(200) NOT NULL,
    role VARCHAR(50) NOT NULL,
    CONSTRAINT PK_user PRIMARY KEY (user_id)
);

-- Create the album table
CREATE TABLE album (
    album_id SERIAL,
    registered_user_id INT,
    title VARCHAR(128) NOT NULL,
    artist VARCHAR(128) NOT NULL,
    year_released INT,
    genre VARCHAR(28),
    notes TEXT,
	album_image VARCHAR(256),
    create_date TIMESTAMP,
    CONSTRAINT PK_album PRIMARY KEY (album_id),
    CONSTRAINT FK_registered_user FOREIGN KEY (registered_user_id) REFERENCES users(user_id)
);

-- Create the collections table
CREATE TABLE collections (
    collection_id SERIAL,
    user_id INT,
    title VARCHAR(128) NOT NULL,
    shared BOOLEAN DEFAULT false,
    description VARCHAR(256) NOT NULL,
    create_date TIMESTAMP,
    CONSTRAINT PK_collection PRIMARY KEY (collection_id),
    CONSTRAINT FK_user FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE album_collections (
album_id int NOT NULL,
collection_id int NOT NULL,
CONSTRAINT PK_album_collections PRIMARY KEY (album_id, collection_id), 
CONSTRAINT FK_album_collections_album FOREIGN KEY (album_id) REFERENCES album(album_id),
CONSTRAINT FK_album_collections_collections FOREIGN KEY (collection_id) REFERENCES collections(collection_id)
);

COMMIT TRANSACTION;

