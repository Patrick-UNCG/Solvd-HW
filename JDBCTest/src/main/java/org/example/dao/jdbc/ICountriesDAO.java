package org.example.dao.jdbc;

import org.example.models.Countries;

import java.sql.SQLException;

public interface ICountriesDAO {
    Countries getCountryById(int id);

    void saveCountry(Countries country);

    void updateCountry(Countries country);

    void removeCountry(Countries country);
}
