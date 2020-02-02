package pl.sda.MinesWeeper;

import java.util.Scanner;

class MinesWeeperGame {
    private int size;
    private int numberOfBombs;
    private String[][] filledArray;
    private String[][] playerArray;
    private boolean gameLost = false;
    private int currentNumberOfBombs;

    private void getSize() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type a size: ");
        size = scanner.nextInt();
    }

    private void createArray(String[][] arrays) {
        System.out.print("  ");
        for (int i = 0; i < size; i++) {
            System.out.print(i + " ");
        }
        System.out.print("\n  ");
        for (int i = 0; i < size; i++) {
            System.out.print("- ");
        }
        System.out.println();
        for (int i = 0; i < arrays.length; i++) {
            String[] strings = arrays[i];
            System.out.print((i) + "|");
            for (int j = 0; j < arrays.length; j++) {
                System.out.print(strings[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void createCompletedAraay() {
        getSize();
        filledArray = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                filledArray[i][j] = "0";
            }
        }
        makeBombs();
        fillCompletedArrayWithNumbers();
        System.out.println("Filled Array");
        createArray(filledArray);
        initPlayerArray();
    }

    private void initPlayerArray() {
        playerArray = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                playerArray[i][j] = "#";
            }
        }
    }

    private boolean statementForMakeBombs() {
        return Math.random() > 0.98;
    }

    private void makeBombs() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type number of Bombs");
        numberOfBombs = scanner.nextInt();
        int counter = 0;
        while (counter < numberOfBombs) {
            for (int i = 0; i < filledArray.length; i++) {
                for (int j = 0; j < filledArray.length; j++) {
                    if (statementForMakeBombs() && counter < numberOfBombs && filledArray[i][j].equals("0")) {
                        filledArray[i][j] = "B";
                        counter++;
                    }
                }
            }
        }
    }

    private void fillCompletedArrayWithNumbers() {
        int min = 0;
        int max = filledArray.length;
        for (int i = min; i < max; i++) {
            for (int j = min; j < max; j++) {
                if (filledArray[i][j].equals("B")) {
                    for (int k = i - 1; k <= i + 1; k++) {
                        for (int l = j - 1; l <= j + 1; l++) {
                            if (l >= 0 && k >= 0 && l < max && k < max && filledArray[k][l] != null && !filledArray[k][l].equals("B")) {
                                int x = Integer.parseInt(filledArray[k][l]) + 1;
                                filledArray[k][l] = Integer.toString(x);
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

    private void userMove() {
        int choice = userChoice();
        while (choice < 1 || choice > 2) {
            choice = userChoice();
        }
        int x = userTypeRow();
        int y = userTypeColumn();
        if (choice == 1) {
            if (filledArray[x][y].equals("0")) {
                fillArrayWithRecursionIfYouHitZero(x, y);
            } else if (filledArray[x][y].equals("B")) {
                playerArray[x][y] = "X";
                gameLost = true;
            } else {
                playerArray[x][y] = filledArray[x][y];
            }
        }
        if (choice == 2) setBomb(x, y);
    }

    private int userTypeRow() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type row");
        int x = scanner.nextInt();
        while (x < 0 || x >= size) {
            System.out.println("Type row");
            x = scanner.nextInt();
        }
        return x;
    }

    private int userTypeColumn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type column");
        int y = scanner.nextInt();
        while (y < 0 || y >= size) {
            System.out.println("Type column");
            y = scanner.nextInt();
        }
        return y;
    }

    private void setBomb(int x, int y) {
        if (numberOfBombs > currentNumberOfBombs) {
            if (playerArray[x][y].equals("#")) playerArray[x][y] = "B";
            else System.out.println("Pole jest juz zajęte");
            currentNumberOfBombs++;
        } else System.out.println("Nie możesz juz wstawić więcej bomb!!");
    }

    private boolean endOfTheGame() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!playerArray[i][j].equals(filledArray[i][j])) return false;
            }
        }
        System.out.println("You won");
        return true;
    }

    private void printNumbersAround(int x, int y) {
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (j >= 0 && i >= 0 && j < size && i < size && filledArray[i][j] != null)
                    playerArray[i][j] = filledArray[i][j];
            }
        }
    }

    private boolean isHashAround(int x, int y) {
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (j >= 0 && i >= 0 && j < size && i < size && filledArray[i][j] != null) {
                    if (playerArray[i][j].equals("#")) return true;
                }
            }
        }
        return false;
    }

    private boolean canDoRecursion(int indexX, int indexY) {
        return filledArray[indexX][indexY].equals("0") && isHashAround(indexX, indexY);
    }

    private void fillArrayWithRecursionIfYouHitZero(int x, int y) {
        printNumbersAround(x, y);
        if (x >= 0 && x < size && y >= 0 && y < size) {
            if (x > 0) {
                int indexX = x - 1;
                if (canDoRecursion(indexX, y)) fillArrayWithRecursionIfYouHitZero(indexX, y);
            }
            if (y > 0) {
                int indexY = y - 1;
                if (canDoRecursion(x, indexY)) fillArrayWithRecursionIfYouHitZero(x, indexY);
            }
            if (x < size - 1) {
                int indexX = x + 1;
                if (canDoRecursion(indexX, y)) fillArrayWithRecursionIfYouHitZero(indexX, y);
            }

            if (y < size - 1) {
                int indexY = y + 1;
                if (canDoRecursion(x, indexY)) fillArrayWithRecursionIfYouHitZero(x, indexY);
            }
            if (x > 0 && y > 0) {
                int indexX = x - 1;
                int indexY = y - 1;
                if (canDoRecursion(indexX, indexY)) fillArrayWithRecursionIfYouHitZero(indexX, indexY);
            }
            if (x > 0 && y < size - 1) {
                int indexX = x - 1;
                int indexY = y + 1;
                if (canDoRecursion(indexX, indexY)) fillArrayWithRecursionIfYouHitZero(indexX, indexY);
            }
            if (x < size - 1 && y > 0) {
                int indexX = x + 1;
                int indexY = y - 1;
                if (canDoRecursion(indexX, indexY)) fillArrayWithRecursionIfYouHitZero(indexX, indexY);
            }
            if (x < size - 1 && y < size - 1) {
                int indexX = x + 1;
                int indexY = y + 1;
                if (canDoRecursion(indexX, indexY)) fillArrayWithRecursionIfYouHitZero(indexX, indexY);
            }
        }
    }

    void playAGame() {
        createCompletedAraay();
        System.out.println("Player's Array");
        createArray(playerArray);
        while (!endOfTheGame()) {
            userMove();
            if (gameLost) {
                System.out.println("You lost");
                break;
            }
            System.out.println("Player's Array");
            createArray(playerArray);
        }
    }
}