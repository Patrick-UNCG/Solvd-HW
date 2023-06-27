package org.example.Factories;

import org.example.models.*;

public class ProfessorsFactory extends AbstractFactory{
    @Override
    Student getStudent(String student) {
        return null;
    }

    @Override
    public Professors getProfessor(String professor) {
        if(professor == null){
            return null;
        }

        if(professor.equalsIgnoreCase("Professor")){
            return new Professors();
        }
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
