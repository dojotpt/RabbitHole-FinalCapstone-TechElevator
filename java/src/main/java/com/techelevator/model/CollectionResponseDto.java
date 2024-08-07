package com.techelevator.model;

import java.util.List;

public class CollectionResponseDto {
    private List<Collection> data;
    public CollectionResponseDto(List<Collection> data) {
        this.data = data;
    }
    public List<Collection> getData() {
        return data;
    }
}
