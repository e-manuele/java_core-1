package com.example.exercises;

import java.util.*;
import java.util.function.Function;

import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.domain.Country;

import static java.util.Comparator.comparingInt;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise6 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Sort the countries by number of their cities in descending order
		List<CountryNumOfCities> countryList =
				countryDao.findAllCountries()
						.stream()
						.map( x-> new CountryNumOfCities(x, x.getCities().size()))
						.sorted(comparingInt(CountryNumOfCities::citiesNum).reversed())
						.toList();
		countryList.forEach(System.out::println);

	}

}
