package com.techelevator.controller;

import com.techelevator.dao.AlbumDao;
import com.techelevator.model.Album;
import com.techelevator.model.AlbumResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class AlbumController {

    private AlbumDao albumDao;
    public AlbumController(AlbumDao albumDao) {
        this.albumDao = albumDao;
    }

    @GetMapping("/mylibrary")
    public AlbumResponseDto getAll() {
        final List<Album> albums = this.albumDao.getAll();
        return new AlbumResponseDto(albums);
    }

}
