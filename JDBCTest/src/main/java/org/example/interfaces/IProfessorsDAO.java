package org.example.interfaces;

import org.example.models.Professors;

import java.sql.SQLException;

public interface IProfessorsDAO {
    Professors getProfessorById(int id) throws SQLException;
    void saveProfessor(Professors professor);
    void updateProfessor(Professors professor);
    void removeProfessor(Professors professor);
}
