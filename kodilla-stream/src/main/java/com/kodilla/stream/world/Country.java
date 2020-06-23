package com.kodilla.stream.world;

import java.math.BigDecimal;

public class Country {

    private final BigDecimal peopleQuantity;
    private final String countryName;

    public Country(BigDecimal peopleQuantity, String countryName) {
        this.peopleQuantity = peopleQuantity;
        this.countryName = countryName;

    }

    public BigDecimal getPeopleQuantity() {
        return peopleQuantity;
    }

    public String getCountryName() {
        return countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;

        Country country = (Country) o;

        if (!getPeopleQuantity().equals(country.getPeopleQuantity())) return false;
        return getCountryName().equals(country.getCountryName());
    }

    @Override
    public int hashCode() {
        int result = getPeopleQuantity().hashCode();
        result = 31 * result + getCountryName().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Country{" +
                "peopleQuantity=" + peopleQuantity +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
