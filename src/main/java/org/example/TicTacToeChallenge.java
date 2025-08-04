package org.example;

import  java.util.Scanner;

// IN PORTUGUESE THIS GAME IS CALLED 'JOGO DA VELHA'
public class TicTacToeChallenge {

    public static void main(String[] args) {
        Game ticTacToe = new Game();
        ticTacToe.play();
    }

    public static class Game {
        char[][] board = new char[3][3];
        char player1 = 'X';
        char player2 = 'O';

        int playerNumber = 1;
        int round = 0;

        boolean win = false;

        public void play() {
            // Implement the game logic here

            showBoard();

            int lineChosen;
            int columnChosen;

            while (round < 9 || !win) {

                System.out.println("round: " + round);

                do {

                    System.out.println("Player " + playerNumber + "'s turn, choose a line position (0-2): ");
                    lineChosen = new Scanner(System.in).nextInt();

                    System.out.println("Player " + playerNumber + "'s turn, choose a column position (0-2): ");
                    columnChosen = new Scanner(System.in).nextInt();

                } while (!isInvalidMovement(lineChosen, columnChosen));

                markBoard(lineChosen, columnChosen, playerNumber == 1 ? player1 : player2);

                win = verifyWinConditions(board);

                if (win) {
                    System.out.println("Player " + playerNumber + " wins!");
                    break;
                } else {
                    if (round < 8){
                        round++;
                        showBoard();
                        playerNumber = playerNumber == 1 ? 2 : 1;
                    } else {
                        System.out.println("It's a draw!");
                        showBoard();
                        break;
                    }
                }
            }
        }

        private void markBoard(int line, int column, char playerSymbol) {
            if (board[line][column] == '\0') {
                board[line][column] = playerSymbol;
            }
        }

        private void showBoard() {
            for (int line = 0; line < 3; line++) {
                for (int column = 0; column < 3; column++) {
                    System.out.print(" | " + board[line][column] + " | ");
                }
                System.out.println();
            }
        }

        private boolean verifyWinConditions(char[][] board) {
            // Horizontal Win
            for (int line = 0; line < 3; line++) {
                if (board[line][0] != '\0') {
                    if (board[line][0] == board[line][1] && board[line][1] == board[line][2]) {
                        return true;
                    }
                }
            }

            // Vertical Win
            for (int column = 0; column < 3; column++) {
                if (board[0][column] != '\0') {
                    if (board[0][column] == board[1][column] && board[1][column] == board[2][column]) {
                        return true;
                    }
                }
            }

            // Diagonal Win
            return (board[0][0] != '\0' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
                    (board[0][2] != '\0' && board[0][2] == board[1][1] && board[1][1] == board[2][0]);

        }

        private boolean isInvalidMovement(int line, int column) {

            if (line < 0 || line > 2 || column < 0 || column > 2) {
                System.out.println("Invalid movement, try again");
                return false;
            }

            if (board[line][column] != '\0') {
                System.out.println("Invalid movement, try again");
                return false;
            }

            return true;
        }
    }
}
