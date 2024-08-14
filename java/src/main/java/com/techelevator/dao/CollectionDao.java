package com.techelevator.dao;

import com.techelevator.model.Collection;
import com.techelevator.model.CreateCollectionRequest;

import java.util.List;

public interface CollectionDao {



    List<Collection> getAllCollections();

    Collection getCollectionById(int collection_id);
    List<Collection> getCollectionByUser_Id(int user_id);

    Collection updateCollection(Collection collection);

    Collection createCollection(CreateCollectionRequest collection);

    void updateContents(int collectionId, int[] albums);

    Collection updateCollectionContent(Collection collection);

    Collection removeAlbumsFromCollection(int collectionId);

}
