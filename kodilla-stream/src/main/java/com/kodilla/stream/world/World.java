package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class World {

    private final Set<Continent> continentList = new HashSet<>();

    public void addContinent(Continent continent) {
        continentList.add(continent);
    }

    public BigDecimal getPeopleQuantity() {
        BigDecimal peopleQuantity = continentList.stream()
                .flatMap(continent -> continent.getPeopleOfContinent().stream())
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));

        return peopleQuantity;
    }

}
