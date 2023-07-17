package com.sg.SuperHero.dto;

import java.util.Objects;


public class Location {


        private int locationId;


        private String locationName;


        private String locationDesc;


        private String locationAddress;


        private String locationLatitude;


        private String locationLongitude;


        public String getLocationAddress() {
            return locationAddress;
        }


        public void setLocationAddress(String locationAddress) {
            this.locationAddress = locationAddress;
        }


        public String getLocationDesc() {
            return locationDesc;
        }


        public void setLocationDesc(String locationDesc) {
            this.locationDesc = locationDesc;
        }


        public int getLocationId() {
            return locationId;
        }


        public void setLocationId(int locationId) {
            this.locationId = locationId;
        }


        public String getLocationLatitude() {
            return locationLatitude;
        }


        public void setLocationLatitude(String locationLatitude) {
            this.locationLatitude = locationLatitude;
        }


        public String getLocationLongitude() {
            return locationLongitude;
        }


        public void setLocationLongitude(String locationLongitude) {
            this.locationLongitude = locationLongitude;
        }


        public String getLocationName() {
            return locationName;
        }


        public void setLocationName(String locationName) {
            this.locationName = locationName;
        }


        @Override
        public String toString() {
            return "Location{" +
                    "locationId=" + locationId +
                    ", locationName='" + locationName + '\'' +
                    ", locationDesc=" + locationDesc + '\'' +
                    ", locationAddress=" + locationAddress + '\'' +
                    ", locationLatitude=" + locationLatitude + '\'' +
                    ", locationLongitude=" + locationLongitude +
                    '}';
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Location location)) return false;
            return getLocationId() == location.getLocationId() && Objects.equals(getLocationName(), location.getLocationName()) && Objects.equals(getLocationDesc(), location.getLocationDesc()) && Objects.equals(getLocationAddress(), location.getLocationAddress()) && Objects.equals(getLocationLatitude(), location.getLocationLatitude()) && Objects.equals(getLocationLongitude(), location.getLocationLongitude());
        }


        @Override
        public int hashCode() {
            return Objects.hash(getLocationId(), getLocationName(), getLocationDesc(), getLocationAddress(), getLocationLatitude(), getLocationLongitude());
        }
    }

