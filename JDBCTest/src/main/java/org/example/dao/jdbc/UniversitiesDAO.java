package org.example.dao.jdbc;

import org.apache.log4j.Logger;
import org.example.ConnectionPool;
import org.example.dao.interfaces.IUniversitiesDAO;
import org.example.models.Universities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UniversitiesDAO implements IUniversitiesDAO {
    private static Logger LOGGER = Logger.getLogger(CoursesDAO.class);
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private Connection connection;
    private PreparedStatement pr = null;
    private ResultSet resultSet = null;
    private Universities university = new Universities();
    @Override
    public Universities getUniversityById(int id) {
        try{
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Select * from Universities where University_ID=?");
            pr.setInt(1, id);
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                university.setUniversityId(resultSet.getInt("University_ID"));
                university.setUniversityName(resultSet.getString("University_Name"));
                university.setAddressId(resultSet.getInt("Addresses_Address_ID"));

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
        return university;
    }

    @Override
    public void saveUniversity(Universities university) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Insert into Universities.xml (University_ID, University_Name, Addresses_Address_ID) Values (?,?,?)");
            pr.setInt(1, university.getUniversityId());
            pr.setString(2, university.getUniversityName());
            pr.setInt(3, university.getAddressId());
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
    public void updateUniversity(Universities university) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Update Universities.xml Set`University_Name`=?, 'Addresses_Address_ID'=? where University_ID=?");
            pr.setString(1, university.getUniversityName());
            pr.setInt(2, university.getAddressId());
            pr.setInt(3, university.getUniversityId());
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
    public void removeUniversity(Universities university) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Delete from Universities.xml where University_ID=?");
            pr.setInt(1, university.getUniversityId());
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
}
