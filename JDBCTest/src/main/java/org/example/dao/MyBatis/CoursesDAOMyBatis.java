package org.example.dao.MyBatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.dao.mappers.CoursesMapperJava;
import org.example.models.Courses;

import java.io.IOException;
import java.io.InputStream;

public class CoursesDAOMyBatis {
    public static Courses getCourseById(int id) throws IOException {
        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()){
            CoursesMapperJava coursesMapperJava = session.getMapper(CoursesMapperJava.class);
            Courses coursesMyBatis = coursesMapperJava.getCourseById(id);
            return coursesMyBatis;
        }
    }

    public static void saveCourse(Courses course) throws IOException {
        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){
            CoursesMapperJava coursesMapperJava = session.getMapper(CoursesMapperJava.class);
            coursesMapperJava.saveCourse(course);
        }
    }

    public static void updateCourse(Courses course) throws IOException {
        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){
            CoursesMapperJava coursesMapperJava = session.getMapper(CoursesMapperJava.class);
            coursesMapperJava.updateCourse(course);
        }
    }

    public static void removeCourse(Courses course) throws IOException {
        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){
            CoursesMapperJava coursesMapperJava = session.getMapper(CoursesMapperJava.class);
            coursesMapperJava.removeCourse(course);
        }
    }
}
