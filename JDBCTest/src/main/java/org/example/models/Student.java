package org.example.models;

public class Student {
    private String firstName;
    private String lastName;

    private int studentId;

    private int universityId;


    public Student(String firstName, String lastName, int studentId, int universityId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.universityId = universityId;
    }

    public Student() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getUniversityId() {
        return universityId;
    }

    public void setUniversityId(int universityId) {
        this.universityId = universityId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentId=" + studentId +
                ", universityId=" + universityId +
                '}';
    }
}
