package com.kodilla.good.patterns.flight;

import java.time.LocalTime;

public class Flight {

    private String arrivalAirport;
    private String departureAirport;
    private String transferAirport;
    private LocalTime time;

    public Flight(String arrivalAirport, String departureAirport, String transferAirport, LocalTime time) {
        this.arrivalAirport = arrivalAirport;
        this.departureAirport = departureAirport;
        this.transferAirport = transferAirport;
        this.time = time;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getTransferAirport() {
        return transferAirport;
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;

        Flight flight = (Flight) o;

        if (!arrivalAirport.equals(flight.arrivalAirport)) return false;
        if (!departureAirport.equals(flight.departureAirport)) return false;
        if (!transferAirport.equals(flight.transferAirport)) return false;
        return time.equals(flight.time);
    }

    @Override
    public int hashCode() {
        int result = arrivalAirport.hashCode();
        result = 31 * result + departureAirport.hashCode();
        result = 31 * result + transferAirport.hashCode();
        result = 31 * result + time.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "ArrivalAirport='" + arrivalAirport + '\'' +
                ", DepartureAirport='" + departureAirport + '\'' +
                ", TransferAirport='" + transferAirport + '\'' +
                ", time=" + time +
                '}';
    }
}
