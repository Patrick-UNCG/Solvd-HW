package org.example.dao.jdbc;

import org.example.models.Student;

import java.sql.SQLException;

public interface IStudentDAO {
    Student getStudentById(int id) throws SQLException;
    void saveStudent(Student student);
    void updateStudent(Student student);
    void removeStudent(Student student);
}
