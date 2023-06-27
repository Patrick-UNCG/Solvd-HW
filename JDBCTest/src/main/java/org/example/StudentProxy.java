package org.example;

import org.example.models.Student;

public class StudentProxy implements IStudent{
    Student student;
    private String firstName;
    private String lastName;
    private int studentId;
    private int universityId;

    public StudentProxy(int studentId,String firstName, String lastName, int universityId){
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.universityId = universityId;
    }

    @Override
    public void printFullName() {
        if(student == null){
            student = new Student(studentId,firstName, lastName, universityId);
        }
        student.printFullName();
    }
}
