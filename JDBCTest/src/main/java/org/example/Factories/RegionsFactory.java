package org.example.Factories;

import org.example.models.*;

public class RegionsFactory extends AbstractFactory{
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
    Universities getUniversity(String university) {
        return null;
    }

    @Override
    public Regions getRegion(String region) {
        if(region == null){
            return null;
        }

        if(region.equalsIgnoreCase("Region")){
            return new Regions();
        }
        return null;
    }
}
