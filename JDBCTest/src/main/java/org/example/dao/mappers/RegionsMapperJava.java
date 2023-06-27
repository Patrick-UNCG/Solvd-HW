package org.example.dao.mappers;

import org.apache.ibatis.annotations.*;
import org.example.models.Regions;

public interface RegionsMapperJava {
    @Select("Select Region_ID, Region_Name from Regions where Region_ID = #{Region_ID}")
    @Results(value = {
            @Result(property = "regionId", column = "Region_ID"),
            @Result(property="regionName", column = "Region_Name"),
    })
    Regions getRegionById(int id);

    @Insert("Insert into Regions(Region_ID, Region_Name ) values (#{regionId}, #{regionName})")
    void saveRegion(Regions region);
    @Update("Update Regions set Region_Name=#{regionName} where Region_ID=#{regionId}")
    void updateRegion(Regions region);

    @Delete("Delete from Regions where Region_ID=#{regionId}")
    void removeRegion(Regions region);
}
