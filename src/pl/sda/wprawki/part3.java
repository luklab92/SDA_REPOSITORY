package pl.sda.wprawki;

public class part3 {

    static void table1 (int x) {
    int[] numbers = new int[x];
        for (int i = 1; i < numbers.length; i++) {
        numbers[i]=i;
    }
        for (int i = 0; i <numbers.length; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.print(numbers[i]+" ");
            }
        }
    }

static void compare(int[] tableA, int[] tableB, int number) {

int counter = 0;
    for (int i = 0; i < tableA.length; i++) {
        if (tableA[i] == number || tableB[i] == number) {
            counter +=1;
        }
    }
    System.out.println("liczba " + number + " występuje " + counter + " razy");
}

static boolean isExist(int[] tableA, int[] tableB, int number){
        int sumlength = tableA.length+tableB.length;
    int[] mergedTable = new int[sumlength];
    for (int i = 0; i <sumlength; i++) {
        if(i<tableA.length){
            mergedTable[i]=tableA[i];
        }
        else {
            mergedTable[i] = tableB[i-tableA.length];
        }
    }
    for (int i = 0; i <mergedTable.length; i++) {
        if(mergedTable[i]==number)
        return true;

    }
return false;
    }


static void numbers (int[] nums) {
    int sum = 0;
    int minSum = 0;
    int countMinus = 0;
    int countPlus = 0;
    int countZero = 0;
    int countAll = 0;


    for (int i = 0; i <nums.length; i++) {
        countAll+=1;
    }

    for (int i = 0; i < nums.length; i++) {
        sum = sum + nums[i];
    }

    minSum = nums[0];
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] < minSum) {
            minSum = nums[i];
        }
    }

    for (int i = 0; i < nums.length; i++) {
        if (nums[i] < 0) {
            countMinus += 1;
        } else if (nums[i] > 0) {
            countPlus += 1;
        } else {
            countZero += 1;
        }
    }


    int[] minus = new int[countMinus];
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] < 0) {
            minus[j++] = nums[i];
        }
    }
    System.out.println("Liczba wszystkich elementów: " + countAll);
    System.out.println("Suma wynosi: " + sum);
    System.out.println("Wartość minimalna to: " + minSum);
    System.out.println("Liczba ujemnych: " + countMinus);
    System.out.println("Liczba dodatnich: " + countPlus);
    System.out.println("Liczba zer: " + countZero);
    System.out.println("Sumowanie ujemnych liczb: "+(minus.length));
    System.out.println("Tablica ujemnych liczb");
    for (int i = 0; i < minus.length; i++) {
        System.out.print(minus[i]+" ");
    }
}
    public static void main(String[] args) {
  String myName = "Lukas";
String[] names = {"Mark", "John", "Jerry"};
names[1] = myName;

int[] randomNumbers = {14,8,4};

randomNumbers[0]=randomNumbers[2];
randomNumbers[2]=0;

        for (int i = 0; i <randomNumbers.length; i++) {
            System.out.print(randomNumbers[i]+" ");
        }
        System.out.println();

for (String element: names) {
    System.out.println(element);
}
    System.out.println("Ex 3");
    table1(50);

        System.out.println();
        System.out.println("Ex 4");
        int tableA[] = {1, 2, 3};
        int tableB[] = {2, 9, 16};
        compare(tableA, tableB, 2);
        System.out.println(isExist(tableA, tableB, 8));

        System.out.println("sumowanie: ");
        int[] nums = {3, -2, -3, -4, 0, 4, 5};
        numbers(nums);
    }
}
