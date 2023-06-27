package org.example.Factories;

import org.example.models.*;

public class CoursesFactory extends AbstractFactory{
    @Override
    Student getStudent(String student) {
        return null;
    }

    @Override
    Professors getProfessor(String professor) {
        return null;
    }

    @Override
    Countries getCountry(String country) {
        return null;
    }

    @Override
    Courses getCourse(String course) {
        if(course == null){
            return null;
        }

        if(course.equalsIgnoreCase("Course")){
            return new Courses();
        }
        return null;
    }

    @Override
    Universities getUniversity(String university) {
        return null;
    }

    @Override
    Regions getRegion(String region) {
        return null;
    }
}
