package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Collection;
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

}


