package org.example.dao.MyBatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.dao.mappers.CountriesMapperJava;
import org.example.models.Countries;

import java.io.IOException;
import java.io.InputStream;

public class CountriesDAOMyBatis {
    public static Countries getCountryById(int id) throws IOException {
        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()){
            CountriesMapperJava countryMapperJava = session.getMapper(CountriesMapperJava.class);
            Countries countriesMyBatis = countryMapperJava.getCountryById(id);
            return countriesMyBatis;
        }
    }

    public static void saveCountry(Countries country) throws IOException {
        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){
            CountriesMapperJava countryMapperJava = session.getMapper(CountriesMapperJava.class);
            countryMapperJava.saveCountry(country);
        }
    }

    public static void updateCountry(Countries country) throws IOException {
        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){
            CountriesMapperJava countryMapperJava = session.getMapper(CountriesMapperJava.class);
            countryMapperJava.updateCountry(country);
        }
    }

    public static void removeCountry(Countries country) throws IOException {
        try(InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true)){
            CountriesMapperJava countryMapperJava = session.getMapper(CountriesMapperJava.class);
            countryMapperJava.removeCountry(country);
        }
    }
}
