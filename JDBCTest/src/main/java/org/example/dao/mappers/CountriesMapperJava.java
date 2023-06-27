package org.example.dao.mappers;

import org.apache.ibatis.annotations.*;
import org.example.models.Countries;

public interface CountriesMapperJava {
    @Select("Select Country_ID, Country_Name, Regions_Region_ID from Countries where Country_ID = #{Country_ID}")
    @Results(value = {
            @Result(property = "countryId", column = "Country_ID"),
            @Result(property="countryName", column = "Country_Name"),
            @Result(property = "regionId", column = "Regions_Region_ID")
            // ...
    })
    Countries getCountryById(int id);

    @Insert("Insert into Countries(Country_ID, Country_Name, Regions_Region_ID) values (#{countryId}, #{countryName}, #{regionId})")
    void saveCountry(Countries country);
    @Update("Update Countries set Country_Name=#{countryName}, Regions_Region_ID=#{regionId} where Country_ID=#{countryId}")
    void updateCountry(Countries country);

    @Delete("Delete from Countries where Country_ID=#{countryId}")
    void removeCountry(Countries country);
}
