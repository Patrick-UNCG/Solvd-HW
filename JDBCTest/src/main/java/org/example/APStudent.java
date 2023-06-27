package org.example;

import org.example.models.Student;

public class APStudent extends Student {
    private double gpa;
    public APStudent(int studentId, String firstName, String lastName, int universityId, double gpa) {
        super(studentId, firstName, lastName, universityId);
        this.gpa = gpa;
    }

    public void printGPA(){
        System.out.println(this.gpa);
    }
}
