package org.example.dao.interfaces;


import org.example.models.Regions;

public interface IRegionsDAO {
    Regions getRegionById(int id);
    void saveRegion(Regions region);
    void updateRegion(Regions region);
    void removeRegion(Regions region);

}
