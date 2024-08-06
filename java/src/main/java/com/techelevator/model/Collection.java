package com.techelevator.model;

public class Collection {
    private int id;

    private int user_id;

    private String title;

    private String description;

    private Boolean shared;

    public Collection(int id, int user_id, String title, String description, Boolean shared) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.description = description;
        this.shared = shared;
    }


    public int getId() {
        return id;
    }

    public int getUser_id() {
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
}
