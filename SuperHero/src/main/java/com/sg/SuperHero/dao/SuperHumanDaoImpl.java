package com.sg.SuperHero.dao;

import com.sg.SuperHero.dto.SuperHuman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SuperHumanDaoImpl implements SuperHumanDao {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public SuperHumanDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public SuperHuman getById(int superhumanId) {
        String sql = "SELECT * FROM superhuman WHERE superhumanId = ?";
        return jdbcTemplate.queryForObject(sql, new SuperHumanRowMapper(), superhumanId);
    }

    @Override
    public List<SuperHuman> getAll() {
        String sql = "SELECT * FROM superhuman";
        return jdbcTemplate.query(sql, new SuperHumanRowMapper());
    }

    @Override
    public SuperHuman create(SuperHuman superhuman) {
        String sql = "INSERT INTO superhuman (superhumanName, superhumanDesc, superhumanIsHero, superpowerId) " +
                "VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, superhuman.getSuperhumanName(), superhuman.getSuperhumanDesc(),
                superhuman.isSuperhumanIsHero(), superhuman.getSuperpowerId());

        // Retrieve the last inserted ID
        String selectLastIdQuery = "SELECT LAST_INSERT_ID()";
        int superhumanId = jdbcTemplate.queryForObject(selectLastIdQuery, Integer.class);

        // Set the game ID
        superhuman.setSuperhumanId(superhumanId);
        return superhuman;
    }

    @Override
    public void update(SuperHuman superhuman) {
        String sql = "UPDATE superhuman SET superhumanName = ?, superhumanDesc = ?, " +
                "superhumanIsHero = ?, superpowerId = ? WHERE superhumanId = ?";
        jdbcTemplate.update(sql, superhuman.getSuperhumanName(), superhuman.getSuperhumanDesc(),
                superhuman.isSuperhumanIsHero(), superhuman.getSuperpowerId(), superhuman.getSuperhumanId());
    }

    @Override
    public void delete(int superhumanId) {
        String sql = "DELETE FROM superhuman WHERE superhumanId = ?";
        jdbcTemplate.update(sql, superhumanId);
    }

    private static class SuperHumanRowMapper implements RowMapper<SuperHuman> {
        @Override
        public SuperHuman mapRow(ResultSet rs, int rowNum) throws SQLException {
            SuperHuman superhuman = new SuperHuman();
            superhuman.setSuperhumanId(rs.getInt("superhumanId"));
            superhuman.setSuperhumanName(rs.getString("superhumanName"));
            superhuman.setSuperhumanDesc(rs.getString("superhumanDesc"));
            superhuman.setSuperhumanIsHero(rs.getBoolean("superhumanIsHero"));
            superhuman.setSuperpowerId(rs.getInt("superpowerId"));
            return superhuman;
        }
    }
}

