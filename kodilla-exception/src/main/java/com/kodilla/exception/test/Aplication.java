package com.kodilla.exception.test;

public class Aplication {

    public static void main(String[] args) {

        FlightSearch flightsearch = new FlightSearch();

        Flight copenhagenValencia = new Flight("Copenhagen", "Valencia");
        Flight manchesterLublin = new Flight("Manchester", "Lublin");
        Flight manchesterMallorca = new Flight("Manchester", "Mallorca");

        try {
            if (flightsearch.findFlight(copenhagenValencia)) {
                System.out.println("Buy a ticket!");
            } else {
                System.out.println("Airport is closed.");
            }
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            if (flightsearch.findFlight(manchesterLublin)) {
                System.out.println("Buy a ticket!");
            } else {
                System.out.println("Airport is closed.");
            }
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            if (flightsearch.findFlight(manchesterMallorca)) {
                System.out.println("Buy a ticket!");
            } else {
                System.out.println("Airport is closed.");
            }
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
