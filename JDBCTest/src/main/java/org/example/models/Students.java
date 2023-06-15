package org.example.models;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name="students")
public class Students {
    @XmlElement(name = "student")
    private List<Student> students = null;


    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
