package com.techelevator.controller;

import com.techelevator.dao.CollectionDao;
import com.techelevator.model.Collection;
import com.techelevator.model.CollectionResponseDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
