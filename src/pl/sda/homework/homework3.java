package pl.sda.homework;

public class homework3 {

    static void printStars(String type, int howManyLines) {

        int allLines = howManyLines * 2;

        for (int i = 0; i < allLines; i++) {

            if (i >= 0 && i < howManyLines) {
                for (int j = 0; j < i + 1; j++) {
                    System.out.print(type); }
                    System.out.println(); }

            else {
                for (int j = allLines - 1 - i; j > 0; j--) {
                    System.out.print(type); }
                    System.out.println(); }
        }
    }

    static void printStars2(String type,int howManyLines) {
        if (howManyLines % 2 == 0) {
            howManyLines -= 1;
        }
        int allLines = howManyLines * 2;

        for (int i = 0; i < allLines; i = i + 2) {
            if (i >= 0 && i <= howManyLines) {
                String space1 = " ";
                for (int space = 0 + i / 2; space < howManyLines / 2; space++) {
                    System.out.print(space1);
                }
                for (int j = 0; j < i + 1; j++) {
                    System.out.print(type);
                }
                System.out.println();
            } else {
                String space1 = " ";
                for (int space = howManyLines/2; space < i/2; space++) {
                    System.out.print(space1);
                }
                for (int j = howManyLines; j > i-howManyLines+1; j--) {
                    System.out.print(type);
                }
                System.out.println();
            }
        }
        }
    static boolean isPrimeNumber(int a) {
        if (a==1 || a==0 || a<0) {return false;}
        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                return false; }
        }return true;
    }

    static void printPrimes (int counter) {
        int a = 2;
        int count = 0;
        while (count < counter) {
            if (isPrimeNumber(a) == true) {
                System.out.print(a+" ");
                count++;
            }
            a++;
        }
    }

    static int sumPrimes (int numberOfPrimes) {
        int a = 2;
        int count = 0;
        int sum=0;
        while (count < numberOfPrimes) {
            if (isPrimeNumber(a) == true) {
                sum=sum+a;
                count++;
            }
            a++;
        }
        return sum;
    }

    static boolean isYearLeap(int actualYear) {

        // zapisac osobno dla czytelnosci kodu
        boolean isDivided4 = actualYear % 4 == 0;
        boolean isDivided100 = actualYear % 100 == 0;
        boolean isDivided400 = actualYear % 400 == 0;
        return isDivided4 && !isDivided100 || isDivided400;
    }

    static int daysOfMonth (int month,int actualYear) {

        if(month==2 && isYearLeap(actualYear)==false) return 28;
        else if (month==2 && isYearLeap(actualYear)==true) return 29;
        else if ((month%2==1 && month<=7 )|| (month>7 && month%2==0)) return 31;
        else return 30;
        }

    static String getMonth (int monthNumber) {

        final String error = "bledny dzień";
       try {
           return homework3.months[monthNumber - 1];
       }
       catch (Exception e) {return error;}
        }


        static String getDayOfWeek (int dayInWeek) {
           return homework3.dayOfWeek[dayInWeek];
        }

        static int getLeapDays (int year) {
        int countLeapDays = 0;
            for (int i =2019; i > year; i--) {
                if(isYearLeap(i) == true)
                    countLeapDays++;
            }
            return countLeapDays;
        }

    static int getDayOfPrev (int year){
            int countdays=0;
            for (int i = year; i <2019; i++) {
                countdays -= 365;
            }
            return countdays;
        }

    final static String[] dayOfWeek = {"poniedziałek", "wtorek", "środa", "czwartek", "piątek", "sobota", "niedziela"};
    final static String[] months = {"styczen","luty","marzec","kwiecień","maj","czerwiec","lipiec","sierpień","wrzesień","październik","listopad","grudzień"};

        static void dayOfTheYear (int dayOfYear, int actualYear) {
            int currentDay = dayOfYear;
            int currentDayOfWeek=0;

            if (actualYear<2019)
                currentDayOfWeek=(7+(dayOfYear+getDayOfPrev(actualYear))%7)%7;
            else
                currentDayOfWeek=currentDay%7;

            int days = dayOfYear+getDayOfPrev(actualYear);
            System.out.println(days);
            int currentMonth = 1,day = 0, month = 0;
            boolean found = false;
            while (!found) {

                int daysInCurrentMonth = daysOfMonth(currentMonth,actualYear);
                if (currentDay > daysInCurrentMonth) {
                    currentDay = currentDay - daysInCurrentMonth;
                    currentMonth++;
                } else {
                    day = currentDay;
                    month = currentMonth;
                    found = true;
                }
            }
            if(month>0&&month<=12) {
                    System.out.println(dayOfYear + " dzień roku " + actualYear + ": " + day + " " + getMonth(month) + ", " + getDayOfWeek(currentDayOfWeek));
            }
            else System.out.println(dayOfYear + " dzień roku " + actualYear + ": błędny dzień, rok nie ma tylu dni");
        }


// moje rozwiazanie

    /*static void dayOfYear (int day, int actualYear) {
            int month=0;
            if (isYearLeap(actualYear) == true)
            {
                if(day==60) System.out.println("29 luty");
                else if(day>60) day--;
            }
            if (day<=31) month=1;
            else if (day>31 && day<=59) month = 2;
            else if (day>59 && day<=90 && isYearLeap(actualYear)==false) month = 3;
            else if (day>90 && day<=120) month = 4;
            else if (day>120 && day<=151) month = 5;
            else if (day>151 && day<=181) month = 6;
            else if (day>181 && day<=212) month = 7;
            else if (day>212 && day<=243) month = 8;
            else if (day>243 && day<=273) month = 9;
            else if (day>273 && day<=304) month = 10;
            else if (day>304 && day<=334) month = 11;
            else if (day>334 && day<=365) month = 12;

            else if ((day>365 && isYearLeap(actualYear)==false) || (day>366 && isYearLeap(actualYear)==true))System.out.println("Podaj właściwy dzień");
            switch (month){
                case 1:
                    if(day<31)
                        System.out.println(day+" styczeń");
                case 2:
                    if (day>31 && day<=59)
                        System.out.println(day-31+" luty");
                case 3:
                    if(day>59 && day<=90)
                        System.out.println(day-59+" marzec");
                case 4:
                    if(day>90 && day<=120)
                        System.out.println(day-90+" kwiecień");
                case 5:
                    if(day>120 && day<=151)
                        System.out.println(day-120+" maj");
                case 6:
                    if(day>151 && day<=181)
                        System.out.println(day-151+" czerwiec");
                case 7:
                    if(day>181 && day<=212)
                        System.out.println(day-181+" lipiec");
                case 8:
                    if(day>212 && day<=243)
                        System.out.println(day-212+" sierpień");
                case 9:
                    if(day>243 && day<=273)
                        System.out.println(day-243+" wrzesień");
                case 10:
                    if(day>273 && day<=304)
                        System.out.println(day-273+" październik");
                case 11:
                    if(day>304 && day<=334)
                        System.out.println(day-304+" listopad");
                case 12:
                    if(day>334 && day<=365)
                        System.out.println(day-334+" grudzień");
            }
    }*/
    public static void main(String[] args) {
printStars("*",4);
printStars2("*",35);
        System.out.println(isPrimeNumber(-1));
        printPrimes(7);
        System.out.println();
        System.out.println("suma " + 5 + " liczb pierwszych wynosi : "+sumPrimes(5));
        dayOfTheYear(59,2018);
    }
}