import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[] guests = new String[10];
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("1. Display All Guests");
            System.out.println("2. Add Guest");
            System.out.println("3. Remove Guest");
            System.out.println("4. Exit");
            System.out.println("Option:");
            int option = scanner.nextInt();
            if (option == 1) {
                for (int i = 0; i < guests.length; i++) {
                    System.out.println(guests[i]);
                }
            } else if (option == 4){
                break;
            } else if (option == 2){
                for (int i = 0; i < guests.length; i++) {
                    if(guests[i] == null){
                        System.out.println("Name: ");
                        String name = scanner.next();
                        guests[i] = name;
                        break;
                    }
                }


            } else if (option == 3){
                System.out.println("Insert the name you would like to remove: ");
                String name = scanner.next();
                for (int i = 0; i < guests.length; i++) {
                    /*The and condition is added to avoid issues with null */
                    if(guests[i] != null && name.equals(guests[i])){
                        guests[i] = null;
                    }
                }
            }
        } while(true);
    }
}