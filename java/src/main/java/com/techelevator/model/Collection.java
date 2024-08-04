package com.techelevator.model;

import java.sql.Time;
import java.sql.Timestamp;

public class Collection {
    private int collection_id;
    private int user_id;
    private String name;
    private String description;
    private Boolean notPublic;
    private Timestamp createDate;


    public Collection( int collectionId, int userId, String name, Boolean notPublic, String description, Timestamp createDate) {
        this. collection_id = collectionId;
        this.user_id = userId;
        this.name = name;
        this.notPublic = notPublic;
        this.description = description;
        this.createDate = createDate;
    }



    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getNotPublic() {
        return notPublic;
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
}


