package com.kodilla.good.patterns.flight;

import java.util.List;
import java.util.stream.Collectors;

public class FlightsSearch {

    private FlightsDatabase flightsDatabase;

    public static List<Flight> findFlightsFrom(String flightFrom, List<Flight> flightsDatabase) {
         return flightsDatabase.stream()
                 .filter(n -> n.getArrivalAirport().equals(flightFrom))
                 .collect(Collectors.toList());
    }

    public static List<Flight> findFlightsTo(String flightFrom, List<Flight> flightsDatabase) {
        return flightsDatabase.stream()
                .filter(n -> n.getDepartureAirport().equals(flightFrom))
                .collect(Collectors.toList());
    }

    public static List<Flight> findFlightsTransfer(String flightFrom, List<Flight> flightsDatabase) {
        return flightsDatabase.stream()
                .filter(n -> n.getTransferAirport().equals(flightFrom))
                .collect(Collectors.toList());
    }


}
