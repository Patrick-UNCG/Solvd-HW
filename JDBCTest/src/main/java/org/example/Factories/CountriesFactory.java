package org.example.Factories;

import org.example.models.*;

public class CountriesFactory extends AbstractFactory{
    @Override
    Student getStudent(String student) {
        return null;
    }

    @Override
    Professors getProfessor(String professor) {
        return null;
    }

    @Override
    public Countries getCountry(String country) {
        if(country == null){
            return null;
        }

        if(country.equalsIgnoreCase("Country")){
            return new Countries();
        }
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
