package com.kodilla.good.patterns.flight;

import java.util.List;
import java.util.stream.Collectors;

public class FlightsSearch {

    private FlightsDatabase flightsDatabase = new FlightsDatabase();

    public List<Flight> findFlightsFrom(String flightFrom) {
         return flightsDatabase.getFlights().stream()
                 .filter(n -> n.getDepartureAirport().equals(flightFrom))
                 .collect(Collectors.toList());
    }

    public List<Flight> findFlightsTo(String flightFrom) {
        return flightsDatabase.getFlights().stream()
                .filter(n -> n.getArrivalAirport().equals(flightFrom))
                .collect(Collectors.toList());
    }

    public List<Flight> findFlightsTransfer(String flightFrom, String flightTo) {
        List<String> possiblyTransferAirports =  flightsDatabase.getFlights().stream()
                .filter(n -> n.getDepartureAirport().equals(flightFrom))
                .map(Flight::getArrivalAirport)
                .distinct()
                .collect(Collectors.toList());

        return possiblyTransferAirports.stream()
                .flatMap(pta -> this.findFlightsFrom(pta).stream())
                .filter(f -> f.getArrivalAirport().equals(flightTo))
                .collect(Collectors.toList());
    }


}
