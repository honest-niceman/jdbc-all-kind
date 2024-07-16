-- Генерация данных для таблицы "artist"
INSERT INTO artist (name)
VALUES ('The Beatles'),
       ('Queen'),
       ('Michael Jackson'),
       ('Madonna');
-- Генерация данных для таблицы "album"
INSERT INTO album (name, genre, artist_id)
VALUES ('Abbey Road', 'Rock', 1),
       ('The Game', 'Rock', 2),
       ('Thriller', 'Pop', 3),
       ('Like a Virgin', 'Pop', 4);
-- Генерация данных для таблицы "song"
INSERT INTO song (name, duration, album_id)
VALUES ('Come Together', 55, 1),
       ('Bohemian Rhapsody', 100, 2),
       ('Billie Jean', 70, 3),
       ('Like a Virgin', 45, 4),
       ('Here Comes the Sun', 14, 1),
       ('Something', 60, 1),
       ('I Want to Break Free', 129, 2),
       ('Radio Ga Ga', 200, 2),
       ('Beat It', 55, 1),
       ('Wanna Be Startin', 222, 3),
       ('Material Girl', 322, 4);