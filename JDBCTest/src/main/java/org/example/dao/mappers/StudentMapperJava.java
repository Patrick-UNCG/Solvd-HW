package org.example.dao.mappers;

import org.apache.ibatis.annotations.*;
import org.example.models.Student;

public interface StudentMapperJava {
    @Select("Select Student_ID, First_Name, Last_Name, Universities_University_ID from Students where Student_ID = #{Student_ID}")
    @Results(value = {
            @Result(property = "studentId", column = "Student_ID"),
            @Result(property="firstName", column = "First_Name"),
            @Result(property = "lastName", column = "Last_Name"),
            @Result(property = "universityId", column = "Universities_University_ID")
            // ...
    })
    Student getStudentById(int id);

    @Insert("Insert into Students(Student_ID, First_Name, Last_Name, Universities_University_ID) values (#{studentId}, #{firstName}, #{lastName}, #{universityId})")
    void saveStudent(Student student);
    @Update("Update Students set First_Name=#{firstName}, Last_Name=#{lastName}, Universities_University_ID=#{universityId} where Student_ID=#{studentId}")
    void updateStudent(Student student);

    @Delete("Delete from Students where Student_ID=#{studentId}")
    void removeStudent(Student student);
}
