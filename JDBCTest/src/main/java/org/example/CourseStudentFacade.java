package org.example;

import org.example.models.Courses;
import org.example.models.Student;

public class CourseStudentFacade {
    Student student = new Student();
    Courses course = new Courses();
    public void enrollStudent(){
        student.enroll();
        course.acceptStudent();
    }

    public CourseStudentFacade() {
    }
}
