package com.sg.SuperHero.dto;

public class SuperPower{
    //generate setter and getter methods for superPowerName, superPowerDesc
    private int superpowerID;
    private String superpowerName;
    private String superPowerDesc;
    public SuperPower() {
        // Empty constructor
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        SuperPower that = (SuperPower) object;
        return superpowerID == that.superpowerID && java.util.Objects.equals(superpowerName, that.superpowerName) && java.util.Objects.equals(superPowerDesc, that.superPowerDesc);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), superpowerID, superpowerName, superPowerDesc);
    }

    public int getSuperpowerID() {
        return superpowerID;
    }

    public void setSuperpowerID(int superpowerID) {
        this.superpowerID = superpowerID;
    }

    public String getSuperpowerName() {
        return superpowerName;
    }

    public void setSuperpowerName(String superpowerName) {
        this.superpowerName = superpowerName;
    }

    public String getSuperPowerDesc() {
        return superPowerDesc;
    }

    public void setSuperPowerDesc(String superPowerDesc) {
        this.superPowerDesc = superPowerDesc;
    }

    public SuperPower(int superpowerID) {
        this.superpowerID = superpowerID;
    }
}