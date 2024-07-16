package ru.honest.honest.niceman.code;

import java.sql.*;

public class SongRepository {
    protected static void find(String name) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DbProps.DB_URL, DbProps.DB_USER, DbProps.DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM public.song WHERE name = ?"
             )) {

            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String songId = resultSet.getString("id");
                String songName = resultSet.getString("name");
                String songDuration = resultSet.getString("duration");
                String albumId = resultSet.getString("album_id");
                System.out.printf("Song info: [" +
                        "id = %s, " +
                        "songName = %s, " +
                        "songDuration = %s, " +
                        "albumId = %s]%n", songId, songName, songDuration, albumId);
            }
        }
    }

    // 7. Написать метод для запуска prepared statement на вставка в таблицу с песнями (параметры: имя песни, длительность, id альбома)
    protected static void insert(String nameSong, int durationSong, int idAlbum) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DbProps.DB_URL, DbProps.DB_USER, DbProps.DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO public.song (name, duration, album_id) VALUES (?, ?, ?)"
             )) {

            preparedStatement.setString(1, nameSong);
            preparedStatement.setInt(2, durationSong);
            preparedStatement.setInt(3, idAlbum);

            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("The value inserted successfully");
            } else {
                System.out.println("The value is not inserted");
            }
        }
    }

    // 8. Написать метод для удаления по id из таблицы с песнями
    protected static void delete(int id) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DbProps.DB_URL, DbProps.DB_USER, DbProps.DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM public.song WHERE id = ?"
             )) {
            preparedStatement.setInt(1, id);

            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("The value deleted successfully");
            } else {
                System.out.println("The value is not deleted");
            }
        }
    }

    // 9. Написать метод для обновления песни по её имени
    protected static void update(String newName, int newDuration, int newIdAlbum, String oldName) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DbProps.DB_URL, DbProps.DB_USER, DbProps.DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE public.song SET name = ?, duration = ?, album_id = ? WHERE name = ?"
             )) {
            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, newDuration);
            preparedStatement.setInt(3, newIdAlbum);
            preparedStatement.setString(4, oldName);

            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("The value updated successfully");
            } else {
                System.out.println("The value is not updated");
            }

        }
    }
}
