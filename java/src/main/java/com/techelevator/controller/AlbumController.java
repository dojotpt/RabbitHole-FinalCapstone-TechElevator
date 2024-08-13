package com.techelevator.controller;
import com.techelevator.dao.AlbumDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Album;
import com.techelevator.model.AlbumResponseDto;
import com.techelevator.model.AlbumStats;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.security.Principal;

@RestController
@CrossOrigin
public class AlbumController {
private final AlbumDao albumDao;
private final UserDao userDao;

    public AlbumController(AlbumDao albumDao, UserDao userDao) {
        this.albumDao = albumDao;
        this.userDao = userDao;
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/mylibrary/{id}")
    public AlbumResponseDto getLibraryByRegUserId(@PathVariable int id, Principal principal) {
        authHelper(id, principal);
        final List<Album> albums = this.albumDao.getLibraryByRegUserId(id);
        return new AlbumResponseDto(albums);
    }

    @PostMapping("/albums")
    public Album createAlbum(@RequestBody Album album) {
        return albumDao.createAlbum(album);
    }
    @PutMapping("/album/{album_id}/edit")
    public Album editAlbum(@PathVariable int album_id, @RequestBody Album album) {
        album.setAlbumId(album_id);
        return albumDao.updateAlbum(album);
    }
    @GetMapping("/albumcollection/{collection_id}")
    public AlbumResponseDto getAlbumsByCollectionId(@PathVariable int collection_id) {
        final List<Album> albumCollection = this.albumDao.getAlbumsByCollectionId(collection_id);
        return new AlbumResponseDto(albumCollection);
    }
    @GetMapping("/album/{album_id}")
    public Album getAlbumById(@PathVariable int album_id) {
       return this.albumDao.getAlbumById(album_id);
    }

    @GetMapping("/album/{album_id}/stats")
    public int getAlbumInCollectionsTotal(@PathVariable int album_id) {
        return this.albumDao.getAlbumInCollectionsTotal(album_id);
    }

    @GetMapping("/album/{album_id}/albumstats")
    public AlbumStats getAlbumStats(@PathVariable int album_id) {
        // AUTHORIZATION
        return albumDao.getStatsForAlbum(album_id);
    }
    @GetMapping("/album/{album_id}/newalbum")
    public Album getAlbum(@PathVariable int album_id) {
        // AUTHORIZATION
        Album album = albumDao.getAlbumById(album_id);
        album.setStats(albumDao.getStatsForAlbum(album_id));
        return album;
    }

    private void authHelper(int id, Principal principal) {
        String username = principal.getName();
        User authenticatedUser = userDao.getUserByUsername(username);
        if (id != authenticatedUser.getId()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }

}
