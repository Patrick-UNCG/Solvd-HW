package org.example.dao.jdbc;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.example.ConnectionPool;
import org.example.models.Countries;

import java.sql.*;

public class CountriesDAO implements ICountriesDAO {
    private static Logger LOGGER = Logger.getLogger(ICountriesDAO.class);

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private Connection connection;
    private PreparedStatement pr = null;
    private ResultSet resultSet = null;

    private Countries country = new Countries();

    public void saveCountry(Countries country) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Insert into Countries (Country_ID, Country_Name, Regions_Region_ID) Values (?,?, ?)");
            pr.setInt(1, country.getCountryId());
            pr.setString(2, country.getCountryName());
            pr.setInt(3, country.getRegionId());
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
    public Countries getCountryById(int id){
        try{
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("SELECT * FROM Countries WHERE Country_ID =?");
            pr.setInt(1, id);
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                country.setCountryId(resultSet.getInt("Country_ID"));
                country.setCountryName(resultSet.getString("Country_Name"));
                country.setRegionId(resultSet.getInt("Regions_Region_ID"));
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
        return country;
    }

    @Override
    public void updateCountry(Countries country) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Update Courses Set`Country_Name`=? where Country_ID=?");
            pr.setString(1, country.getCountryName());
            pr.setInt(2, country.getCountryId());
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
    public void removeCountry(Countries country) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Delete from Countries where Country_ID=?");
            pr.setInt(1, country.getCountryId());
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
        Countries country = new CountriesDAO().getCountryById(1);
        LOGGER.info(country.toString());
    }
}
