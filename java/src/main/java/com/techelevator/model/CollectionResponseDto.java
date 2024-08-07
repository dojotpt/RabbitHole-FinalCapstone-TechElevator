package com.techelevator.model;

import java.util.List;

public class CollectionResponseDto {
    private List<Collection> collections;
    public CollectionResponseDto(List<Collection> collections) {
        this.collections = collections;
    }
    public List<Collection> getCollections() {
        return collections;
    }
}
