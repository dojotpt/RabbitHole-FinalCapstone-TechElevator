package com.techelevator.model;


public class Collection {


    private int collection_id;
    private int user_id;
    private String title;
    private String description;
    private Boolean shared;
    private String createDate;
    public Collection() {}

    public Collection(int collection_id, int userId, String title, Boolean shared, String description, String createDate) {
        this.collection_id = collection_id;
        this.user_id = userId;
        this.title = title;
        this.shared = shared;
        this.description = description;
        this.createDate = createDate;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    public int getCollection_id() {
        return collection_id;
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

    public String getCreateDate() {
        return createDate;
    }


    public int getUser_id() {
        return user_id;
    }

    public void setCollection_id(int collection_id) {
        this.collection_id = collection_id;
    }
}


