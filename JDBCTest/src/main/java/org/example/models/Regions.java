package org.example.models;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "region")
@XmlType(propOrder = { "regionId", "regionName" })

public class Regions {
    int regionId;
    String regionName;

    public Regions() {
    }

    public Regions(int regionId, String regionName) {
        this.regionId = regionId;
        this.regionName = regionName;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public String toString() {
        return "Regions{" +
                "regionId=" + regionId +
                ", regionName='" + regionName + '\'' +
                '}';
    }
}
