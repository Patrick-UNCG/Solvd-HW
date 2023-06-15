package org.example.dao.jdbc;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.example.ConnectionPool;
import org.example.models.Courses;
import java.sql.*;


public class CoursesDAO implements ICoursesDAO {
    private static Logger LOGGER = Logger.getLogger(CoursesDAO.class);
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private Connection connection;
    private PreparedStatement pr = null;
    private ResultSet resultSet = null;
    private Courses course = new Courses();


    public void saveCourse(Courses course) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Insert into Courses (Courses_ID, Course_Name) Values (?,?)");
            pr.setInt(1, course.getCourseId());
            pr.setString(2, course.getCourseName());
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
    public Courses getCourseById(int id) {
        try{
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Select * from Courses where Courses_ID=?");
            pr.setInt(1, id);
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                course.setCourseId(resultSet.getInt("Courses_ID"));
                course.setCourseName(resultSet.getString("Course_Name"));
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
        return course;
    }

    @Override
    public void updateCourse(Courses course) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Update Courses Set`Course_Name`=? where Course_ID=?");
            pr.setString(1, course.getCourseName());
            pr.setInt(2, course.getCourseId());
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
    public void removeCourse(Courses course) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Delete from Courses where Course_ID=?");
            pr.setInt(1, course.getCourseId());
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
        Courses courses = new CoursesDAO().getCourseById(1);
        LOGGER.info(courses.toString());
    }

}
