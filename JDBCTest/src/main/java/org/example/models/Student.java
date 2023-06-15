package org.example.models;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "student")
@XmlType(propOrder = { "studentId", "firstName", "lastName" })
public class Student {
    private String firstName;
    private String lastName;

    private int studentId;

    private int universityId;


    public Student(int studentId,String firstName, String lastName, int universityId) {
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

    @XmlTransient
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
