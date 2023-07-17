package com.sg.SuperHero.dao;

import com.sg.SuperHero.SuperHeroApplication;
import com.sg.SuperHero.dto.Organization;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SuperHeroApplication.class)

public class OrganizationDaoTest {
    @Autowired
    OrganizationDao organizationDao;

    @BeforeEach
    void setUp() {
        List<Organization> allOrganizations = organizationDao.getAllOrganizations();
        for(Organization organization : allOrganizations) {
            organizationDao.deleteOrganizationById(organization.getOrganizationId());
        }
    }

    @Test
    void getAllOrganizations() {
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

        List<Organization> allOrganizations = organizationDao.getAllOrganizations();
        Assertions.assertEquals(2, allOrganizations.size());

        Assertions.assertTrue(allOrganizations.contains(organization1));
        Assertions.assertTrue(allOrganizations.contains(organization2));
    }
}
