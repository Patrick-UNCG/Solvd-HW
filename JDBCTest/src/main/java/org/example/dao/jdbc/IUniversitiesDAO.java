package org.example.dao.jdbc;

import org.example.models.Universities;

public interface IUniversitiesDAO {
    Universities getUniversityById(int id);
    void saveUniversity(Universities university);
    void updateUniversity(Universities university);
    void removeUniversity(Universities university);
}
