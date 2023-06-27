package org.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;
import org.example.IStudent;

@JsonRootName("Student")
@JsonPropertyOrder({"studentId", "firstName", "lastName"})
@XmlRootElement(name = "student")
@XmlType(propOrder = { "studentId", "firstName", "lastName" })
public class Student implements IStudent{
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("studentId")
    private int studentId;

    @JsonIgnore
    private int universityId;


    public Student(int studentId,String firstName, String lastName, int universityId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.universityId = universityId;
        loadStudent();
    }

    public Student() {

    }

    public Student(StudentBuilder studentBuilder) {
        this.studentId = studentBuilder.getStudentId();
        this.firstName = studentBuilder.getFirstName();
        this.lastName = studentBuilder.getLastName();
        this.universityId = studentBuilder.getUniversityId();
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

    @Override
    public void printFullName() {
        System.out.println(this.firstName + " " + this.lastName);
    }

    public void loadStudent(){
        System.out.println("Loading Student...");
    }

    public void enroll(){
        System.out.println("Enrolling student...");
    }

    public static class StudentBuilder {
        private int studentId;
        private String firstName;
        private String lastName;
        private int universityId;

        public StudentBuilder (int studentId, String firstName, String lastName){
            if(studentId == 0 || firstName == null || lastName == null){
                throw new IllegalArgumentException("id, first name or last name cannot be null");
            }
            this.studentId = studentId;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public StudentBuilder withUniversityId(int universityId){
            this.universityId = universityId;
            return this;
        }

        public Student build(){
            return new Student(this);
        }

        public int getStudentId() {
            return studentId;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }
        public int getUniversityId() {
            return universityId;
        }
    }
}
