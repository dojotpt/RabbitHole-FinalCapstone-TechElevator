package com.techelevator.model;

public class CreateCollectionRequest {

    private int user_id;
    private String title;
    private String description;
    private Boolean shared;
    private int[] albums;

    public CreateCollectionRequest() {
    }

    public int getUserId() {
        return user_id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getShared() {
        return shared;
    }

    public int[] getAlbums() {
        return albums;
    }

    public void setUserId(int userId) {
        this.user_id = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setShared(Boolean shared) {
        this.shared = shared;
    }

    public void setAlbums(int[] albums) {
        this.albums = albums;
    }
}
