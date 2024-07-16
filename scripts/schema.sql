CREATE SEQUENCE artist_id_seq;
CREATE SEQUENCE album_id_seq;
CREATE SEQUENCE song_id_seq;

CREATE TABLE artist
(
    id   INTEGER PRIMARY KEY DEFAULT nextval('artist_id_seq'),
    name VARCHAR(100) NOT NULL
);

CREATE TABLE album
(
    id        INTEGER PRIMARY KEY DEFAULT nextval('album_id_seq'),
    name      VARCHAR(100) NOT NULL,
    genre     VARCHAR(50)  NOT NULL,
    artist_id INTEGER REFERENCES artist (id) ON DELETE CASCADE
);

CREATE TABLE song
(
    id       INTEGER PRIMARY KEY DEFAULT nextval('song_id_seq'),
    name     VARCHAR(100) NOT NULL,
    duration INTEGER      NOT NULL,
    album_id INTEGER REFERENCES album (id) ON DELETE CASCADE
);