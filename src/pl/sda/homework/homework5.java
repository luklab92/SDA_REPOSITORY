package pl.sda.homework;

public class homework5 {


    // Zrobic dla STringa a nie tablicy intow /////////////////////


    static double binarySystem(int[] nums) {
        double numberInTens = 0;

        //odwrocenie tablicy

        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }

        if (nums[nums.length - 1] == 1) numberInTens = -homework2.force(2, nums.length - 1);
        for (int i = 0; i < nums.length - 2; i++) {
            numberInTens = numberInTens + nums[i] * homework2.force(2, i);
        }
        return numberInTens;
    }


    static double numberToBinary (int number){
        double lookingNumber=0;
        int compareNumber=number;
        double temp=0;
        //System.out.println(homework2.force(2,5));
        for (int i = 1; i <number; i++) {
            temp = homework2.force(2,i);
                if(temp>number) {
                    lookingNumber=temp;
                }
        }
        return temp;
    }

    //sortowanie babelkowe
    static int[] babelkowe(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] < nums[j + 1]) {
                    int a = nums[j + 1];
                    int b = nums[j];
                    nums[j] = a;
                    nums[j + 1] = b;
                }
            }
        }
        for (int element : nums) {
            //System.out.print(element+" ");
        }
        return nums;
    }

    static boolean isFemale(String sex) {
        if (sex == "female")
            return true;
        else if (sex == "male")
        return false;
        return false;
    }

    static boolean isDisabled(String dis) {
        return (dis == "d");
    }

    static boolean isAdult(int age) {
        return (age >= 18);
    }

    static void isSenior(int age) {
        if (age >= 60) {
            System.out.print(" i zapraszamy do gry w bingo");
            System.out.println();
            System.out.print("z wyrazami szacunku");
        }
    }


    static void hello(int age, String sex, String dis, String[] p) {
        String[] greet = {"Szanowna Pani", "Panią", "Szanowny Panie", "Pana", "Cię"};
        String[] greetDisabled = {"Droga Użytkowniczko", "Drogi Użytkowniku", "Cię"};
        String[] seeYou = {"do zobaczenia", "czekamy na Pana", "czekamy na Panią", "z wyrazami szacunku"};
        String[] drinks = {" kieliszkiem szampana", " kubkiem gorącej czekolady"};
       // String[] personal={"Lukasz", "Michal", "Labusek", "ulica 2/1", "Wrocław"};
        System.out.println(p[0]+" "+p[1]+" "+p[2]);
        System.out.println(p[3]);
        System.out.println(p[4]);
        if (!isAdult(age)) {
            if (isFemale(sex)) System.out.println(greet[0]);
            else System.out.println(greet[2]);
            System.out.println("Zapraszamy " + greet[4] + " serdecznie na otwarcie naszego sklepu!");
            System.out.print("Powitamy " + greet[4] + drinks[1]);
            System.out.println();
            System.out.println(seeYou[0]);
        }

        if (isAdult(age) && isFemale(sex) && !isDisabled(dis)) {
            System.out.println(greet[0]);
            System.out.println("Zapraszamy " + greet[1] + " serdecznie na otwarcie naszego sklepu!");
            System.out.print("Powitamy " + greet[1] + drinks[0]);

        } else if (isAdult(age) && isFemale(sex) && isDisabled(dis)) {
            System.out.println(greetDisabled[0]);
            System.out.println("Zapraszamy " + greetDisabled[2] + " serdecznie na otwarcie naszego sklepu!");
            System.out.print("Powitamy " + greetDisabled[2] + drinks[0]);

        }

        if (isAdult(age) && !isFemale(sex) && !isDisabled(dis)) {
            System.out.println(greet[2]);
            System.out.println("Zapraszamy " + greet[3] + " serdecznie na otwarcie naszego sklepu!");
            System.out.print("Powitamy " + greet[3] + drinks[0]);
            isAdult(age);
        } else if (isAdult(age) && !isFemale(sex) && isDisabled(dis)) {
            System.out.println(greetDisabled[1]);
            System.out.println("Zapraszamy " + greetDisabled[2] + " serdecznie na otwarcie naszego sklepu!");
            System.out.print("Powitamy " + greetDisabled[2] + drinks[0]);
            isAdult(age);
        }
        //System.out.println();
        if (age > 60) {
            isSenior(age);
        } else {
            if (isFemale(sex) && isAdult(age)) {
                System.out.println();
                System.out.println(seeYou[2]);
            } else if (!isFemale(sex) && isAdult(age)) {
                System.out.println();
                System.out.println(seeYou[1]);
            }
        }
    }


static void repeat (int[] nums) {
int largest =nums[0];
    for (int i = 1; i <nums.length; i++) {
        if(nums[i]>largest) largest=nums[i];
    }

    for (int i = 1; i <nums.length; i++) {
        if(nums[i]==nums[i-1]) nums[i]=largest+1;

    }
    for (int i = 0; i <nums.length; i++) {
if(nums[i]!=largest+1) System.out.print(nums[i]+" ");
    }
}

static void credit (double A, int n, double b) {
//A - wysokosc kredytu
    //b - oprocentowanei w skali roku
    //n - ilosc rat do splaty
    //R wysokosc raty
    //C - calkowita kwota do splaty
    //Rk=A/n - rata kapitalowa
    //Ro - rata odsetkowa
    //x - ilosc splaconych rat
        double Rk=A/n;
        int remaining=n%12;
        if (remaining==0) remaining=12;
double Ro=0;
double sum=0;
double lastYear=0;
    for (int i = 0; i <n; i++) {
        Ro=Rk+((A - i * Rk) * b )/ 12;
        sum+=Ro;
        System.out.println(i+1+" rata: "+(int)(Ro)+"zł - rata odsetkowa: "+(int)(Ro-Rk)+"zł, rata kapitałowa: "+(int)Rk+"zł");
    }
    for (int i = n-remaining; i <n; i++) {
        Ro=Rk+((A - i * Rk) * b )/ 12;
        lastYear+=Ro;
        //System.out.printf("%.2f ",Ro);

    }
    System.out.println();
    System.out.printf("Całkowita kwota do spłaty %.2f",sum);
    System.out.println();
    System.out.printf("Odsetki wynoszą: %.2f",(sum-A));
    System.out.println();
    System.out.printf("W ostatnim roku zaplacisz: %.2f",lastYear);
}

    public static void main(String[] args) {
        int[] a = {0,0,0,0,0,1,1,1,0,1};
        System.out.println(binarySystem(a));
        System.out.println();

        int[] numbers = {-2,-5,-1,-2,5,4,3};
        //babelkowe(numbers);
        repeat(babelkowe(numbers));
        System.out.println();
        System.out.println();
        String[] person1 = {"Lukasz", "Michal", "Labusek", "ulica 2/1", "Wrocław"};
        String[] person2 = {"Anna","", "Kowalczyk", "ulica 2/4", "Wrocław"};

        hello(62,"female","nd",person2);
        System.out.println();
        System.out.println();
        credit(300000,14,4.7*0.01);

        System.out.println(numberToBinary(55));
    }
}
