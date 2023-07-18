package com.sg.SuperHero.dao.Mappers;

import com.sg.SuperHero.dto.SuperHuman;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class SuperhumanMapper implements RowMapper<SuperHuman> {
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
