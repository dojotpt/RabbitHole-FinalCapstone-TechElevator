BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO album (registered_user_id, title, artist, year_released, genre, notes, album_image, create_date) VALUES
(1, 'Abbey Road', 'The Beatles', 1969, 'Rock', 'One of the most acclaimed albums in the history of popular music.', 'https://i.discogs.com/ffj9SJ3O75j7CiAA3QlvCMLSzqsFKaSq6N_U84eL5t8/rs:fit/g:sm/q:90/h:400/w:387/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwNjU0/NTgzLTE1MDE3NzIx/MTktMTExOS5qcGVn.jpeg', NOW()),
(2, 'Back in Black', 'AC/DC', 1980, 'Hard Rock', 'Best-selling album by a band, and the second best-selling album in history.', 'https://i.discogs.com/xf2PKezzQ243HuyRnERV8RTSzX_r9Nni7QZactGZjQY/rs:fit/g:sm/q:90/h:600/w:600/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTQwMDU5/MS0xNTM3MDM1ODI5/LTEzOTEuanBlZw.jpeg', NOW()),
(1, 'The Dark Side of the Moon', 'Pink Floyd', 1973, 'Progressive Rock', 'Known for its complex themes and pioneering use of studio effects.', 'https://i.discogs.com/cO8d6DLOvOErJGhHe2InPDn28hZw0WQe4_8SpT03HtQ/rs:fit/g:sm/q:90/h:600/w:597/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTE4NzMw/MTMtMTcxNTE3Mjcy/MC0xOTYwLmpwZWc.jpeg', NOW()),
(3, 'Thriller', 'Michael Jackson', 1982, 'Pop', 'Best-selling album of all time, with iconic hits like "Billie Jean".', 'https://i.discogs.com/dWe2AyguSxJpaaEWbK_mVLL3zs2ejuta0sJCx5BvS8o/rs:fit/g:sm/q:90/h:600/w:597/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTI5MTEy/OTMtMTU5NDI0NTgx/Mi03OTMxLmpwZWc.jpeg', NOW()),
(2, 'Rumours', 'Fleetwood Mac', 1977, 'Rock', 'Critically acclaimed and known for its behind-the-scenes drama.', 'https://i.discogs.com/CjrS2bgcQWG2_-5ksSqjPThprAIb-i4GYxghhcdp-VQ/rs:fit/g:sm/q:90/h:400/w:400/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTIwODk1/OTYtMTI2MzM5MjEy/OC5qcGVn.jpeg', NOW()),
(1, 'Nevermind', 'Nirvana', 1991, 'Grunge', 'Helped popularize the grunge movement and includes the hit "Smells Like Teen Spirit".', 'https://i.discogs.com/CjrS2bgcQWG2_-5ksSqjPThprAIb-i4GYxghhcdp-VQ/rs:fit/g:sm/q:90/h:400/w:400/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTIwODk1/OTYtMTI2MzM5MjEy/OC5qcGVn.jpeg', NOW()),
(3, 'The Wall', 'Pink Floyd', 1979, 'Progressive Rock', 'A rock opera that explores themes of isolation and mental illness.', 'https://i.discogs.com/CjrS2bgcQWG2_-5ksSqjPThprAIb-i4GYxghhcdp-VQ/rs:fit/g:sm/q:90/h:400/w:400/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTIwODk1/OTYtMTI2MzM5MjEy/OC5qcGVn.jpeg', NOW()),
(2, 'Hotel California', 'Eagles', 1976, 'Rock', 'Features the iconic title track, which is one of the band''s signature songs.', 'https://i.discogs.com/CjrS2bgcQWG2_-5ksSqjPThprAIb-i4GYxghhcdp-VQ/rs:fit/g:sm/q:90/h:400/w:400/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTIwODk1/OTYtMTI2MzM5MjEy/OC5qcGVn.jpeg', NOW()),
(1, 'Born to Run', 'Bruce Springsteen', 1975, 'Rock', 'Springsteen''s breakthrough album, which solidified his reputation.', 'https://i.discogs.com/CjrS2bgcQWG2_-5ksSqjPThprAIb-i4GYxghhcdp-VQ/rs:fit/g:sm/q:90/h:400/w:400/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTIwODk1/OTYtMTI2MzM5MjEy/OC5qcGVn.jpeg', NOW()),
(3, 'The Joshua Tree', 'U2', 1987, 'Rock', 'Widely regarded as U2''s magnum opus, with hits like "With or Without You".', 'https://i.discogs.com/CjrS2bgcQWG2_-5ksSqjPThprAIb-i4GYxghhcdp-VQ/rs:fit/g:sm/q:90/h:400/w:400/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTIwODk1/OTYtMTI2MzM5MjEy/OC5qcGVn.jpeg', NOW());

INSERT INTO collections (user_id, title, description) VALUES
(1, 'Summer Jams', 'Songs I like listening to on hot days while taking a drive.'),
(2, 'The Heaviest Metal', 'So heavy I cant even lift the albums.');


COMMIT TRANSACTION;
