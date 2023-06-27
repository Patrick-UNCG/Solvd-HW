package org.example.dao.mappers;

import org.apache.ibatis.annotations.*;
import org.example.models.Professors;

public interface ProfessorsMapperJava {
    @Select("Select Professor_ID, First_Name, Last_Name from Professors where Professor_ID = #{Professor_ID}")
    @Results(value = {
            @Result(property = "professorId", column = "Professor_ID"),
            @Result(property="firstName", column = "First_Name"),
            @Result(property = "lastName", column = "Last_Name")
            // ...
    })
    Professors getProfessorById(int id);

    @Insert("Insert into Professors(Professor_ID, First_Name, Last_Name) values (#{professorId}, #{firstName}, #{lastName})")
    void saveProfessor(Professors professor);
    @Update("Update Professors set First_Name=#{firstName}, Last_Name=#{lastName} where Professor_ID=#{professorId}")
    void updateProfessor(Professors professor);

    @Delete("Delete from Professors where Professor_ID=#{professorId}")
    void removeProfessor(Professors professor);
}
