package org.example.dao.jdbc;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.example.ConnectionPool;
import org.example.dao.interfaces.IProfessorsDAO;
import org.example.models.Professors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfessorsDAO implements IProfessorsDAO {
    private static Logger LOGGER = Logger.getLogger(CoursesDAO.class);
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private Connection connection;
    private PreparedStatement pr = null;
    private ResultSet resultSet = null;
    private Professors professor = new Professors();
    @Override
    public Professors getProfessorById(int id) throws SQLException {
        try{
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Select * from Professors where Professor_ID=?");
            pr.setInt(1, id);
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                professor.setProfessorId(resultSet.getInt("Professor_ID"));
                professor.setFirstName(resultSet.getString("First_Name"));
                professor.setLastName(resultSet.getString("Last_Name"));

            }
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            try {
                if (connection != null) connectionPool.putback(connection);
                if (resultSet != null) resultSet.close();
                if (pr != null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
        return professor;
    }

    @Override
    public void saveProfessor(Professors professor) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Insert into Professors (Professor_ID, First_Name, Last_Name) Values (?,?,?)");
            pr.setInt(1, professor.getProfessorId());
            pr.setString(2, professor.getFirstName());
            pr.setString(3, professor.getLastName());
            pr.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            try {
                if (connection != null) connectionPool.putback(connection);
                if (pr != null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
    }

    @Override
    public void updateProfessor(Professors professor) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Update Professors Set`First_Name`=?, 'Last_Name'=? where Professor_ID=?");
            pr.setString(1, professor.getFirstName());
            pr.setString(2, professor.getLastName());
            pr.setInt(3, professor.getProfessorId());
            pr.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            try {
                if (connection != null) connectionPool.putback(connection);
                if (pr != null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
    }

    @Override
    public void removeProfessor(Professors professor) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Delete from Professors where Professor_ID=?");
            pr.setInt(1, professor.getProfessorId());
            pr.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            try {
                if (connection != null) connectionPool.putback(connection);
                if (pr != null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        BasicConfigurator.configure();
        Professors professor = new ProfessorsDAO().getProfessorById(1);
        LOGGER.info(professor.toString());
    }
}
