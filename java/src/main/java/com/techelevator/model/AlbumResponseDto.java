package com.techelevator.model;

import java.util.List;

public class AlbumResponseDto {

    private List<Album> data;

    public AlbumResponseDto(List<Album> data) {
        this.data = data;
    }
    public List<Album> getData() {
        return data;
    }
}
