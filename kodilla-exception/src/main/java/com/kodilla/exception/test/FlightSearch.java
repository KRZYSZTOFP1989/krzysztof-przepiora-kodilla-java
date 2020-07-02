package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {

    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> airportsMap = new HashMap<>();
        airportsMap.put("Copenhagen", true);
        airportsMap.put("Valencia", true);
        airportsMap.put("Mallorca", false);
        airportsMap.put("Bremen", true);
        airportsMap.put("Sydney", false);
        airportsMap.put("Buenos Aires", false);
        airportsMap.put("Manchester", true);
        airportsMap.put("Tokyo", true);
        airportsMap.put("Berlin", true);
        airportsMap.put("Montevideo", false);

        Boolean isFlightAvailable = airportsMap.get(flight.getArrivalAirport());

        if (isFlightAvailable == null) {
            throw new RouteNotFoundException("There is no such connection!");
        }

        return isFlightAvailable;
    }

}
