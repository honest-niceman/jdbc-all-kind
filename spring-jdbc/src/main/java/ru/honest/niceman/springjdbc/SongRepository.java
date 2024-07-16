package ru.honest.niceman.springjdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SongRepository {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public SongRepository(JdbcTemplate jdbcTemplate,
                          NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Song> findJdbcTemplate(String name) {
        return jdbcTemplate.query(
                "SELECT * FROM public.song WHERE name = ?",
                new Object[]{name},
                (resultSet, rowNum) -> {
                    Long songId = resultSet.getLong("id");
                    String songName = resultSet.getString("name");
                    Long songDuration = resultSet.getLong("duration");
                    Long albumId = resultSet.getLong("album_id");
                    return new Song(songId, songName, songDuration, albumId);
                });
    }

    public List<Song> findJdbcNamedTemplate(String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("firstName", name);
        return namedParameterJdbcTemplate.query(
                "SELECT * FROM public.song WHERE name = :firstName",
                params,
                (resultSet, rowNum) -> {
                    Long songId = resultSet.getLong("id");
                    String songName = resultSet.getString("name");
                    Long songDuration = resultSet.getLong("duration");
                    Long albumId = resultSet.getLong("album_id");
                    return new Song(songId, songName, songDuration, albumId);
                });
    }

    public List<Song> find(String name) {
        String sql = "SELECT * FROM public.song WHERE name = ?";
        return jdbcTemplate.query(sql, new Object[]{name}, new SongRowMapper());
    }

    public boolean insert(String nameSong, int durationSong, int idAlbum) {
        String sql = "INSERT INTO public.song (name, duration, album_id) VALUES (?, ?, ?)";
        int result = jdbcTemplate.update(sql, nameSong, durationSong, idAlbum);
        return result == 1;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM public.song WHERE id = ?";
        int result = jdbcTemplate.update(sql, id);
        return result == 1;
    }

    public boolean update(String newName, int newDuration, int newIdAlbum, String oldName) {
        String sql = "UPDATE public.song SET name = ?, duration = ?, album_id = ? WHERE name = ?";
        int result = jdbcTemplate.update(sql, newName, newDuration, newIdAlbum, oldName);
        return result == 1;
    }

    private static class SongRowMapper implements RowMapper<Song> {
        @Override
        public Song mapRow(ResultSet resultSet, int i) throws SQLException {
            Song song = new Song();
            song.setId(resultSet.getLong("id"));
            song.setName(resultSet.getString("name"));
            song.setDuration(resultSet.getLong("duration"));
            song.setAlbumId(resultSet.getLong("album_id"));
            return song;
        }
    }

}
