package com.techelevator.controller;


import com.techelevator.dao.CollectionDao;
import com.techelevator.dao.JdbcCollectionDao;
import com.techelevator.model.Collection;
import com.techelevator.model.CollectionResponseDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@CrossOrigin
public class CollectionController {
    private CollectionDao collectionDao;
    public CollectionController(CollectionDao collectionDao) {this.collectionDao = collectionDao;}
    @GetMapping("/collections")
    public CollectionResponseDto getCollections() {
        final List<Collection>  collections = this.collectionDao.getAllCollections();
        return new CollectionResponseDto(collections);

    }
}
