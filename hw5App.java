package gr.aueb.cf.ch9;

import java.util.Scanner;

public class hw5App {

    private static final int ROWS = 30;
    private static final int COLUMNS = 12;
    private static boolean[][] seats = new boolean[ROWS][COLUMNS];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Book a seat");
            System.out.println("2. Cancel a booking");
            System.out.println("3. Display seating");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 4) break;

            char column;
            int row;
            switch (choice) {
                case 1:
                    System.out.print("Enter column (A-L): ");
                    column = scanner.next().charAt(0);
                    System.out.print("Enter row (1-30): ");
                    row = scanner.nextInt();
                    book(column, row);
                    break;
                case 2:
                    System.out.print("Enter column (A-L): ");
                    column = scanner.next().charAt(0);
                    System.out.print("Enter row (1-30): ");
                    row = scanner.nextInt();
                    cancel(column, row);
                    break;
                case 3:
                    displaySeating();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
        scanner.close();
    }

    public static void book(char column, int row) {
        int colIndex = column - 'A';
        int rowIndex = row - 1;

        if (isValidSeat(colIndex, rowIndex)) {
            if (!seats[rowIndex][colIndex]) {
                seats[rowIndex][colIndex] = true;
                System.out.println("Seat " + column + row + " booked successfully.");
            } else {
                System.out.println("Seat " + column + row + " is already booked.");
            }
        } else {
            System.out.println("Invalid seat position.");
        }
    }

    public static void cancel(char column, int row) {
        int colIndex = column - 'A';
        int rowIndex = row - 1;

        if (isValidSeat(colIndex, rowIndex)) {
            if (seats[rowIndex][colIndex]) {
                seats[rowIndex][colIndex] = false;
                System.out.println("Booking for seat " + column + row + " cancelled successfully.");
            } else {
                System.out.println("Seat " + column + row + " is not booked.");
            }
        } else {
            System.out.println("Invalid seat position.");
        }
    }

    private static boolean isValidSeat(int colIndex, int rowIndex) {
        return colIndex >= 0 && colIndex < COLUMNS && rowIndex >= 0 && rowIndex < ROWS;
    }

    public static void displaySeating() {
        System.out.print("  ");
        for (char c = 'A'; c < 'A' + COLUMNS; c++) {
            System.out.print(c + " ");
        }
        System.out.println();
        for (int i = 0; i < ROWS; i++) {
            System.out.printf("%2d ", i + 1);
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print((seats[i][j] ? "X" : "O") + " ");
            }
            System.out.println();
        }
    }
}
