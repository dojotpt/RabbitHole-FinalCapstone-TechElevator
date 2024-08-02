package com.techelevator.model;

public class Album {
    private int record_id;
    private String title;
    private String artist;
    private int year;
    private String genre;
    private String notes;
// how to handle create date?? Local Date Time?
    public Album(int record_id, String title, String artist, int year, String genre, String notes, String createDate) {
        this.record_id = record_id;
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.genre = genre;
        this.notes = notes;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setRelease_date(int year) {
        this.year = year;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getRecord_id() {
        return record_id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getNotes() {
        return notes;
    }
}
