package com.example.exercises;

import java.util.*;
import java.util.stream.Collectors;

import com.example.dao.CityDao;
import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.domain.City;
import com.example.domain.Country;

import static java.lang.Integer.valueOf;
import static java.util.Collections.max;
import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class Exercise4 {
    private static final CountryDao countryDao = InMemoryWorldDao.getInstance();
    private static final CityDao cityDao = InMemoryWorldDao.getInstance();

    public static void main(String[] args) {
        // Find the highest populated capital city
        List<City> listcity = cityDao.findAllCities();

        Optional<City> mostPopulatedCapitals = getCity(countryDao.findAllCountries());
        System.out.println(mostPopulatedCapitals);
    }

    private static Optional<City> getCity(List<Country> listOfCountry) {
        Optional<City> mostPopulatedCapitals =
                listOfCountry
                        .stream()
                        .map(x -> cityDao.findCityById(x.getCapital()))
                        .filter(i -> i != null)
                        .max(comparingInt(City::getPopulation));
        return mostPopulatedCapitals;
    }


}
