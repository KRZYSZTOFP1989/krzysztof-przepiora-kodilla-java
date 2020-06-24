package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity(){
        //Given
        World world = new World();

        Continent europe = new Continent();
        Continent asia = new Continent();
        Continent africa = new Continent();

        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(africa);

        Country poland = new Country(new BigDecimal("15"), "Poland");
        Country germany = new Country(new BigDecimal("10"), "Germany");
        Country france = new Country(new BigDecimal("1"), "France");
        Country ukraine = new Country(new BigDecimal("1"), "Ukraine");
        Country china = new Country(new BigDecimal("1"), "China");
        Country india = new Country(new BigDecimal("1"), "India");
        Country vietnam = new Country(new BigDecimal("1"), "Vietnam");
        Country thailand = new Country(new BigDecimal("30"), "Thailand");
        Country japan = new Country(new BigDecimal("100"), "Japan");
        Country egypt = new Country(new BigDecimal("40"), "Egypt");
        Country morocco = new Country(new BigDecimal("1"), "Morocco");
        Country sudan = new Country(new BigDecimal("4"), "Sudan");
        Country senegal = new Country(new BigDecimal("10"),"Senegal");
        Country suidafrika = new Country(new BigDecimal("15"), "Suid-Afrika");

        europe.addCountry(poland);
        europe.addCountry(germany);
        europe.addCountry(france);
        europe.addCountry(ukraine);
        asia.addCountry(china);
        asia.addCountry(india);
        asia.addCountry(vietnam);
        asia.addCountry(thailand);
        asia.addCountry(japan);
        africa.addCountry(egypt);
        africa.addCountry(morocco);
        africa.addCountry(sudan);
        africa.addCountry(senegal);
        africa.addCountry(suidafrika);

        //When
        BigDecimal peopleOfTheWorld = world.getPeopleQuantity();


        //Then
        Assert.assertEquals(new BigDecimal("230"), peopleOfTheWorld);
    }
}
