package com.techelevator.controller;

import com.techelevator.dao.AlbumDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Album;
import com.techelevator.model.AlbumResponseDto;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.security.Principal;

@RestController
@PreAuthorize("isAuthenticated()")
//@RequestMapping("/mylibrary")
@CrossOrigin
public class AlbumController {
private final AlbumDao albumDao;
private final UserDao userDao;

    public AlbumController(AlbumDao albumDao, UserDao userDao) {
        this.albumDao = albumDao;
        this.userDao = userDao;
    }


    @GetMapping("mylibrary/{id}")
    public AlbumResponseDto getAll(@PathVariable int id, Principal principal) {
        authHelper(id, principal);
        final List<Album> albums = this.albumDao.getAll();
        return new AlbumResponseDto(albums);
    }

    private void authHelper(int id, Principal principal) {
        String username = principal.getName();
        User authenticatedUser = userDao.getUserByUsername(username);
        if (id != authenticatedUser.getId()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }

}
