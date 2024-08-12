package com.techelevator.model;


import java.sql.Time;
import java.sql.Timestamp;

public class Collection {
    private int collection_id;
    private int user_id;
    private String title;
    private String description;
    private Boolean shared;
    private Timestamp createDate;


    public Collection( int collectionId, int userId, String title, Boolean shared, String description, Timestamp createDate) {
        this. collection_id = collectionId;
        this.user_id = userId;
        this.title = title;
        this.shared = shared;
        this.description = description;
        this.createDate = createDate;
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

    public Timestamp getCreateDate() {
        return createDate;
    }

    public int getCollection_id() {
        return collection_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setCollection_id(int collection_id) {
        this.collection_id = collection_id;
    }
}


