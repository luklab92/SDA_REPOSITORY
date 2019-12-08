package pl.sda.zajecia;

public class zajecia_2710 {

    static void isAdult(int age) {
        if (age >= 18) {
            System.out.println("Jestem pełnoletni");
        } else {
            System.out.println("Za młody");
        }
    }
    static boolean isAdult2(int yearOfBirth) {
        int age = 2019-yearOfBirth;
        return age>=18;
    }
    static void stars(int row, int line) {

        for (int j=1; j<=line; j++) {
            for (int i = 1; i <= row; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static double circle (double radius) {
        final double PI = 3.14;


        return PI*radius*radius;
    }
    static void sprawdzenie (String[] strings, int length) {


        for (int i = 0; i <strings.length; i++) {
            if (strings[i].length()>length) {
                System.out.println(strings[i] + ": " + strings[i].length());
            }
        }
    }

    static void split (String sentence){

        System.out.println(sentence);


        String[] result = sentence.split(" ");
        for (int i =0; i<result.length;i++) {
            System.out.println(result[i]);
        }
        System.out.println("Liczba słów w podanym stringu wynosi: "+result.length);
    }
     static void splitChar (String word){

         for (int i =0; i<word.length();i++) {
             if (word.charAt(i) != 'k') {
                 System.out.println(word.charAt(i));
             } else {
                 break;
             }
         }
     }
    static void initials (String name) {
        String[] words = name.split(" ");
        for (int i = 0; i < words.length; i++) {
            if(i%2==0 && i!=0) {
                System.out.println();
            }
            System.out.print(words[i].toUpperCase().charAt(0) + "");
        }
    }

    static void rotate (String smfg) {
        String[] dropped = smfg.split("");
        for (int i = dropped.length-1; i>=0; i--) {
            System.out.print(dropped[i]);
        }
    }



   static void womanOrMan (String[] firstNames) {
       // String[] firstNames = {"Andrzej", "Stefan", "AnnA", "Krzysztof", "Maria"};
        
        for (int i = 0; i <firstNames.length; i++) {
            //System.out.println(firstNames[i].charAt(firstNames[i].length()-1));
            if (firstNames[i].toLowerCase().endsWith("a"))  {
                System.out.println(firstNames[i]+"- Imię damskie");
            }
            else {
                System.out.println(firstNames[i] + "- Imię męskie");
            }
        }
    }

    static boolean isFemale (String name) {
        return name.toLowerCase().endsWith("a");

    }

    public static void main(String[] args) {
        isAdult(19);
        int year = 2005;
        if (isAdult2(year)) {
            System.out.println("Jestem pełnoletni");
        }
        System.out.println("Nie jestem pełnoletni");

        stars(5,10);
        double finish = circle(5);
        System.out.println(finish);

        //wprowadz talice oraz parametr okreslajacy ilosc znakow

        String[] strings = {"dssa","dsdasda","dasdssaddsaada"};
        System.out.println("Zadanie z dlugoscia");
        sprawdzenie(strings,7);

        System.out.println();
        System.out.println("Zadanie ze splitem");
        String sentence = "Ala ma kota a kot ma Ale, Ala ma tez psa i pies ma Ale";
        split(sentence);

        System.out.println();
        System.out.println("Zadanie z charAt:");
        splitChar("hipokrates");

        System.out.println();
        System.out.println("Zadanie z inicjałami: ");
        String firstLetters = "Lukasz Labusek Marek Kowalski Zenon Martyniuk Krzysztof Zalewski";
        initials(firstLetters);

        System.out.println();
        System.out.println();
        System.out.println("Odwrócenie: ");
        rotate("tekst napisany od tylu");

        System.out.println();
        System.out.println();
        System.out.println("Zadanie z imionami: ");
        String[] names = {"Andrzej", "Stefan", "AnnA", "Krzysztof", "Maria"};
        womanOrMan(names);


        System.out.println();
        System.out.println("FUnkcja isFemale");
        String name = "Anna";
        if (isFemale(name)) {
            System.out.println(name+ " - żeńskie");
        }
    }
}