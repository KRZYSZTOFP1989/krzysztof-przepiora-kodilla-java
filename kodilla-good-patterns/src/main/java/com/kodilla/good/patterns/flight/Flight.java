package com.kodilla.good.patterns.flight;

import java.time.LocalTime;

public class Flight {

    private String ArrivalAirport;
    private String DepartureAirport;
    private String TransferAirport;
    private LocalTime time;

    public Flight(String arrivalAirport, String departureAirport, String transferAirport, LocalTime time) {
        ArrivalAirport = arrivalAirport;
        DepartureAirport = departureAirport;
        TransferAirport = transferAirport;
        this.time = time;
    }

    public String getArrivalAirport() {
        return ArrivalAirport;
    }

    public String getDepartureAirport() {
        return DepartureAirport;
    }

    public String getTransferAirport() {
        return TransferAirport;
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;

        Flight flight = (Flight) o;

        if (!ArrivalAirport.equals(flight.ArrivalAirport)) return false;
        if (!DepartureAirport.equals(flight.DepartureAirport)) return false;
        if (!TransferAirport.equals(flight.TransferAirport)) return false;
        return time.equals(flight.time);
    }

    @Override
    public int hashCode() {
        int result = ArrivalAirport.hashCode();
        result = 31 * result + DepartureAirport.hashCode();
        result = 31 * result + TransferAirport.hashCode();
        result = 31 * result + time.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "ArrivalAirport='" + ArrivalAirport + '\'' +
                ", DepartureAirport='" + DepartureAirport + '\'' +
                ", TransferAirport='" + TransferAirport + '\'' +
                ", time=" + time +
                '}';
    }
}
