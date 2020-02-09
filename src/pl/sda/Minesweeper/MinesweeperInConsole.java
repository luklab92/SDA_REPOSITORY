package pl.sda.Minesweeper;

import java.util.Scanner;

class MinesweeperInConsole {
    private int rowSize;
    private int colSize;
    private int numberOfBombs;
    private String[][] filledArray;
    private String[][] playerArray;
    private boolean gameLost = false;
    private int currentNumberOfBombs;

    private void getSize() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type a rowSize: ");
        rowSize = scanner.nextInt();
        System.out.println("Type a colSize: ");
        colSize = scanner.nextInt();
    }

    private void createArray(String[][] arrays) {
        System.out.print("   ");
        for (int i = 0; i < colSize; i++) {
            if (i < 10) System.out.print(i + " ");
            else System.out.print(i + " ");
        }
        System.out.print("\n  ");
        for (int i = 0; i < colSize; i++) {
            System.out.print(" -");
        }
        System.out.println();
        for (int i = 0; i < rowSize; i++) {
            String[] strings = arrays[i];
            if (i < 10) System.out.print((i) + " |");
            else System.out.print((i) + "|");
            for (int j = 0; j < colSize; j++) {
                System.out.print(strings[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void createCompletedAraay() {
        choiceGameDifficult();
        filledArray = new String[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
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
        playerArray = new String[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                playerArray[i][j] = "#";
            }
        }
    }

    private boolean statementForMakeBombs() {
        return Math.random() > 0.98;
    }

    private void initBombs() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type number of Bombs");
        numberOfBombs = scanner.nextInt();
    }

    private void choiceGameDifficult() {
        System.out.println("Choose game's difficult");
        System.out.println("1- Small, 2- Medium, 3- Expert, Else - User");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        switch (choice.toLowerCase()) {
            case "small":
                rowSize = colSize = 8;
                numberOfBombs = 10;
                break;
            case "medium":
                rowSize = colSize = 16;
                numberOfBombs = 40;
                break;
            case "expert":
                rowSize = 16;
                colSize = 30;
                numberOfBombs = 99;
                break;
            default:
                getSize();
                initBombs();
                break;
        }
    }

    private void makeBombs() {
        int counter = 0;
        while (counter < numberOfBombs) {
            for (int i = 0; i < rowSize; i++) {
                for (int j = 0; j < colSize; j++) {
                    if (statementForMakeBombs() && counter < numberOfBombs && filledArray[i][j].equals("0")) {
                        filledArray[i][j] = "B";
                        counter++;
                    }
                }
            }
        }
    }

    private void fillCompletedArrayWithNumbers() {
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (filledArray[i][j].equals("B")) {
                    for (int k = i - 1; k <= i + 1; k++) {
                        for (int l = j - 1; l <= j + 1; l++) {
                            if (l >= 0 && k >= 0 && l < colSize && k < rowSize && filledArray[k][l] != null && !filledArray[k][l].equals("B")) {
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
                if (playerArray[x][y].equals("B") && !filledArray[x][y].equals("B")) currentNumberOfBombs--;
                else playerArray[x][y] = filledArray[x][y];
            }
        }
        if (choice == 2) setBomb(x, y);
    }

    private int userTypeRow() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type row");
        int x = scanner.nextInt();
        while (x < 0 || x >= rowSize) {
            System.out.println("Type row");
            x = scanner.nextInt();
        }
        return x;
    }

    private int userTypeColumn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type column");
        int y = scanner.nextInt();
        while (y < 0 || y >= colSize) {
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
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (!playerArray[i][j].equals(filledArray[i][j])) return false;
            }
        }
        System.out.println("You won");
        return true;
    }

    private void printNumbersAround(int x, int y) {
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (j >= 0 && i >= 0 && j < colSize && i < rowSize && filledArray[i][j] != null)
                    playerArray[i][j] = filledArray[i][j];
            }
        }
    }

    private boolean isHashAround(int x, int y) {
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (j >= 0 && i >= 0 && j < colSize && i < rowSize && filledArray[i][j] != null) {
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
            if (x > 0) {
                int indexX = x - 1;
                if (canDoRecursion(indexX, y)) fillArrayWithRecursionIfYouHitZero(indexX, y);
            }
            if (y > 0) {
                int indexY = y - 1;
                if (canDoRecursion(x, indexY)) fillArrayWithRecursionIfYouHitZero(x, indexY);
            }
            if (x < rowSize - 1) {
                int indexX = x + 1;
                if (canDoRecursion(indexX, y)) fillArrayWithRecursionIfYouHitZero(indexX, y);
            }

            if (y < colSize - 1) {
                int indexY = y + 1;
                if (canDoRecursion(x, indexY)) fillArrayWithRecursionIfYouHitZero(x, indexY);
            }
            if (x > 0 && y > 0) {
                int indexX = x - 1;
                int indexY = y - 1;
                if (canDoRecursion(indexX, indexY)) fillArrayWithRecursionIfYouHitZero(indexX, indexY);
            }
            if (x > 0 && y < colSize - 1) {
                int indexX = x - 1;
                int indexY = y + 1;
                if (canDoRecursion(indexX, indexY)) fillArrayWithRecursionIfYouHitZero(indexX, indexY);
            }
            if (x < rowSize - 1 && y > 0) {
                int indexX = x + 1;
                int indexY = y - 1;
                if (canDoRecursion(indexX, indexY)) fillArrayWithRecursionIfYouHitZero(indexX, indexY);
            }
            if (x < rowSize - 1 && y < colSize - 1) {
                int indexX = x + 1;
                int indexY = y + 1;
                if (canDoRecursion(indexX, indexY)) fillArrayWithRecursionIfYouHitZero(indexX, indexY);
            }
        }

    void playAGame() {
        createCompletedAraay();
        System.out.println("Player's Array");
        createArray(playerArray);
        long startTime = System.nanoTime();
        while (!endOfTheGame()) {
            userMove();
            if (gameLost) {
                System.out.println("You lost");
                break;
            }
            System.out.println("Player's Array");
            createArray(playerArray);
        }
        long endTime = System.nanoTime();
        System.out.println("Time of your's game: " + (endTime - startTime) / 1000000000 + "s");
    }
}