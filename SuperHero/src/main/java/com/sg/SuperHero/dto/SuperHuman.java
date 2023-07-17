package com.sg.SuperHero.dto;

import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
public class SuperHuman {
        private int superhumanId;
        private String superhumanName;
        private String superhumanDesc;
        private boolean superhumanIsHero;
        private int superpowerId;

// Constructor without ID for creating new SuperHuman if you don't know the ID before insertion.
    public SuperHuman(String superhumanName, String superhumanDesc, boolean superhumanIsHero, int superpowerId) {
        this.superhumanName = superhumanName;
        this.superhumanDesc = superhumanDesc;
        this.superhumanIsHero = superhumanIsHero;
        this.superpowerId = superpowerId;
    }

    // Constructor with ID when you want to retrieve an existing Superhuman from the database.
    public SuperHuman(int superhumanId, String superhumanName, String superhumanDesc, boolean superhumanIsHero, int superpowerId) {
        this.superhumanId = superhumanId;
        this.superhumanName = superhumanName;
        this.superhumanDesc = superhumanDesc;
        this.superhumanIsHero = superhumanIsHero;
        this.superpowerId = superpowerId;
    }



    public int getSuperhumanId() {
        return superhumanId;
    }

    public void setSuperhumanId(int superhumanId) {
        this.superhumanId = superhumanId;
    }

    public String getSuperhumanName() {
        return superhumanName;
    }

    public void setSuperhumanName(String superhumanName) {
        this.superhumanName = superhumanName;
    }

    public String getSuperhumanDesc() {
        return superhumanDesc;
    }

    public void setSuperhumanDesc(String superhumanDesc) {
        this.superhumanDesc = superhumanDesc;
    }

    public boolean isSuperhumanIsHero() {
        return superhumanIsHero;
    }

    public void setSuperhumanIsHero(boolean superhumanIsHero) {
        this.superhumanIsHero = superhumanIsHero;
    }

    public int getSuperpowerId() {
        return superpowerId;
    }

    public void setSuperpowerId(int superpowerId) {
        this.superpowerId = superpowerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SuperHuman that)) return false;
        return superhumanId == that.superhumanId && superhumanIsHero == that.superhumanIsHero && superpowerId == that.superpowerId && Objects.equals(superhumanName, that.superhumanName) && Objects.equals(superhumanDesc, that.superhumanDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(superhumanId, superhumanName, superhumanDesc, superhumanIsHero, superpowerId);
    }

    @Override
    public String toString() {
        return "SuperHuman{" +
                "superhumanId=" + superhumanId +
                ", superhumanName='" + superhumanName + '\'' +
                ", superhumanDesc='" + superhumanDesc + '\'' +
                ", superhumanIsHero=" + superhumanIsHero +
                ", superpowerId=" + superpowerId +
                '}';
    }
}


