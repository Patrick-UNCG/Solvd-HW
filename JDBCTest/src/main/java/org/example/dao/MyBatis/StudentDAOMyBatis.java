package org.example.dao.MyBatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.dao.mappers.StudentMapperJava;
import org.example.models.Student;

import java.io.IOException;
import java.io.InputStream;

public class StudentDAOMyBatis{
    public static Student getStudentById(int id) throws IOException {
        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()){
            StudentMapperJava studentMapperJava = session.getMapper(StudentMapperJava.class);
            Student studentMyBatis = studentMapperJava.getStudentById(id);
            return studentMyBatis;
        }
    }

    public static void saveStudent(Student student) throws IOException {
        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){
            StudentMapperJava studentMapperJava = session.getMapper(StudentMapperJava.class);
            studentMapperJava.saveStudent(student);
        }
    }

    public static void updateStudent(Student student) throws IOException {
        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){
            StudentMapperJava studentMapperJava = session.getMapper(StudentMapperJava.class);
            studentMapperJava.updateStudent(student);
        }
    }

    public static void removeStudent(Student student) throws IOException {
        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){
            StudentMapperJava studentMapperJava = session.getMapper(StudentMapperJava.class);
            studentMapperJava.removeStudent(student);
        }
    }


}
