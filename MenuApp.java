package gr.aueb.cf.ch9;

import java.util.Scanner;

public class MenuApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean valid = false;

        while (!valid) {
            showMenu();
            choice = getChoice(scanner);
            try {
                printChoice(choice);
                valid = true; // If no exception, exit the loop
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }

        scanner.close();
    }

    public static void showMenu() {
        System.out.println("Menu:");
        System.out.println("1. New Game");
        System.out.println("2. Continue Game");
        System.out.println("3. Load Save File");
        System.out.println("4. Settings");
        System.out.println("5. Exit");
        System.out.print("Please enter your choice: ");
    }

    public static int getChoice(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); // Consume the invalid input
            System.out.print("Please enter your choice: ");
        }
        return scanner.nextInt();
    }

    public static void printChoice(int choice) {
        if (choice < 1 || choice > 5) {
            throw new IllegalArgumentException("Choice must be between 1 and 5.");
        }
        System.out.println("You selected option " + choice);
    }
}
