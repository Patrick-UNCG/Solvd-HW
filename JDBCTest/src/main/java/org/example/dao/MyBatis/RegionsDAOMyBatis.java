package org.example.dao.MyBatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.dao.mappers.RegionsMapperJava;
import org.example.models.Regions;

import java.io.IOException;
import java.io.InputStream;

public class RegionsDAOMyBatis {
    public static Regions getRegionById(int id) throws IOException {
        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()){
            RegionsMapperJava regionMapperJava = session.getMapper(RegionsMapperJava.class);
            Regions regionMyBatis = regionMapperJava.getRegionById(id);
            return regionMyBatis;
        }
    }

    public static void saveRegion(Regions region) throws IOException {
        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){
            RegionsMapperJava regionMapperJava = session.getMapper(RegionsMapperJava.class);
            regionMapperJava.saveRegion(region);
        }
    }

    public static void updateRegion(Regions region) throws IOException {
        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){
            RegionsMapperJava regionMapperJava = session.getMapper(RegionsMapperJava.class);
            regionMapperJava.updateRegion(region);
        }
    }

    public static void removeRegion(Regions region) throws IOException {
        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){
            RegionsMapperJava regionMapperJava = session.getMapper(RegionsMapperJava.class);
            regionMapperJava.removeRegion(region);
        }
    }
}
