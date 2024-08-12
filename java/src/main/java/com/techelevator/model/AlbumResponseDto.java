package com.techelevator.model;

import java.util.List;

public class AlbumResponseDto {

    private List<Album> albums;
//    private Album album;

    public AlbumResponseDto(List<Album> albums) {
        this.albums = albums;
    }
    public List<Album> getAlbums() {
        return albums;
    }
//    public getAlbumById(album) {
//        return album;
//    }
}
