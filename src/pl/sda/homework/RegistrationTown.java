package pl.sda.homework;
import java.util.*;

public class RegistrationTown {

    private Map<String, String> registration = new HashMap<>();

    public void add () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj kod miejscowosci");
        String id = scanner.nextLine();
        System.out.println("Podaj miejscowość");
        String cityName = scanner.next();
        registration.put(id.toUpperCase(),cityName);

    }

    public boolean hasCode () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj kod a sprawdzę czy istnieje");
        String isExist = scanner.nextLine();
        return (registration.containsKey(isExist.toUpperCase()));
    }
    public boolean hasTown () {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Podaj nazwę miejscowośći a sprawdzę czy istnieje dla niej kod");
            String cityName = scanner.nextLine();
            if (!registration.get(cityName).isEmpty())
            return (!registration.get(cityName).isEmpty());
        }
        catch (NullPointerException ex) {
            System.out.println("Dla tej miejscowosci nie ma podanego kodu");
    }
       return false;
    }

    public void getTown() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj kod dla ktorego chcesz wyswietlic miasto");
        String cityCode = scanner.nextLine();
        if (registration.containsValue(cityCode))
        System.out.println(registration.get(cityCode));
        else System.out.println("");

    }



    public void printMenuInfo(){
        System.out.println("1. Add new value");
        System.out.println("2. Is this code exist?");
        System.out.println("3. Has this City code already?");
        System.out.println("4. Change code for this city");
        System.out.println("5. Change city name for this code");
        System.out.println("9. Exit");
    }

    public void userMenu() {
        int choice = 0;

            while (choice != 9) {
                Scanner scanner = new Scanner(System.in);
                try {
                    printMenuInfo();
                    choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        add();
                        break;
                    case 2:
                        System.out.println(hasCode());
                        break;
                    case 3:
                        System.out.println(hasTown());
                            break;
                    case 4:getTown();
                    break;
                    case 5:
                    case 9:
                        return;
                    default:
                        System.out.println("Podaj prawidłową wartość");
                }
            }
                catch (InputMismatchException ex) {
                    System.out.println("Podaj liczbę");
        }

        }
    }
}
