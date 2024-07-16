package ru.honest.niceman.springjdbc;

public class Song {
    private Long id;
    private String name;
    private Long duration;
    private Long albumId;

    public Song() {
    }

    public Song(Long id,
                String name,
                Long duration,
                Long albumId) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.albumId = albumId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", albumId=" + albumId +
                '}';
    }
}
