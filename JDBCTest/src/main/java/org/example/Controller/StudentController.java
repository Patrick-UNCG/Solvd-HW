package org.example.Controller;

import org.example.View.StudentView;
import org.example.models.Student;

public class StudentController {
    private Student student;
    private StudentView studentView;
    public StudentController(Student student, StudentView studentView){
        this.student = student;
        this.studentView = studentView;
    }
    public void setStudentName(String firstName, String lastName){
        student.setFirstName(firstName);
        student.setLastName(lastName);
    }

    public String getStudentName(){
        return student.getFirstName().concat(" ").concat(student.getLastName());
    }

    public void setUniversityID(int id){
        student.setUniversityId(id);
    }

    public int getStudentId(){
        return student.getStudentId();
    }

    public int getUniversityId(){
        return student.getUniversityId();
    }

    public void updateView(){
        studentView.printStudentDetails(student.getStudentId(),student.getFirstName(), student.getLastName(),student.getUniversityId());
    }
}
