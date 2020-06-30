package com.kodilla.exception;

public class Aplication {

    public static void main(String[] args) {

        FlightSearch flightsearch = new FlightSearch();

        Flight copenhagenValencia = new Flight("Copenhagen", "Valencia");
        Flight manchesterMallorca = new Flight("Manchester", "Mallorca");
        Flight bremenTokyo = new Flight("Bremen", "Tokyo");
        Flight berlinMontevideo = new Flight("Berlin", "Montevideo");
        Flight sydneyBuenos = new Flight("Sydney", "Buenos Aires");


        try {

            flightsearch.findFlight(copenhagenValencia);
            System.out.println("Buy a ticket!");

        } catch (RouteNotFoundException e) {

            System.out.println("There is no such connection!");

        }

        try {

            flightsearch.findFlight(manchesterMallorca);
            System.out.println("Buy a ticket!");

        } catch (RouteNotFoundException e) {

            System.out.println("There is no such connection!");

        }

        try {

            flightsearch.findFlight(bremenTokyo);
            System.out.println("Buy a ticket!");

        } catch (RouteNotFoundException e) {

            System.out.println("There is no such connection!");

        }

        try {

            flightsearch.findFlight(berlinMontevideo);
            System.out.println("Buy a ticket!");

        } catch (RouteNotFoundException e) {

            System.out.println("There is no such connection!");

        }

        try {

            flightsearch.findFlight(sydneyBuenos);
            System.out.println("Buy a ticket!");

        } catch (RouteNotFoundException e) {

            System.out.println("There is no such connection!");

        }

    }

}
