package pl.sda.saper;

public class Main {



    public static void main(String[] args) {
        int[][] table = {{1, 9, 2, 9, 1}, {1, 1, 1, 1, 1}, {1, 2, 1, 1, 1}, {9, 1, 0, 2, 9}, {1, 2, 1, 2, 1}};

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        /*int[][] userTable = new int[5][5];*/

        //pierwsze wpisanie
        numbers number = new numbers();
        number.print(0,2);
        number.print(0,2);
        number.print(0,1); //<---- PRZEGRANA!!!!
        number.printBomb(0,1);
        number.print(0,0);
        number.print(2,1);
        number.printBomb(3,0);
        number.print(3,3);
        number.printBomb(0,3);
        number.print(1,4);
        //number.print(4,0);

        //NAPISAC COUNTBOMB!!!!!
        //NAPISAC WARUNEK ZWYCIESTWA!!!!!



        /*if (table[x][y] == 9)
            System.out.println("przegrałes");
            else
            {
                int xMin = x - 1, xMax = x + 1, yMin = y - 1, yMax = y + 1;
                userTable[x][y] = 1;
                if (x == 0 && y == 0) {
                    xMin += 1;
                    yMin += 1;
                } else if (x == table.length && y == table.length) {
                    xMax -= 1;
                    xMax -= 1;
                } else if (x == 0) xMin += 1;
                else if (y == 0) yMin += 1;
                else if (x == table.length) xMax -= 1;
                else if (y == table.length) yMax -= 1;

                for (int i = xMin; i <= xMax; i++) {
                    for (int j = yMin; j <= yMax; j++) {
                        if (table[i][j] != 9)
                            userTable[i][j] = table[i][j];
                    }
                }

                System.out.println();
                for (int i = 0; i < userTable.length; i++) {
                    for (int j = 0; j < userTable[i].length; j++) {
                        System.out.print(userTable[i][j] + " ");
                    }
                    System.out.println();
                }
            }*/

        }
    }

