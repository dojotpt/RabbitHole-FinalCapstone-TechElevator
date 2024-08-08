package com.techelevator.dao;

import com.techelevator.model.Album;

import java.util.List;

public interface AlbumDao {
       List<Album> getLibraryByRegUserId(int id);
       Album addAlbum (Album album);
       Album getAlbumById(int album_id);
}
