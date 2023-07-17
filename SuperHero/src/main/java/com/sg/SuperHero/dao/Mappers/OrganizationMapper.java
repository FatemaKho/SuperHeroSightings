package com.sg.SuperHero.dao.Mappers;

import com.sg.SuperHero.dto.Organization;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class OrganizationMapper implements RowMapper<Organization> {
    @Override
    public Organization mapRow(ResultSet rs, int rowNum) throws SQLException {
        Organization organization = new Organization();
        organization.setOrganizationId(rs.getInt("OrganizationId"));
        organization.setOrganizationName(rs.getString("organizationName"));
        organization.setOrganizationDesc(rs.getString("organizationDesc"));
        organization.setOrganizationAddress(rs.getString("organizationAddress"));
        organization.setOrganizationContactInfo(rs.getString("organizationContactInfo"));
        organization.setOrganizationIsHero(rs.getBoolean("organizationIsHero"));

        return organization;
    }
}
