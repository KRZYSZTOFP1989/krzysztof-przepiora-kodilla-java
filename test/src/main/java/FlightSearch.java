import java.util.HashMap;
import java.util.Map;

public class FlightSearch {

    public Boolean findFilght (Flight flight) throws RouteNotFoundException {

        Map<String, Boolean> flightMap = new HashMap<>();

        flightMap.put("Valencia", true);
        flightMap.put("Valladolid", null);
        flightMap.put("Parma", true);
        flightMap.put("La Coruna", false);
        flightMap.put("Saragossa", true);
        flightMap.put("Roma", false);

        Boolean isFlightAvailable = flightMap.get(flight.getArrivalAirport());

        if (isFlightAvailable == null) {
            String message = "Nie może być nulla";
            throw new RouteNotFoundException(message);
        }

        return isFlightAvailable;
    }

}
