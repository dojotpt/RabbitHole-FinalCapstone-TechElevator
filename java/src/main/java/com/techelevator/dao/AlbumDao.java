package com.techelevator.dao;

import com.techelevator.model.Album;
import java.util.List;


public interface AlbumDao {
       List<Album> getLibraryByRegUserId(int id);
       Album createAlbum(Album album);
       Album getAlbumById(int album_id);
       List<Album> getAlbumsByCollectionId(int collection_id/*id is collection id*/);

}
