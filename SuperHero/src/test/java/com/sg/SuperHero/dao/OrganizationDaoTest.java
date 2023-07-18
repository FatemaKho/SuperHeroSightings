package com.sg.SuperHero.dao;

import com.sg.SuperHero.SuperHeroApplication;
import com.sg.SuperHero.dto.*;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SuperHeroApplication.class)
public class OrganizationDaoTest {
    @Autowired
    OrganizationDao organizationDao;

    @Autowired
    SuperHumanDao superHumanDao;

    @Autowired
    LocationDao locationDao;

    @Autowired
    SightingDao sightingDao;


    @BeforeEach
    void setUp() {
        List<Organization> allOrganizations = organizationDao.getAllOrganizations();

        // Delete all Organizations
        for(Organization organization : allOrganizations) {
            organizationDao.deleteOrganizationById(organization.getOrganizationId());
        }

        List<Location> locations = locationDao.getAllLocations();
        for(Location location : locations) {
            locationDao.deleteLocationById(location.getLocationId());
        }

        List<Sighting> sightings = sightingDao.getAllSightings();
        for(Sighting sighting : sightings) {
            sightingDao.deleteSighting(sighting.getSightingId());
        }

        List<SuperHuman> superHumans = superHumanDao.getAll();
        for(SuperHuman superHuman : superHumans) {
            superHumanDao.delete(superHuman.getSuperhumanId());
        }

    }

    @Test
    public void testGetAllOrganizations() {
        // Arrange: Create two organizations
        Organization organization1 = new Organization();
        organization1.setOrganizationName("The Massive Spider");
        organization1.setOrganizationDesc("Fly up to the universe.");
        organization1.setOrganizationAddress("Townville, VA");
        organization1.setOrganizationContactInfo("201-776-8238");
        organization1.setOrganizationIsHero(Boolean.TRUE);
        organization1 = organizationDao.addOrganization(organization1);

        Organization organization2 = new Organization();
        organization2.setOrganizationName("The Undefeated Assassin");
        organization2.setOrganizationDesc("Killers with an attitude.");
        organization2.setOrganizationAddress("Assanville, AZ");
        organization2.setOrganizationContactInfo("256-755-5321");
        organization2.setOrganizationIsHero(Boolean.FALSE);
        organization2 = organizationDao.addOrganization(organization2);

        // Act: Get all organizations from our database
        List<Organization> allOrganizations = organizationDao.getAllOrganizations();

        // Assert: Check if the size of list, and if list contains the inserted Organization
        Assertions.assertEquals(2, allOrganizations.size());
        Assertions.assertTrue(allOrganizations.contains(organization1));
        Assertions.assertTrue(allOrganizations.contains(organization2));
    }

    @Test
    public void testAddAndGetOrganizationById() {
        // Arrange: create a new organization
        Organization organization = new Organization();
        organization.setOrganizationName("The Massive Spider");
        organization.setOrganizationDesc("Fly up to the universe.");
        organization.setOrganizationAddress("Townville, VA");
        organization.setOrganizationContactInfo("201-776-8238");
        organization.setOrganizationIsHero(Boolean.TRUE);
        organization = organizationDao.addOrganization(organization);

        Organization organizationFromDao = organizationDao.getOrganizationById(organization.getOrganizationId());

        // Assert: Check if expected organization matches the added organization
        Assertions.assertEquals(organization, organizationFromDao);
    }

    @Test
    public void testUpdateOrganization() {
        // Arrange: Create two organizations
        Organization organization1 = new Organization();
        organization1.setOrganizationName("The Massive Spider");
        organization1.setOrganizationDesc("Fly up to the universe.");
        organization1.setOrganizationAddress("Townville, VA");
        organization1.setOrganizationContactInfo("201-776-8238");
        organization1.setOrganizationIsHero(Boolean.TRUE);
        organization1 = organizationDao.addOrganization(organization1);

        Organization organization2 = new Organization();
        organization2.setOrganizationName("The Undefeated Assassin");
        organization2.setOrganizationDesc("Killers with an attitude.");
        organization2.setOrganizationAddress("Assanville, AZ");
        organization2.setOrganizationContactInfo("256-755-5321");
        organization2.setOrganizationIsHero(Boolean.FALSE);
        organization2 = organizationDao.addOrganization(organization2);

        // Act: Update attributes with new information
        organization1.setOrganizationAddress("Toronto, CA");
        organizationDao.updateOrganization(organization1);

        organization2.setOrganizationName("The Cobra Defenders");
        organizationDao.updateOrganization(organization2);

        Organization organizationFromDao1 = organizationDao.getOrganizationById(organization1.getOrganizationId());
        Organization organizationFromDao2 = organizationDao.getOrganizationById(organization2.getOrganizationId());

        // Assert
        Assertions.assertEquals(organizationFromDao1, organization1);
        Assertions.assertNotEquals(organizationFromDao1.getOrganizationAddress(), "Townville, VA");
        Assertions.assertNotEquals(organizationFromDao2.getOrganizationName(), "The Undefeated Assassin");
    }

    @Test
    public void testGetOrganizationsBySuperhumanId() {
        // Arrange: create a new organization
        Organization organization = new Organization();
        organization.setOrganizationName("The Massive Spider");
        organization.setOrganizationDesc("Fly up to the universe.");
        organization.setOrganizationAddress("Townville, VA");
        organization.setOrganizationContactInfo("201-776-8238");
        organization.setOrganizationIsHero(Boolean.TRUE);
        // Add organization to database
        organization = organizationDao.addOrganization(organization);

        //
    }

    @Test
    public void testGetSuperhumansByOrganizationId() {
        // Arrange: create a new organization
        Organization organization = new Organization();
        organization.setOrganizationName("The Massive Spider");
        organization.setOrganizationDesc("Fly up to the universe.");
        organization.setOrganizationAddress("Townville, VA");
        organization.setOrganizationContactInfo("201-776-8238");
        organization.setOrganizationIsHero(Boolean.TRUE);
        organization = organizationDao.addOrganization(organization);

        // Arrange: create two new superhumans
        SuperHuman superHuman1 = new SuperHuman();
        superHuman1.setSuperhumanName("Superman");
        superHuman1.setSuperhumanDesc("Goes out to save lives");
        superHuman1.setSuperhumanIsHero(true);
        superHumanDao.create(superHuman1);

        SuperHuman superHuman2 = new SuperHuman();
        superHuman2.setSuperhumanName("Doctor Doom");
        superHuman2.setSuperhumanDesc("Is the archenemy of Reed Richards and the Fantastic Four");
        superHuman2.setSuperhumanIsHero(false);
        superHumanDao.create(superHuman2);

        // Add created superhumans to organization table
        organization.getListOfSuperhumans().add(superHuman1);
        organization.getListOfSuperhumans().add(superHuman2);
        organizationDao.updateOrganization(organization);

        // Get superhumans by organization Id
        List<SuperHuman> superHumans = organizationDao.getSuperhumansByOrganizationId(organization.getOrganizationId());

        // Assert: Check if the superhumans match the added ones to organization
        Assertions.assertEquals(2, superHumans.size());
        Assertions.assertTrue(superHumans.contains(superHuman1));
        Assertions.assertTrue(superHumans.contains(superHuman2));
    }
}
