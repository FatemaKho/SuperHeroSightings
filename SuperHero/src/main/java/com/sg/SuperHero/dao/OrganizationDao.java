package com.sg.SuperHero.dao;

import com.sg.SuperHero.dto.Organization;
import com.sg.SuperHero.dto.SuperHuman;

import java.util.List;

public interface OrganizationDao {
    List<Organization> getAllOrganizations();
    List<Organization> getOrganizationsBySuperhumanId(int id);
    List<SuperHuman> getSuperhumansByOrganizationId(int id);
    Organization getOrganizationById(int id);
    Organization addOrganization(Organization organization);
    void updateOrganization(Organization organization);
    void deleteOrganizationById(int id);
}
