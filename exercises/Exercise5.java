package com.example.exercises;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.example.dao.CityDao;
import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.domain.City;

import static java.util.Comparator.comparingInt;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class Exercise5 {
    private static final CountryDao countryDao = InMemoryWorldDao.getInstance();
    private static final CityDao cityDao = InMemoryWorldDao.getInstance();

    public static void main(String[] args) {
        // Find the highest populated capital city of each continentù


        List<ContinentCityPair> mostPopulatedCapitalOfContinent =
                countryDao.getAllContinents()
                        .stream()
                        .map(x -> new ContinentCityPair(x,
                                        countryDao.findCountriesByContinent(x)
                                                .stream()
                                                .map(y -> cityDao.findCityById(y.getCapital()))
                                                .filter(i -> i != null)
                                                .max(comparingInt(City::getPopulation))
                                                .orElse(null)
                                )
                        )
                        .toList();
        mostPopulatedCapitalOfContinent.forEach(System.out::println);
    }
}
