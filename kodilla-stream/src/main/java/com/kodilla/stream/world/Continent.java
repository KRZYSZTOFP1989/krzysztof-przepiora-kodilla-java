package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Continent {

    private final Set<Country> countryList = new HashSet<>();

    public void addCountry(Country country) {
        countryList.add(country);
    }

    public Set<BigDecimal> getPeopleOfContinent() {
       return countryList.stream()
                .map(country -> country.getPeopleQuantity())
                .collect(Collectors.toSet());

    }

}
