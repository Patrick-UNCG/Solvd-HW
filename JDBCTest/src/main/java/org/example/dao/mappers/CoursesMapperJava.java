package org.example.dao.mappers;

import org.apache.ibatis.annotations.*;
import org.example.models.Courses;

public interface CoursesMapperJava {
    @Select("Select Courses_ID, Courses_Name from Courses where Courses_ID = #{Courses_ID}")
    @Results(value = {
            @Result(property = "courseId", column = "Courses_ID"),
            @Result(property="courseName", column = "Courses_Name"),
    })
    Courses getCourseById(int id);

    @Insert("Insert into Courses(Student_ID, Courses_Name ) values (#{courseId}, #{courseName})")
    void saveCourse(Courses course);
    @Update("Update Courses set Courses_Name=#{courseName} where Courses_ID=#{courseId}")
    void updateCourse(Courses course);

    @Delete("Delete from Courses where Courses_ID=#{courseId}")
    void removeCourse(Courses course);
}
