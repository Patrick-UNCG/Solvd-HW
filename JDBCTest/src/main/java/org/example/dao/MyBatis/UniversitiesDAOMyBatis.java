package org.example.dao.MyBatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.dao.mappers.UniversitiesMapperJava;
import org.example.models.Universities;

import java.io.IOException;
import java.io.InputStream;

public class UniversitiesDAOMyBatis {
    public static Universities getUniversityById(int id) throws IOException {
        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()){
            UniversitiesMapperJava universityMapperJava = session.getMapper(UniversitiesMapperJava.class);
            Universities universityMyBatis = universityMapperJava.getUniversityById(id);
            return universityMyBatis;
        }
    }

    public static void saveUniversity(Universities university) throws IOException {
        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){
            UniversitiesMapperJava universityMapperJava = session.getMapper(UniversitiesMapperJava.class);
            universityMapperJava.saveUniversity(university);
        }
    }

    public static void updateUniversity(Universities university) throws IOException {
        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){
            UniversitiesMapperJava universityMapperJava = session.getMapper(UniversitiesMapperJava.class);
            universityMapperJava.updateUniversity(university);
        }
    }

    public static void removeUniversity(Universities university) throws IOException {
        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){
            UniversitiesMapperJava universityMapperJava = session.getMapper(UniversitiesMapperJava.class);
            universityMapperJava.removeUniversity(university);
        }
    }
}
