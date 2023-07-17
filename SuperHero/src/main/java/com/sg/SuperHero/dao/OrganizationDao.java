package com.sg.SuperHero.dao;

import com.sg.SuperHero.dto.Organization;

import java.util.List;

public interface OrganizationDao {
    List<Organization> getAllOrganizations();
    Organization getOrganizationById(int id);
    Organization addOrganization(Organization organization);
    void updateOrganization(Organization organization);
    void deleteOrganizationById(int id);
}
