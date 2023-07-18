package com.sg.SuperHero.dao;

import com.sg.SuperHero.dao.Mappers.OrganizationMapper;
import com.sg.SuperHero.dao.Mappers.SuperhumanMapper;
import com.sg.SuperHero.dto.Organization;
import com.sg.SuperHero.dto.SuperHuman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
        try {
            final String SELECT_ORGANIZATION_BY_ID = "SELECT *\n" +
                    "FROM organizations\n" +
                    "WHERE OrganizationId = ?;";

            return jdbc.queryForObject(SELECT_ORGANIZATION_BY_ID, new OrganizationMapper(), id);
        } catch(DataAccessException err) {
            return null;
        }
    }

    /**
     * This method inserts a new organization into 'organizations' table.
     */
    @Override
    public Organization addOrganization(Organization organization) {
        // Query to insert a new organization into the 'organizations' table with its attributes
        final String INSERT_ORGANIZATION = "INSERT INTO organizations (organizationName, organizationDesc, organizationAddress, organizationContactInfo, organizationIsHero)\n" +
                "VALUES(?,?,?,?,?);";
        jdbc.update(INSERT_ORGANIZATION,
                organization.getOrganizationName(),
                organization.getOrganizationDesc(),
                organization.getOrganizationAddress(),
                organization.getOrganizationContactInfo(),
                organization.getOrganizationIsHero());

        // Retrieves new generated ID of the inserted organization
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID();", Integer.class);
        // Sets the organizationId of the 'organization' object to newly generated ID above
        organization.setOrganizationId(newId);

        // Inserts and updates the appropriate records into the 'superhumanorganizations' table
        insertSuperhumanOrganization(organization);

        // Returns 'organization' object
        return organization;
    }

    /**
     * Inserts relationship between a given organization and its list of superhumans
     * into 'superhumanorganizations' table.
     */
    private void insertSuperhumanOrganization(Organization organization) {
        // Query to insert a new row into 'superhumanorganizations' table
        final String INSERT_SUPERHUMAN_ORGANIZATION = "INSERT INTO superhumanorganizations (superhumanId, organizationId)\n" +
                "VALUES (?,?);";

        try {
            // Insert relationship for each superhuman in organization's list of superhumans.
            // Iterates over each 'SuperHuman' object using a for-each loop
            for(SuperHuman superHuman : organization.getListOfSuperhumans()) {
                // Executes SQL insert statement:
                // Retrieves the ID of current superhuman, and retrieves the ID of organization.
                jdbc.update(INSERT_SUPERHUMAN_ORGANIZATION, superHuman.getSuperhumanId(), organization.getOrganizationId());
            }
        } catch(NullPointerException err) {
        }
    }

    @Override
    public void updateOrganization(Organization organization) {
        final String UPDATE_ORGANIZATION =
                "UPDATE organizations " +
                "SET organizationName = ?, " +
                "organizationDesc = ?, " +
                "organizationAddress = ?, " +
                "organizationContactInfo = ?, " +
                "organizationIsHero = ? " +
                "WHERE OrganizationId = ?;";
        jdbc.update(UPDATE_ORGANIZATION,
                organization.getOrganizationName(),
                organization.getOrganizationDesc(),
                organization.getOrganizationAddress(),
                organization.getOrganizationContactInfo(),
                organization.getOrganizationIsHero(),
                organization.getOrganizationId());

        // Delete from Bridge table 'superhumanorganizations'
        final String DELETE_SUPERHUMAN_ORGANIZATION = "DELETE FROM superhumanorganizations\n" +
                "WHERE superhumanorganizations.organizationId = ?;";
        jdbc.update(DELETE_SUPERHUMAN_ORGANIZATION, organization.getOrganizationId());
        insertSuperhumanOrganization(organization);
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

    /**
     * The system must be able to report all of the organizations a particular superhero/villain belongs to.
     * */
    @Override
    public List<Organization> getOrganizationsBySuperhumanId(int id) {
        try{
            final String SELECT_ALLORGANIZATIONS_BY_SUPERHUMANID =
                    "SELECT org.OrganizationId, org.organizationName, org.organizationDesc, org.organizationDesc, org.organizationAddress, org.organizationContactInfo, org.organizationIsHero\n" +
                            "FROM organizations org\n" +
                            "JOIN superhumanorganizations sho\n" +
                            "\tON org.OrganizationId = sho.organizationId\n" +
                            "WHERE sho.superhumanId = ?;";
            return jdbc.query(SELECT_ALLORGANIZATIONS_BY_SUPERHUMANID, new OrganizationMapper(), id);
        } catch (DataAccessException err) {
            // Handle the exception and throw the below message
            System.out.println("Error retrieving organizations for a superhuman with ID " + id);
            // Return empty list
            return null;
        }
    }

    /**
     * The system must be able to report all of the members of a particular organization.
     * */
    @Override
    public List<SuperHuman> getSuperhumansByOrganizationId(int id) {
        try {
            final String SELECT_SUPERHUMANS_BY_ORGANIZATIONID =
                    "SELECT sh.superhumanId, sh.superhumanName, sh.superhumanDesc, sh.superhumanIsHero, sh.superpowerId\n" +
                            "FROM superhuman sh\n" +
                            "JOIN superhumanorganizations sho\n" +
                            "\tON sh.superhumanId = sho.superhumanId\n" +
                            "WHERE sho.organizationId = ?;";
            return jdbc.query(SELECT_SUPERHUMANS_BY_ORGANIZATIONID, new SuperhumanMapper(), id);
        } catch(DataAccessException err) {
            // Handle the exception and throw the below message
            System.out.println("Error retrieving superhumans for organization with ID " + id);
            // Return empty list
            return null;
        }
    }
}
