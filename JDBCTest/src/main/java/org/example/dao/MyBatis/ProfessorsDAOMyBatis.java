package org.example.dao.MyBatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.dao.mappers.ProfessorsMapperJava;
import org.example.dao.mappers.ProfessorsMapperJava;
import org.example.models.Professors;
import org.example.models.Student;


import java.io.IOException;
import java.io.InputStream;

public class ProfessorsDAOMyBatis {
    public static Professors getProfessorById(int id) throws IOException {
        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()){
            ProfessorsMapperJava professorMapperJava = session.getMapper(ProfessorsMapperJava.class);
            Professors professorMyBatis = professorMapperJava.getProfessorById(id);
            return professorMyBatis;
        }
    }

    public static void saveProfessor(Professors professor) throws IOException {
        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){
            ProfessorsMapperJava professorMapperJava = session.getMapper(ProfessorsMapperJava.class);
            professorMapperJava.saveProfessor(professor);
        }
    }

    public static void updateProfessor(Professors professor) throws IOException {
        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){
            ProfessorsMapperJava professorMapperJava = session.getMapper(ProfessorsMapperJava.class);
            professorMapperJava.updateProfessor(professor);
        }
    }

    public static void removeProfessor(Professors professor) throws IOException {
        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){
            ProfessorsMapperJava professorMapperJava = session.getMapper(ProfessorsMapperJava.class);
            professorMapperJava.removeProfessor(professor);
        }
    }
}
