package com.kodilla.good.patterns.flight;

import java.util.List;

public class Aplication {

    public static void main(String[] args) {

        FlightsDatabase flightsDatabase = new FlightsDatabase();
        List<Flight> flightsList = flightsDatabase.createFlightsDatabase();

        List<Flight> resultsList;

        resultsList = FlightsSearch.findFlightsFrom("Wroclaw", flightsList);
        for (Flight flight : resultsList
        ) {
            System.out.println(flight);
        }

        resultsList = FlightsSearch.findFlightsFrom("Kraków", flightsList);
        for (Flight flight : resultsList
        ) {
            System.out.println(flight);
        }

        resultsList = FlightsSearch.findFlightsFrom("Gdańsk", flightsList);
        for (Flight flight : resultsList
        ) {
            System.out.println(flight);
        }

        resultsList = FlightsSearch.findFlightsTo("Wroclaw", flightsList);
        for (Flight flight : resultsList
        ) {
            System.out.println(flight);
        }

        resultsList = FlightsSearch.findFlightsTo("Kraków", flightsList);
        for (Flight flight : resultsList
        ) {
            System.out.println(flight);
        }

        resultsList = FlightsSearch.findFlightsTo("Gdańsk", flightsList);
        for (Flight flight : resultsList
        ) {
            System.out.println(flight);
        }

        resultsList = FlightsSearch.findFlightsTransfer("Wroclaw", flightsList);
        for (Flight flight : resultsList
        ) {
            System.out.println(flight);
        }

        resultsList = FlightsSearch.findFlightsTransfer("Kraków", flightsList);
        for (Flight flight : resultsList
        ) {
            System.out.println(flight);
        }

        resultsList = FlightsSearch.findFlightsTransfer("Gdańsk", flightsList);
        for (Flight flight : resultsList
        ) {
            System.out.println(flight);
        }

    }

}
