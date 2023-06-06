package org.example.dao;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.example.ConnectionPool;
import org.example.interfaces.IStudentDAO;
import org.example.models.Student;

import java.sql.*;


public class StudentDAO implements IStudentDAO {
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private Connection connection;
    private PreparedStatement pr = null;
    private ResultSet resultSet = null;
    private static Logger LOGGER = Logger.getLogger(IStudentDAO.class);
    private Student student = new Student();

    public void saveStudent(Student student) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Insert into Students (Student_ID, First_Name, Last_Name, Universities_University_ID) Values (?,?,?,?)");
            pr.setInt(1, student.getStudentId());
            pr.setString(2, student.getFirstName());
            pr.setString(3, student.getLastName());
            pr.setInt(4, student.getUniversityId());
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
    public Student getStudentById(int id) {
        try{
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Select * from Students where Student_ID=?");
            pr.setInt(1, id);
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                student.setStudentId(resultSet.getInt("Student_ID"));
                student.setFirstName(resultSet.getString("First_Name"));
                student.setLastName(resultSet.getString("Last_Name"));
                student.setUniversityId(resultSet.getInt("Universities_University_ID"));

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
        return student;
    }

    @Override
    public void updateStudent(Student student) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Update Students Set`First_Name`=?, 'Last_Name' =?, 'Universities_University_ID' =? where Student_ID=?");
            pr.setString(1, student.getFirstName());
            pr.setString(2, student.getLastName());
            pr.setInt(3, student.getUniversityId());
            pr.setInt(4, student.getStudentId());
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
    public void removeStudent(Student student) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Delete from Students where Student_ID=?");
            pr.setInt(1, student.getStudentId());
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

    public static void main(String[] args) {
        BasicConfigurator.configure();

        Student student = new StudentDAO().getStudentById(1);
        LOGGER.info(student.toString());
    }
}
