package com.sg.SuperHero.dto;

import java.util.Date;

public class Sighting {

    private int sightingId;
    private int superhumanId;
    private int locationId;
    private Date dateSeen;

    public Integer getSightingId() {
        return sightingId;
    }

    public void setSightingId(Integer sightingId) {
        this.sightingId = sightingId;
    }

    public Integer getSuperhumanId() {
        return superhumanId;
    }

    public void setSuperhumanId(Integer superhumanId) {
        this.superhumanId = superhumanId;
    }
    
    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
    
    public Date getDateSeen() {
        return dateSeen;
    }

    public void setDateSeen(Date dateSeen) {
        this.dateSeen = dateSeen;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.sightingId;
        hash = 29 * hash + this.superhumanId;
        hash = 29 * hash + this.locationId;
        hash = 29 * hash + (this.dateSeen != null ? this.dateSeen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sighting other = (Sighting) obj;
        if (this.sightingId != other.sightingId) {
            return false;
        }
        if (this.superhumanId != other.superhumanId) {
            return false;
        }
        if (this.locationId != other.locationId) {
            return false;
        }
        return this.dateSeen == other.dateSeen || (this.dateSeen != null && this.dateSeen.equals(other.dateSeen));
    }
}