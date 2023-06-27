package org.example.dao.mappers;

import org.apache.ibatis.annotations.*;
import org.example.models.Universities;

public interface UniversitiesMapperJava {
    @Select("Select University_ID, University_Name, Addresses_Address_ID from Universities where University_ID = #{University_ID}")
    @Results(value = {
            @Result(property = "universityId", column = "University_ID"),
            @Result(property="universityName", column = "University_Name"),
            @Result(property = "addressId", column = "Addresses_Address_ID")
            // ...
    })
    Universities getUniversityById(int id);

    @Insert("Insert into Universities(University_ID, University_Name, Addresses_Address_ID) values (#{universityId}, #{universityName}, #{addressId})")
    void saveUniversity(Universities university);
    @Update("Update Universities set University_Name=#{universityName}, Addresses_Address_ID=#{addressId} where University_ID=#{universityId}")
    void updateUniversity(Universities university);

    @Delete("Delete from Universities where University_ID=#{universityId}")
    void removeUniversity(Universities university);
}
