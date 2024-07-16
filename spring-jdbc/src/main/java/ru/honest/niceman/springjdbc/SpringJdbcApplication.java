package ru.honest.niceman.springjdbc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner {
    private final SongRepository songRepository;

    public SpringJdbcApplication(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcApplication.class, args);
    }

    @Override
    public void run(String... args) {
        String name = "Come Together";

        List<Song> songList = songRepository.findJdbcTemplate(name);
        for (Song song : songList) {
            System.out.println(song);
        }

        List<Song> songList1 = songRepository.findJdbcNamedTemplate(name);

        for (Song song : songList1) {
            System.out.println(song);
        }

        boolean insert = songRepository.insert("New Song", 55, 2);
        System.out.println("Insertion result: " + insert);

        boolean delete = songRepository.delete(1);
        System.out.println("Deletion result: " + delete);

        List<Song> songs = songRepository.find("Come Together");

        for (Song song : songs) {
            System.out.println(song);
        }

        List<Song> songs1 = songRepository.find("Bohemian Rhapsody");

        for (Song song : songs1) {
            System.out.println(song);
        }

        boolean update = songRepository.update("Bohemian Rhapsody", 999, 3, "Bohemian Rhapsody");
        System.out.println("Update result: " + update);

        List<Song> songs2 = songRepository.find("Bohemian Rhapsody");
        for (Song song : songs2) {
            System.out.println(song);
        }

    }
}
