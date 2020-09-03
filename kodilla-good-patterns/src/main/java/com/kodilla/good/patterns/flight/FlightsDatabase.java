package com.kodilla.good.patterns.flight;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FlightsDatabase {

    public List<Flight> getFlights() {

        List<Flight> flightsList = new ArrayList<>();
        flightsList.add(new Flight("Kraków", "Gdańsk",  LocalTime.of(2, 13)));
        flightsList.add(new Flight("Kraków", "Wrocław",  LocalTime.of(5, 24)));
        flightsList.add(new Flight("Kraków", "Wrocław",  LocalTime.of(10, 4)));
        flightsList.add(new Flight("Kraków", "Gdańsk",  LocalTime.of(12, 23)));
        flightsList.add(new Flight("Gdańsk", "Wrocław",  LocalTime.of(13, 53)));
        flightsList.add(new Flight("Gdańsk", "Kraków",  LocalTime.of(14, 24)));
        flightsList.add(new Flight("Gdańsk", "Wrocław",  LocalTime.of(15, 4)));
        flightsList.add(new Flight("Gdańsk", "Kraków",  LocalTime.of(16, 21)));
        flightsList.add(new Flight("Wrocław", "Gdańsk", LocalTime.of(17, 32)));
        flightsList.add(new Flight("Wrocław", "Kraków",  LocalTime.of(18, 14)));
        flightsList.add(new Flight("Wrocław", "Gdańsk",  LocalTime.of(19, 42)));
        flightsList.add(new Flight("Wrocław", "Kraków", LocalTime.of(20, 51)));
        flightsList.add(new Flight("Gdańsk", "Frankfurt", LocalTime.of(23, 51)));

        return flightsList;
    }

}
