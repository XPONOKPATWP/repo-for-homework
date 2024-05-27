package gr.aueb.cf.ch9;

import java.util.Scanner;

public class hw4App {

    private static final int SIZE = 3;
    private static final int EMPTY = 0;
    private static final int PLAYER_X = 1;
    private static final int PLAYER_O = 2;
    private static int[][] board = new int[SIZE][SIZE];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currentPlayer = PLAYER_X;
        boolean gameWon = false;

        while (true) {
            printBoard();
            System.out.println("Player " + (currentPlayer == PLAYER_X ? "X" : "O") + "'s turn:");
            System.out.print("Enter row (1-3) and column (1-3): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (row < 0 || row >= SIZE || col < 0 || col >= SIZE || board[row][col] != EMPTY) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            board[row][col] = currentPlayer;
            if (checkWin(currentPlayer)) {
                printBoard();
                System.out.println("Player " + (currentPlayer == PLAYER_X ? "X" : "O") + " wins!");
                gameWon = true;
                break;
            }

            if (isBoardFull()) {
                printBoard();
                System.out.println("The game is a draw!");
                break;
            }

            currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
        }

        if (!gameWon) {
            System.out.println("Game Over!");
        }

        scanner.close();
    }

    /**
     * Εκτυπώνει το ταμπλό του παιχνιδιού.
     */
    private static void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                char symbol = '.';
                if (board[i][j] == PLAYER_X) {
                    symbol = 'X';
                } else if (board[i][j] == PLAYER_O) {
                    symbol = 'O';
                }
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Ελέγχει αν ο παίκτης έχει κερδίσει.
     * @param player ο παίκτης που έκανε την τελευταία κίνηση
     * @return true αν ο παίκτης κέρδισε, αλλιώς false
     */
    private static boolean checkWin(int player) {
        // Έλεγχος γραμμών και στηλών
        for (int i = 0; i < SIZE; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        // Έλεγχος διαγωνίων
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }
        return false;
    }

    /**
     * Ελέγχει αν το ταμπλό είναι γεμάτο.
     * @return true αν το ταμπλό είναι γεμάτο, αλλιώς false
     */
    private static boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
