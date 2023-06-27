package org.example.View;

public class StudentView {
    public StudentView() {
    }
    public void printStudentDetails(int id, String firstName, String lastName, int universityId){
        System.out.println("Student: ");
        System.out.println("Full Name: " +firstName+" "+lastName);
        System.out.println("ID: " +id);
        System.out.println("University ID: " + universityId);
    }
}
