package com.kodilla.good.patterns.flight;

import java.time.LocalTime;

public class Flight {

    private String departureAirport;
    private String arrivalAirport;
    private LocalTime time;

    public Flight(String departureAirport, String arrivalAirport, LocalTime time) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.time = time;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;

        Flight flight = (Flight) o;

        if (!departureAirport.equals(flight.departureAirport)) return false;
        if (!arrivalAirport.equals(flight.arrivalAirport)) return false;
        return time.equals(flight.time);
    }

    @Override
    public int hashCode() {
        int result = departureAirport.hashCode();
        result = 31 * result + arrivalAirport.hashCode();
        result = 31 * result + time.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "ArrivalAirport='" + departureAirport + '\'' +
                ", DepartureAirport='" + arrivalAirport + '\'' +
                ", time=" + time +
                '}';
    }
}
