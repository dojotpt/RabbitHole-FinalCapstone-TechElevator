package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Album;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcAlbumDao implements AlbumDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcAlbumDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Album getAlbumById(int album_id) {
        return null;
    }

    @Override
    public List<Album> getLibraryByRegUserId(int id) {
        final List<Album> albums = new ArrayList<>();
        final String sql = "SELECT album_id, registered_user_id, title, artist, year_released, genre, notes, album_image, create_date\n" +
                "FROM album\n" +
                "WHERE registered_user_id = ?;";
       try {
           final SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
           while (results.next()) {
               albums.add(mapRowToAlbum(results));
           }
       } catch (CannotGetJdbcConnectionException e) {
           throw new DaoException("unable to connect to server or database", e);
       }

        return albums;
    }

    @Override
    public Album addAlbum(Album album) {
        final String sql = "INSERT INTO album(album_id, registered_user_id, title, artist, year_released, genre, notes, album_image, create_date\n)" +
                    "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)\n" +
                    "RETURNING album_id;";
                try {
                    int newAlbumId = jdbcTemplate.queryForObject(sql, int.class); // what is int.class? --- check for null pointer exception
                    album = getAlbumById(newAlbumId);
                } catch (CannotGetJdbcConnectionException e) {
                    throw new DaoException("Unable to connect to server or database", e);
                }
                return album;
    }

    Album mapRowToAlbum(SqlRowSet rowSet) {
        Album album = new Album();
        album.setAlbumId(rowSet.getInt("album_id"));
        album.setRegisteredUserId(rowSet.getInt("registered_user_id"));
        album.setTitle(rowSet.getString("title"));
        album.setArtist(rowSet.getString("artist"));
        album.setYearReleased(rowSet.getInt("year_released"));
        album.setGenre(rowSet.getString("genre"));
        album.setNotes(rowSet.getString("notes"));
        album.setAlbumImage(rowSet.getString("album_image"));
        album.setCreateDate(rowSet.getString("create_date"));
        return album;
    }
}


