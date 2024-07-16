package ru.honest.honest.niceman.code;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        SongRepository.find("Come Together");

        SongRepository.insert("New Song", 55, 2);

        SongRepository.delete(1);
        SongRepository.find("Come Together");

        SongRepository.find("Bohemian Rhapsody");
        SongRepository.update("Bohemian Rhapsody", 999, 3, "Bohemian Rhapsody");
        SongRepository.find("Bohemian Rhapsody");
    }
}
