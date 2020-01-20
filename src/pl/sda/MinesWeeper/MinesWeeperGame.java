package pl.sda.MinesWeeper;

import java.util.Scanner;

class MinesWeeperGame {

    private int size;
    private String[][] array;
    private String[][] playerArray;


    private void getSize() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type a size: ");
        size = scanner.nextInt();
    }

    private void createArray() {
        getSize();
        array = new String[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = "0";
            }
        }
        makeBombs();
        System.out.println("Completed Array");
        fillArrayWithNumbers();
        printCompletedArray();
        initPlayerArray();
    }

    private void printCompletedArray() {
        System.out.print("  ");
        for (int i = 1; i <= size; i++) {
            System.out.print(i + " ");
        }
        System.out.print("\n  ");
        for (int i = 0; i < size; i++) {
            System.out.print("- ");
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            String[] strings = array[i];
            System.out.print((i + 1) + "|");
            for (int j = 0; j < array.length; j++) {
                System.out.print(strings[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void initPlayerArray() {
        playerArray = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                playerArray[i][j] = "#";
            }
        }
    }

    private void printPlayerArray() {
        System.out.println("Player's Array");
        System.out.print("  ");
        for (int i = 1; i <= size; i++) {
            System.out.print(i + " ");
        }
        System.out.print("\n  ");
        for (int i = 0; i < size; i++) {
            System.out.print("- ");
        }
        System.out.println();
        for (int i = 0; i < playerArray.length; i++) {
            String[] strings = playerArray[i];
            System.out.print((i + 1) + "|");
            for (int j = 0; j < playerArray.length; j++) {
                System.out.print(strings[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean ifStatementForMakeBombs() {
        return Math.random() > 0.95;
    }

    private void makeBombs() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type number of Bombs");
        int numberOfBombs = scanner.nextInt();
        int counter = 0;
        while (counter < numberOfBombs) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    if (ifStatementForMakeBombs() && counter < numberOfBombs && array[i][j].equals("0")) {
                        array[i][j] = "B";
                        counter++;
                    }
                }
            }
        }
    }

    private void fillArrayWithNumbers() {
        int min = 0;
        int max = array.length;
        for (int i = min; i < max; i++) {
            for (int j = min; j < max; j++) {
                if (array[i][j].equals("B")) {
                    for (int k = i - 1; k <= i + 1; k++) {
                        for (int l = j - 1; l <= j + 1; l++) {
                            if (l >= 0 && k >= 0 && l < max && k < max && array[k][l] != null && !array[k][l].equals("B")) {
                                int x = Integer.parseInt(array[k][l]) + 1;
                                array[k][l] = Integer.toString(x);
                            }
                        }
                    }
                }
            }
        }
    }

    private int userChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 1 to set number");
        System.out.println("Press 2 to set bomb");
        return scanner.nextInt();
    }

    private int userTypeRow() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type row");
        int x = scanner.nextInt();
        while (x < 1 || x > size) {
            System.out.println("Type row");
            x = scanner.nextInt();
        }
        return x;
    }

    private int userTypeColumn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type column");
        int y = scanner.nextInt();
        while (y < 1 || y > size) {
            System.out.println("Type column");
            y = scanner.nextInt();
        }
        return y;
    }

    private void setBomb(int x, int y) {
        playerArray[x][y] = "B";
    }

    private boolean endGamePlayerLoseStatement(int x, int y) {
        return (array[x - 1][y - 1].equals("B"));
    }

    private void userMove() {
        int choice = userChoice();
        while (choice < 1 || choice > 2) {
            choice = userChoice();
        }
        int x = userTypeRow();
        int y = userTypeColumn();
        if (choice == 1) {
            if (array[x - 1][y - 1].equals("0")) {
                printZerosAround(x, y);
            } else {
                playerArray[x - 1][y - 1] = array[x - 1][y - 1];
            }
            if (endGamePlayerLoseStatement(x, y)) {
                System.out.println("You lost");
            } else printPlayerArray();
        }
        if (choice == 2) setBomb(x, y);
    }

    private boolean endOfTheGame() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!playerArray[i][j].equals(array[i][j])) return false;
            }
        }
        System.out.println("You won");
        return true;
    }

    private void printZerosAround(int x, int y) {
        x = x - 1;
        y = y - 1;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (j >= 0 && i >= 0 && j < size && i < size && array[i][j] != null)
                    playerArray[i][j] = array[i][j];
            }
        }
    }

    void playAGame() {
        createArray();
        printPlayerArray();
        while (!endOfTheGame()) {
            userMove();
        }
    }
}

    /*//recursion to do
    private void printRecZerosInner(int x, int y) {
        int i = 0;
        int j = 0;
        while ((array[x][y + 1].equals("0") || array[x + 1][y].equals("0") || array[x - 1][y].equals("0") || array[x][y - 1].equals("0")) && (x > 0 && y > 0 && x < size && y < size && array[i][j] != null)) {
            for (i = x - 1; i <= x + 1; i++) {
                for (j = y - 1; j <= y + 1; j++) {
                    if (j >= 0 && i >= 0 && j < size && i < size && array[i][j] != null)
                        playerArray[i][j] = array[i][j];
                }
            }
            printPlayerArray();
            x = i;
            y = j;
        }
    }*/