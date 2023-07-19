package com.example.exercises;

import java.util.List;
import java.util.stream.*;

import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.domain.City;


import static java.util.Comparator.comparingInt;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class Exercise2 {
    private static final CountryDao countryDao = InMemoryWorldDao.getInstance();

    public static void main(String[] args) {
        // Find the most populated city of each continent
        List<ContinentCityPair> mostPopulatedCityOfContinent =
                countryDao.getAllContinents()
                        .stream()
                        .map(x -> new ContinentCityPair(x,
                                        countryDao.findCountriesByContinent(x)
                                                .stream()
                                                .flatMap(y -> y.getCities().stream())
                                                .max(comparingInt(City::getPopulation))
                                                .orElse(null)
                                )
                        )
                        .toList();
        mostPopulatedCityOfContinent.forEach(System.out::println);
    }
}