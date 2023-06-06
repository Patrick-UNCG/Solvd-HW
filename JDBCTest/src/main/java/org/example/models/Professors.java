package org.example.models;

public class Professors {
    int professorId;
    String firstName;
    String lastName;

    public Professors() {
    }

    public Professors(int professorId, String firstName, String lastName) {
        this.professorId = professorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
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

    @Override
    public String toString() {
        return "Professors{" +
                "professorId=" + professorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
