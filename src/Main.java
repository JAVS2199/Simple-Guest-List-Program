import java.util.Scanner;

public class Main {

    static String[] guests = new String[10];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        do {
            displayGuests();
            displayMenu();
            int option = scanner.nextInt();

            if (option == 4) {
                break;
            } else if (option == 2) {
                for (int i = 0; i < guests.length; i++) {
                    if (guests[i] == null) {
                        System.out.println("Name: ");
                        String name = scanner.next();
                        guests[i] = name;
                        break;
                    }
                }
            } else if (option == 3) {
                System.out.println("Insert the name you would like to remove: ");
                String name = scanner.next();
                for (int i = 0; i < guests.length; i++) {
                    /*The and condition is added to avoid issues with null */
                    if (guests[i] != null && name.equals(guests[i])) {
                        guests[i] = null;
                    }
                }
            }
        } while (true);
    }

    static void displayGuests() {
        System.out.println("-------------------------------------------------------");
        System.out.println("-   Guests    -");
        for (int i = 0; i < guests.length; i++) {
            System.out.println(guests[i] == null ? "--" : guests[i]);
        }
    }

    static void displayMenu() {
        System.out.println("-------------------------------------------------------");
        System.out.println("-   Menu    -");
        System.out.println("2. Add Guest");
        System.out.println("3. Remove Guest");
        System.out.println("4. Exit");
        System.out.println("Option:");
    }
}