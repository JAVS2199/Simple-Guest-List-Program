import java.util.Scanner;

public class Main {

    static String[] guests = new String[10];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        do {
            displayGuests();
            displayMenu();
            int option = getOption();
            if (option == 4) {
                break;
            } else if (option == 2) {
                addGuest();
            } else if (option == 3) {
                removeGuest();
            } else if (option == 5)  {
                renameGuest();
            } else if (option == 6) {
                insertParticularPositon();
            }
        } while (true);
    }

    static void displayGuests() {
        System.out.println("-------------------------------------------------------");
        System.out.println("-   Guests    -");
        for (int i = 0; i < guests.length; i++) {
            if (guests[i] != null) {
                System.out.println((i + 1) + ". " + guests[i]);
            } else {
                System.out.println("Guest list is empty");
                break;
            }
            //System.out.println((i+1) + ". "+(guests[i] == null ? "--" : guests[i]));
        }
    }

    static void displayMenu() {
        System.out.println("-------------------------------------------------------");
        System.out.println("-   Menu    -");
        System.out.println("2. Add Guest");
        System.out.println("3. Remove Guest");
        System.out.println("4. Exit");
        System.out.println("5. Rename Guest");
        System.out.println("5. Insert Name in particular position");

    }

    static int getOption() {
        System.out.println("Option:");
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    static void addGuest(){
        for (int i = 0; i < guests.length; i++) {
            if (guests[i] == null) {
                System.out.println("Name: ");
                String name = scanner.nextLine();
                guests[i] = name;
                break;
            }
        }
        /*The reason why we are doing this is to avoid having gaps among the names*/
        String[] temp = new String[guests.length];
        int ti = 0;
        for (int i = 0; i < guests.length; i++) {
            if (guests[i] != null) {
                temp[ti] = guests[i];
                ti++;
            }
        }
        guests = temp;
    }

    static void removeGuest(){
        System.out.println("Insert the number you would like to remove: ");
        int number = scanner.nextInt();
        if(number<=10 && number>=1 && guests[number-1] != null) {
            guests[number-1] = null;
        } else {
            System.out.println("Error: There is no guest with that number.");
        }
    }

    static void renameGuest(){
        System.out.println("Insert the number of the user you would like to rename: ");
        int number = scanner.nextInt();
        if(number<=10 && number>=1 && guests[number-1] != null) {
            System.out.println("Inserte el nombre del usuario:");
            String name = scanner.nextLine();
            guests[number-1] = name;
        } else {
            System.out.println("Error: There is no guest with that number.");
        }
    }

    static void insertParticularPositon(){
        System.out.println("Insert the number of the user where the new user should go: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        if(number<=10 && number>=1 && guests[number-1] != null) {
            System.out.println("Inserte el nombre del usuario:");
            String name = scanner.nextLine();

            for (int i = guests.length-1 ; i > number-1; i--) {
                /*Index 9 = Index 8
                Everytime we duplicate the value that is located in previous index
                 */
                guests[i] = guests[i-1];
            }
            guests[number-1] = name;
        } else {
            System.out.println("Error: There is no guest with that number.");
        }
    }
}
/*
        int ti = 0;
        for (int i = 0; i < guests.length; i++) {
            if (guests[i] != null) {
                temp[ti] = guests[i];
                ti++;
            }
        }
        guests = temp;*/