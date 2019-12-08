package pl.sda.saper;

import org.w3c.dom.ls.LSOutput;

//NAPISAC COUNTBOMB!!!!!

//klasa zawiera:
//czy jest B
//ile jest B dookola
// czy jest odkryte pole




public class numbers {
   private int numberX;
   private int numberY;
   private int bombCounter;
   private int maxBombInSaper=0;

   public int bombCounter (int maxBombInSaper) {
       for (int i = 0; i <table.length; i++) {
           for (int j = 0; j <table[i].length; j++) {
            if (table[i][j]==9)
               maxBombInSaper+=1;
           }

       }

       return maxBombInSaper;

   }


   public numbers() {

   }
public numbers(int numberX, int numberY) {
    this.numberX=numberX;
    this.numberY=numberY;
}
int[][] table = {{1, 9, 2, 9, 1}, {1, 1, 1, 1, 1}, {1, 2, 1, 1, 1}, {9, 1, 0, 2, 9}, {1, 2, 1, 2, 1}};
int[][] userTable = new int[5][5];

    public void print (int numberX, int numberY) {

if(userTable[numberX][numberY]==0) {

    if (table[numberX][numberY] == 9) {
        System.out.println();
        System.out.println("przegrałes");
    }
            else {
        System.out.println();
        int xMin = numberX - 1, xMax = numberX + 1, yMin = numberY - 1, yMax = numberY + 1;

        userTable[numberX][numberY] = table[numberX][numberY];

        if (numberX == 0 && numberY == 0) {
            xMin += 1;
            yMin += 1;
        } else if (numberX == table.length-1 && numberY == table.length-1) {
            xMax -= 1;
            xMax -= 1;
        } else if (numberX == 0) xMin += 1;
        else if (numberY == 0) yMin += 1;
        else if (numberX == table.length-1) xMax -= 1;
        else if (numberY == table.length-1) yMax -= 1;

        for (int i = xMin; i <= xMax; i++) {
            for (int j = yMin; j <= yMax; j++) {
                if (table[i][j] != 9)
                    userTable[i][j] = table[i][j];
            }
           // System.out.println();
        }

        for (int i = 0; i < userTable.length; i++) {
            for (int j = 0; j < userTable[i].length; j++) {
                System.out.print(userTable[i][j] + " ");
            }
            System.out.println();
        }
    }

    System.out.println();
    }
else System.out.println("Podaj inna wartosc");
    }

    public void printBomb (int numberX, int numberY) {
        System.out.println(bombCounter(bombCounter) + "- ilość pozostałch bomb");
        if (bombCounter <= 0) {
            System.out.println("Nie masz juz bomb");
        } else {
            if (userTable[numberX][numberY] == 0) {
                userTable[numberX][numberY] = 9;
            } else System.out.println("w podanym polu znajduje się już wartość, nie można umieścić bomby");
            for (int i = 0; i < userTable.length; i++) {
                for (int j = 0; j < userTable[i].length; j++) {
                    System.out.print(userTable[i][j] + " ");
                }
                System.out.println();
            }
            bombCounter--;
        }
    }


}



