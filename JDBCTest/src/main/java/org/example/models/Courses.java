package org.example.models;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "course")
@XmlType(propOrder = { "courseId", "courseName" })


public class Courses {

    int courseId;
    String courseName;

    public Courses() {
    }

    public Courses(int courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
