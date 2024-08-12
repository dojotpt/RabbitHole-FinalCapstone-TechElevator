package com.techelevator.dao;

import com.techelevator.model.Collection;

import java.util.List;

public interface CollectionDao {



    List<Collection> getAllCollections();
    Collection createCollection(Collection collection);
    Collection getCollectionById(int collection_id);
    List<Collection> getCollectionByUser_Id(int user_id);
}
