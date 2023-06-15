package org.example.dao.jdbc;

import org.apache.log4j.Logger;
import org.example.ConnectionPool;
import org.example.models.Regions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegionsDAO implements IRegionsDAO {
    private static Logger LOGGER = Logger.getLogger(CoursesDAO.class);
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private Connection connection;
    private PreparedStatement pr = null;
    private ResultSet resultSet = null;
    private Regions region = new Regions();
    @Override
    public Regions getRegionById(int id) {
        try{
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Select * from Regions where Region_ID=?");
            pr.setInt(1, id);
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                region.setRegionId(resultSet.getInt("Region_ID"));
                region.setRegionName(resultSet.getString("Region_Name"));
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
        return region;
    }

    @Override
    public void saveRegion(Regions region) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Insert into Regions (Region_ID, Region_Name) Values (?,?)");
            pr.setInt(1, region.getRegionId());
            pr.setString(2, region.getRegionName());
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
    public void updateRegion(Regions region) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Update Regions Set`Region_Name`=? where Region_ID=?");
            pr.setString(1, region.getRegionName());
            pr.setInt(2, region.getRegionId());
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
    public void removeRegion(Regions region) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Delete from Regions where Region_ID=?");
            pr.setInt(1, region.getRegionId());
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
