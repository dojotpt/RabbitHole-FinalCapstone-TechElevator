package com.techelevator.model;

import java.util.List;

public class AlbumResponseDto {

    private List<Album> albums;

    public AlbumResponseDto(List<Album> albums) {
        this.albums = albums;
    }
    public List<Album> getAlbums() {
        return albums;
    }
}
