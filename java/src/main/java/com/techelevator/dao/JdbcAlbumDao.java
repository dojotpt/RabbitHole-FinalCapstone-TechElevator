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
    public List<Album> getAll() {
        final String sql = "Select album_id, title, artist, year, genre, notes, createdat\n" +
                "\n" +
                "From album;";
        final List<Album> albums = new ArrayList<>();
        try {
            SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                final Album album = new Album(
                        results.getInt("album_id"),
                        results.getString("title"),
                        results.getString("artist"),
                        results.getInt("year"),
                        results.getString("genre"),
                        results.getString("notes"),
                        results.getString("createdat")
                );
                albums.add(album);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("unable to connect to server or database", e);
        }
        return albums;
    }
}


