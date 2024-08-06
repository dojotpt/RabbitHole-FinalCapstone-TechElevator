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
public class JdbcCollectionDao implements CollectionDao{

    private JdbcTemplate jdbcTemplate;
    public JdbcCollectionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public List<Collection> getAll() {
        final String sql = "SELECT collection_id, user_id, title, description, shared\n" +
                "FROM collections;";

        final List<Collection> collections = new ArrayList<>();
        try {
            SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                final Collection collection = new Collection(
                        results.getInt("collection_id"),
                        results.getInt("user_id"),
                        results.getString("title"),
                        results.getString("description"),
                        results.getBoolean("shared")

                );
                collections.add(collection);
            }
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return collections;
    }

}
