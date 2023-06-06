package org.example.models;

public class Universities {
    int universityId;
    String universityName;
    int addressId;

    public Universities() {
    }

    public Universities(int universiyId, String universityName, int addressId) {
        this.universityId = universiyId;
        this.universityName = universityName;
        this.addressId = addressId;
    }

    public int getUniversityId() {
        return universityId;
    }

    public void setUniversityId(int universiyId) {
        this.universityId = universiyId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "Universities{" +
                "universiyId=" + universityId +
                ", universityName='" + universityName + '\'' +
                ", addressId=" + addressId +
                '}';
    }
}
