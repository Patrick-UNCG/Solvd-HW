package org.example.models;

public class Countries {
    int countryId;
    String countryName;
    int regionId;

    public Countries() {
    }


    public Countries(int countryId, String countryName, int regionId) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.regionId = regionId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "countryId=" + countryId +
                ", countryName='" + countryName + '\'' +
                ", regionId=" + regionId +
                '}';
    }
}
