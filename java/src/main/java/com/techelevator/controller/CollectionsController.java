package com.techelevator.controller;

import com.techelevator.dao.CollectionDao;
import com.techelevator.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CollectionsController {

    private CollectionDao collectionDao;


    public CollectionsController(CollectionDao collectionDao){
        this.collectionDao = collectionDao;
    }


    @GetMapping("/collections")
    public CollectionResponseDto getAllCollections(){
        final List<Collection> collections = this.collectionDao.getAllCollections();
        return new CollectionResponseDto(collections);
    }
    @GetMapping("/mycollections/{user_id}")
    public CollectionResponseDto getCollectionByUserId(@PathVariable int user_id) {
        final List<Collection> collections = this.collectionDao.getCollectionByUser_Id(user_id);
        return new CollectionResponseDto(collections);
    }
    @PostMapping("/addcollections")
    public Collection createCollection(@RequestBody CreateCollectionRequest collection){
        return collectionDao.createCollection(collection);
    }

    @PutMapping("/collections/{collection_id}/albums")

    public Collection updateCollection(@PathVariable int collection_id, @RequestBody Collection collection){
        collection.setCollection_id(collection_id);
        return collectionDao.updateCollection(collection, collection_id, collection.album_ids);
    }
    @PutMapping("/collections/{collection_id}/addAlbumsToCollection")
    public Collection addAlbumToCollection(@PathVariable int collection_id, @RequestBody Collection collection){
        collection.setCollection_id(collection_id);
        return collectionDao.addAlbumToCollection(collection_id, collection.album_ids);
    }

}
