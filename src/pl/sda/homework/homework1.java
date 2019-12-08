package pl.sda.homework;

public class homework1 {

    static void myString (String text) {
        int words =0;
        String[] allWords = text.split(" ");
        for (int i = 0; i <allWords.length; i++) {
            words = i+1;
        }
        System.out.println("Ilość wszystkich znaków: "+text.length());
        System.out.println("Ilość wszystkich znaków bez spacji: "+text.replace(" ","").length());
        System.out.println("Ilość wyrazów: "+ words);
    }

    static void longestWord (String typeText) {

        //definicja tablicy zawierajacej wszystkie slowa
        String[] words  = typeText.split(" ");

        //pierwszy wyraz tablicy
        String longest = words[0];

        //znalezienie długości najdłuższego słowa
        int lengthOfLongest = words[0].length();
        for (int i = 0; i <words.length; i++) {
            if(words[i].length()>longest.length()) {
                lengthOfLongest=words[i].length();
            }
        }
        //zliczenie najdluzszych wyrazów
        int countOfLongest = 0;
        for (int i = 0; i <words.length; i++) {
            if(words[i].length() == lengthOfLongest)
            countOfLongest+=i;
        }

        //wypisanie wszystkich najdluzszych
if (countOfLongest>1) {
    System.out.print("Najdłuższe słowa to: ");
}
else {
    System.out.print("Jest tylko jedno najdłuższe słowo: ");
}
            for (String word : words) {
                if (word.length() == lengthOfLongest) {
                    System.out.print(word + " ");
                }
            }
        //wypisanie pierwszego najdluzszego wyrazu
        for (String word: words) {
            if (word.length()>longest.length()) {
                longest = word;
            }
        }
        System.out.println();
        System.out.println("Pierwsze najdłuższe słowo to: " +longest);
    }

    static void arythProgression (int length, int firstElement, int diff) {
        System.out.print("Utorzony ciąg arytmetyczny: ");
        int lastElem= firstElement+(diff*length);
        for (int i = firstElement; i < lastElem; i+=diff) {
            System.out.print(i+ " ");
        }

    }
    static void isProgression (int[] sequence) {
        System.out.print("Podany ciąg ");
        int diff = sequence[1]-sequence[0];
        for (int i = sequence[1]; i <sequence.length; i++) {
            if (sequence[i] != sequence[i-1]+diff) {
                System.out.print("nie jest ciągiem arytmetycznym");
                break;
            }
            else {
                System.out.print("jest ciągiem arytmetycznym");
            }
        }
    }
    public static void main(String[] args) {

        System.out.println("Exercise 1: ");
        String text = "Hello it's me";
        myString(text);

        System.out.println();
        System.out.println("Exercise 2:");
        longestWord("Ala Ada Aga Jo ");
        System.out.println();

        System.out.println("Exercise 3: ");
        System.out.println("Podaj długość, pierwszy element oraz różnicę");
        arythProgression(4,2,3);
        System.out.println();
        System.out.println();

        System.out.println("Exercise 4: ");
        int[] numbers = {2,4,6,8,11};
        isProgression(numbers);
    }

}