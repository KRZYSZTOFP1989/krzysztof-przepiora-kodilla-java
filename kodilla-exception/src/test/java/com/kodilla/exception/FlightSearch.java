package com.kodilla.exception;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {

    public Map<String, Boolean> findFlight(Flight flight) throws RouteNotFoundException {

        Map<String, Boolean> airportsList = new HashMap<>();
        airportsList.put("Copenhagen", true);
        airportsList.put("Valencia", false);
        airportsList.put("Mallorca", true);
        airportsList.put("Bremen", true);
        airportsList.put("Sydney", false);
        airportsList.put("Buenos Aires", false);
        airportsList.put("Manchester", true);
        airportsList.put("Tokyo", true);
        airportsList.put("Berlin", true);
        airportsList.put("Montevideo", false);

        if (airportsList.containsValue(true))  {

            return airportsList;

        } else {

            throw new RouteNotFoundException("There is no such connection!");
        }

    }

}
