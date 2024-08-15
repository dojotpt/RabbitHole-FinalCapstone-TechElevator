package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Album;
import com.techelevator.model.Collection;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;




@Component
public class JdbcCollectionDao implements CollectionDao {

    private final JdbcTemplate jdbcTemplate;


    public JdbcCollectionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Collection> getAllCollections() {
        final String sql = "select * from collections"; ;

        final List<Collection> collections = new ArrayList<>();
        try {
            SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {

                final Collection collection = new Collection(
                        results.getInt("collection_id"),
                        results.getInt("user_id"),
                        results.getString("title"),
                        results.getBoolean("shared"),
                        results.getString("description"),
                        results.getTimestamp("create_date")
                );
                collections.add(collection);
            }
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return collections;
    }

    @Override
    public Collection createCollection(Collection collection) {
        Collection createdCollection = null;

        final String sql = "INSERT INTO collections(user_id, title, description, shared, create_date) VALUES (?, ?, ?, ?, ?) RETURNING collection_id; ";
        try {
            int newCollectionId = jdbcTemplate.queryForObject(sql, int.class, collection.getUser_id(), collection.getTitle(), collection.getDescription(), collection.getShared(), collection.getCreateDate());
            createdCollection = getCollectionById(newCollectionId);



        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity violation", e);
        }
        return createdCollection;
    }

    @Override
    public Collection addAlbumToCollection(int collection_id, int album_id) {

        final String sql = "INSERT INTO album_collections(collection_id, album_id) VALUES (?, ?)";

        return null;
    }


    @Override
    public Collection updateCollection(Collection collection) {
        Collection updatedCollection = null;
        final String sql = "UPDATE collections\n" +
                "SET title = ?, description = ? , shared = ?\n" +
                "WHERE collection_id = ?;";
        try {
            int numberOfRows = jdbcTemplate.update(sql, collection.getTitle(), collection.getDescription(), collection.getShared(), collection.getCollection_id());
            updatedCollection = getCollectionById(collection.getCollection_id());
            if (numberOfRows == 0){
                throw new DaoException("Zero rows returned");
            }
        }catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);

        }catch (DataIntegrityViolationException e){
            throw new DaoException("Data Integrity violation", e);
        }
        return updatedCollection;
    }
    public Collection deleteCollection(Collection collection) {
        Collection deletedCollection = null;
        final String sql = "DELETE FROM collections WHERE collection_id = ? RETURNING *;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, collection.getCollection_id());
            if (results.next()) {
                deletedCollection = mapRowToCollection(results);
            } else {
                throw new DaoException("Collection not found or could not be deleted");
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity violation", e);
        }
        return deletedCollection;
    }

    @Override
    public Collection getCollectionById(int collection_id) {
        return null;
    }

    @Override
    public List<Collection> getCollectionByUser_Id(int user_id) {
        final List<Collection> userCollections = new ArrayList<>();
        final String sql = "SELECT collection_id, user_id, title, description, shared, create_date FROM collections WHERE user_id = ?;";
        try {
            final SqlRowSet results = jdbcTemplate.queryForRowSet(sql, user_id);
            while (results.next()) {
                userCollections.add(mapRowToCollection(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("unable to connect to server or database", e);
        }
        return userCollections;
    }
    Collection mapRowToCollection(SqlRowSet rowSet) {
        Collection collection = new Collection();
        collection.setCollection_id(rowSet.getInt("collection_id"));
        collection.setUser_id(rowSet.getInt("user_id"));
        collection.setTitle(rowSet.getString("title"));
        collection.setDescription(rowSet.getString("description"));
        collection.setShared(rowSet.getBoolean("shared"));
        collection.setCreateDate(rowSet.getTimestamp("create_date"));
        return collection;
    }





}


