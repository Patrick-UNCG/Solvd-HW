package org.example.Factories;

import org.example.models.*;

public class UniversitiesFactory extends AbstractFactory{

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
        return null;
    }

    @Override
    public Universities getUniversity(String university) {
        if(university == null){
            return null;
        }

        if(university.equalsIgnoreCase("University")){
            return new Universities();
        }

        return null;
    }

    @Override
    Regions getRegion(String region) {
        return null;
    }
}
