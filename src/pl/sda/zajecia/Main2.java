package pl.sda.zajecia;


public class Main2 {
    static void printGender(String[] name) {
        for (int i=0; i<=3; i++)
            if (name[i].toLowerCase().endsWith("a")) {
                System.out.println("żeńskie");
            } else {
                System.out.println("męskie");
            }

    }

    static boolean isFemale(String name) {
        for (int i=0; i<=3; i++) {
            if (name.toLowerCase().endsWith("a"))
                return true;

        }
        return false;
    }

    public static void main(String[] args) {
        String[] name2 = {"Paweł", "Olek", "Ania", "Ola"};
        String name3 = "pawel";
        printGender(name2);
        System.out.println(isFemale(name3));



    }
}
