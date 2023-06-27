package org.example.dao.interfaces;

import org.example.models.Universities;

public interface IUniversitiesDAO {
    Universities getUniversityById(int id);
    void saveUniversity(Universities university);
    void updateUniversity(Universities university);
    void removeUniversity(Universities university);
}
