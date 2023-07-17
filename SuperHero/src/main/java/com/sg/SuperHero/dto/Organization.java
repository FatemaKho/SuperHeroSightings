package com.sg.SuperHero.dto;

import java.util.Objects;

public class Organization {
    private int organizationId;
    private String organizationName;
    private String organizationDesc;
    private String organizationAddress;
    private String organizationContactInfo;
    private Boolean organizationIsHero;

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationDesc() {
        return organizationDesc;
    }

    public void setOrganizationDesc(String organizationDesc) {
        this.organizationDesc = organizationDesc;
    }

    public String getOrganizationAddress() {
        return organizationAddress;
    }

    public void setOrganizationAddress(String organizationAddress) {
        this.organizationAddress = organizationAddress;
    }

    public String getOrganizationContactInfo() {
        return organizationContactInfo;
    }

    public void setOrganizationContactInfo(String organizationContactInfo) {
        this.organizationContactInfo = organizationContactInfo;
    }

    public Boolean organizationIsHero() {
        return organizationIsHero;
    }

    public void setOrganizationIsHero(Boolean organizationIsHero) {
        this.organizationIsHero = organizationIsHero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (organizationId != that.organizationId) return false;
        if (!Objects.equals(organizationName, that.organizationName))
            return false;
        if (!Objects.equals(organizationDesc, that.organizationDesc))
            return false;
        if (!Objects.equals(organizationAddress, that.organizationAddress))
            return false;
        if (!Objects.equals(organizationContactInfo, that.organizationContactInfo))
            return false;
        return Objects.equals(organizationIsHero, that.organizationIsHero);
    }

    @Override
    public int hashCode() {
        int result = organizationId;
        result = 31 * result + (organizationName != null ? organizationName.hashCode() : 0);
        result = 31 * result + (organizationDesc != null ? organizationDesc.hashCode() : 0);
        result = 31 * result + (organizationAddress != null ? organizationAddress.hashCode() : 0);
        result = 31 * result + (organizationContactInfo != null ? organizationContactInfo.hashCode() : 0);
        result = 31 * result + (organizationIsHero != null ? organizationIsHero.hashCode() : 0);
        return result;
    }
}
