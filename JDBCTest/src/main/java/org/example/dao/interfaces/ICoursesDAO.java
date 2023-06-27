package org.example.dao.interfaces;

import org.example.models.Courses;

import java.sql.SQLException;

public interface ICoursesDAO {

    Courses getCourseById(int id) ;
    void saveCourse(Courses courses);

    void removeCourse(Courses entity);

    void updateCourse(Courses entity) ;
}
