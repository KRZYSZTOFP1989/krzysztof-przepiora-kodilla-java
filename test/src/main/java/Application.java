import java.io.IOException;

public class Application {

    public static void main(String[] args) {

        FlightSearch flightSearch = new FlightSearch();

        Flight valenciavalladolid = new Flight("Valencia", "Valladolid");
        Flight lacorunaroma = new Flight("La Coruna", "Roma");
        Flight saragossaparma = new Flight("Saragossa", "Parma");
        Flight romavalladolid = new Flight("Roma", "Valladolid");
        Flight valenciaparma = new Flight("Valencia", "Parma");

        try {

            flightSearch.findFilght(valenciavalladolid);
            System.out.println("Znaleziono połączenie: " + valenciavalladolid);

        } catch (Exception RouteNotFoundException) {

            System.out.println("Nie ma takiego połączenia");

        } finally {

            System.out.println("Czy chcesz szukać dalej?");
        }

        try {

            flightSearch.findFilght(lacorunaroma);
            System.out.println("Znaleziono połączenie: " + lacorunaroma);

        } catch (Exception RouteNotFoundException) {

            System.out.println("Nie ma takiego połączenia");

        } finally {

            System.out.println("Czy chcesz szukać dalej?");
        }

        try {

            flightSearch.findFilght(saragossaparma);
            System.out.println("Znaleziono połączenie: " + saragossaparma);

        } catch (Exception RouteNotFoundException) {

            System.out.println("Nie ma takiego połączenia");

        } finally {

            System.out.println("Czy chcesz szukać dalej?");
        }

        try {

            flightSearch.findFilght(romavalladolid);
            System.out.println("Znaleziono połączenie: " + romavalladolid);

        } catch (Exception RouteNotFoundException) {

            System.out.println("Nie ma takiego połączenia");

        } finally {

            System.out.println("Czy chcesz szukać dalej?");
        }

        try {

            flightSearch.findFilght(valenciaparma);
            System.out.println("Znaleziono połączenie: " + valenciaparma);

        } catch (Exception RouteNotFoundException) {

            System.out.println("Nie ma takiego połączenia");

        } finally {

            System.out.println("Czy chcesz szukać dalej?");
        }

    }

}
