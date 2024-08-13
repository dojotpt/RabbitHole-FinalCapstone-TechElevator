package com.techelevator.controller;

import com.techelevator.dao.CollectionDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Album;
import com.techelevator.model.AlbumResponseDto;
import com.techelevator.model.Collection;
import com.techelevator.model.CollectionResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CollectionsController {

    private CollectionDao collectionDao;

    private final UserDao userDao;
    public CollectionsController(CollectionDao collectionDao, UserDao userDao){
        this.collectionDao = collectionDao;
        this.userDao = userDao;
    }


    @GetMapping("/collections")
    public CollectionResponseDto getAllCollections(){
        final List<Collection> collections = this.collectionDao.getAllCollections();
        return new CollectionResponseDto(collections);
    }
    @GetMapping("/mycollections/{id}")
    public CollectionResponseDto getCollectionByUserId(@PathVariable int id) {
        final List<Collection> collections = this.collectionDao.getCollectionByUser_Id(id);
        return new CollectionResponseDto(collections);
    }
    @PostMapping("/addcollections")
    public Collection addCollection(@RequestBody Collection collection){
        return collectionDao.createCollection(collection);
    }


}
