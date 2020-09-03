package com.kodilla.good.patterns.flight;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        FlightsSearch flightsSearch = new FlightsSearch();

        List<Flight> resultsList;

        resultsList = flightsSearch.findFlightsFrom("Wrocław");
        System.out.println(resultsList);

        resultsList = flightsSearch.findFlightsFrom("Kraków");
        System.out.println(resultsList);

        resultsList = flightsSearch.findFlightsFrom("Gdańsk");
        System.out.println(resultsList);


        resultsList = flightsSearch.findFlightsTo("Wrocław");
        System.out.println(resultsList);


        resultsList = flightsSearch.findFlightsTo("Kraków");
        System.out.println(resultsList);


        resultsList = flightsSearch.findFlightsTo("Gdańsk");
        System.out.println(resultsList);


        resultsList = flightsSearch.findFlightsTransfer("Wrocław", "Frankfurt");
        System.out.println(resultsList);

    }

}
