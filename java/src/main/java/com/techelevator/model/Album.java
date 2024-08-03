package com.techelevator.model;

public class Album {
    private int albumId;
    private int registeredUserId;
    private String title;
    private String artist;
    private int yearReleased;
    private String genre;
    private String notes;
    private String createDate;

    public Album(int albumId, int registeredUserId, String title, String artist, int yearReleased, String genre, String notes, String createDate) {
        this.albumId = albumId;
        this.registeredUserId = registeredUserId;
        this.title = title;
        this.artist = artist;
        this.yearReleased = yearReleased;
        this.genre = genre;
        this.notes = notes;
        this.createDate = createDate;
    }
    public Album() {

    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public void setRegisteredUserId(int registeredUserId) {
        this.registeredUserId = registeredUserId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setYearReleased(int yearReleased) {
        this.yearReleased = yearReleased;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getAlbumId() {
        return albumId;
    }

    public int getRegisteredUserId() {
        return registeredUserId;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public String getGenre() {
        return genre;
    }

    public String getNotes() {
        return notes;
    }

    public String getCreateDate() {
        return createDate;
    }
}
