package com.sg.SuperHero.dao;

import com.sg.SuperHero.dao.Mappers.OrganizationMapper;
import com.sg.SuperHero.dto.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {
    @Autowired
    JdbcTemplate jdbc;

    @Override
    @Transactional
    public List<Organization> getAllOrganizations() {
        final String SELECT_ALL_ORGANIZATIONS = "SELECT *\n" +
                "FROM organizations;";
        return jdbc.query(SELECT_ALL_ORGANIZATIONS, new OrganizationMapper());
    }

    @Override
    public Organization getOrganizationById(int id) {
//        try{
//            final String GET_ORGANIZATION_BY_ID
//            return null;
//        } catch(DataAccessException err) {
//            return null;
//        }
        return null;
    }

    @Override
    public Organization addOrganization(Organization organization) {
//        final String INSERT_ORGANIZATION = "INSERT INTO organizations (organizationName, organizationDesc, organizationAddress, organizationContactInfo, organizationIsHero)\n" +
//                "VALUES(?,?,?,?,?);";
//        jdbc.update(INSERT_ORGANIZATION,
//                organization.getOrganizationName(),
//                organization.getOrganizationDesc(),
//                organization.getOrganizationAddress(),
//                organization.getOrganizationContactInfo(),
//                organization.organizationIsHero());
//
//        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID();", Integer.class);
//        organization.setOrganizationId(newId);
//
        return null;
    }

    @Override
    public void updateOrganization(Organization organization) {
//        final String UPDATE_ORGANIZATION = "UPDATE organizations\n" +
//                "SET organizationName = ?, organizationDesc = ?, organizationAddress = ?, organizationContactInfo = ?, organizationIsHero = ?\n" +
//                "WHERE organizationId = ?;";
//        jdbc.update(UPDATE_ORGANIZATION,
//                organization.getOrganizationName(),
//                organization.getOrganizationDesc(),
//                organization.getOrganizationAddress(),
//                organization.getOrganizationContactInfo(),
//                organization.organizationIsHero());
//
//        // Delete from Bridge table 'superhumanorganizations'
//        final String DELETE_SUPERHUMAN_ORGANIZATION = "DELETE FROM superhumanorganizations\n" +
//                "WHERE superhumanorganizations.organizationId = ?;";
//        jdbc.update(DELETE_SUPERHUMAN_ORGANIZATION, organization.getOrganizationId());

    }

    @Override
    @Transactional
    public void deleteOrganizationById(int id) {
        final String DELETE_ORGANIZATION_FROM_SUPERHUMAN = "DELETE FROM superhumanorganizations\n" +
                "WHERE organizationId = ?;";
        jdbc.update(DELETE_ORGANIZATION_FROM_SUPERHUMAN, id);

        final String DELETE_ORGANIZATION = "DELETE FROM organizations\n" +
                "WHERE OrganizationId = ?;";
        jdbc.update(DELETE_ORGANIZATION, id);
    }
}
