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

        Country poland = new Country(new BigDecimal("34343433"), "Poland");
        Country germany = new Country(new BigDecimal("53435"), "Germany");
        Country france = new Country(new BigDecimal("6545343"), "France");
        Country ukraine = new Country(new BigDecimal("4545343"), "Ukraine");
        Country china = new Country(new BigDecimal("56545453"), "China");
        Country india = new Country(new BigDecimal("655455453"), "India");
        Country vietnam = new Country(new BigDecimal("645454"), "Vietnam");
        Country thailand = new Country(new BigDecimal("3434346"), "Thailand");
        Country japan = new Country(new BigDecimal("545455"), "Japan");
        Country egypt = new Country(new BigDecimal("64432"), "Egypt");
        Country morocco = new Country(new BigDecimal("645433"), "Morocco");
        Country sudan = new Country(new BigDecimal("54322"), "Sudan");
        Country senegal = new Country(new BigDecimal("3232"),"Senegal");
        Country suidafrika = new Country(new BigDecimal("434342"), "Suid-Afrika");

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
        Assert.assertEquals(new BigDecimal("763315476"), world.getPeopleQuantity());
    }
}
