package org.example.Factories;

import org.example.models.*;

public abstract class AbstractFactory {
    abstract Student getStudent(String student);
    abstract Professors getProfessor(String professor);
    abstract Countries getCountry(String country);
    abstract Courses getCourse(String course);
    abstract Universities getUniversity(String university);
    abstract Regions getRegion(String region);


}
