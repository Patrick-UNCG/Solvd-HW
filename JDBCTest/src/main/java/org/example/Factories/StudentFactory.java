package org.example.Factories;

import org.example.models.*;

public class StudentFactory extends AbstractFactory{

    @Override
    public Student getStudent(String student) {
        if(student == null){
            return null;
        }

        if(student.equalsIgnoreCase("Student")){
            return new Student();
        }
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
