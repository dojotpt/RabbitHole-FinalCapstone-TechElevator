package com.techelevator.dao;

import com.techelevator.model.Album;

import com.techelevator.model.AlbumStats;

import java.util.List;


public interface AlbumDao {
    int getAlbumInCollectionsTotal(int album_id);

    AlbumStats getStatsForAlbum(int album_id);

    List<Album> getLibraryByRegUserId(int id);

       Album createAlbum(Album album);
       Album getAlbumById(int album_id);
       List<Album> getAlbumsByCollectionId(int collection_id/*id is collection id*/);
    Album updateAlbum(Album album);

}
