BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO album (registered_user_id, title, artist, year_released, genre, notes, create_date) VALUES
(1, 'Abbey Road', 'The Beatles', 1969, 'Rock', 'One of the most acclaimed albums in the history of popular music.', NOW()),
(2, 'Back in Black', 'AC/DC', 1980, 'Hard Rock', 'Best-selling album by a band, and the second best-selling album in history.', NOW()),
(1, 'The Dark Side of the Moon', 'Pink Floyd', 1973, 'Progressive Rock', 'Known for its complex themes and pioneering use of studio effects.', NOW()),
(3, 'Thriller', 'Michael Jackson', 1982, 'Pop', 'Best-selling album of all time, with iconic hits like "Billie Jean".', NOW()),
(2, 'Rumours', 'Fleetwood Mac', 1977, 'Rock', 'Critically acclaimed and known for its behind-the-scenes drama.', NOW()),
(1, 'Nevermind', 'Nirvana', 1991, 'Grunge', 'Helped popularize the grunge movement and includes the hit "Smells Like Teen Spirit".', NOW()),
(3, 'The Wall', 'Pink Floyd', 1979, 'Progressive Rock', 'A rock opera that explores themes of isolation and mental illness.', NOW()),
(2, 'Hotel California', 'Eagles', 1976, 'Rock', 'Features the iconic title track, which is one of the band''s signature songs.', NOW()),
(1, 'Born to Run', 'Bruce Springsteen', 1975, 'Rock', 'Springsteen''s breakthrough album, which solidified his reputation.', NOW()),
(3, 'The Joshua Tree', 'U2', 1987, 'Rock', 'Widely regarded as U2''s magnum opus, with hits like "With or Without You".', NOW());

<<<<<<< HEAD
INSERT INTO collections (user_id, title, description) VALUES
(1, 'Summer Jams', 'Songs I like listening to on hot days while taking a drive.'),
(2, 'The Heaviest Metal', 'So heavy I cant even lift the albums.');


=======
>>>>>>> 34aa55b95355744856a9f905235cc4a77a71e250
COMMIT TRANSACTION;
