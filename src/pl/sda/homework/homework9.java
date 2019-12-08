package pl.sda.homework;
import java.util.*;


public class homework9 {

    public void firstNames () {
        String type="";
        List<String> h91 = new LinkedList<>();
        Set<String> h92 = new HashSet<>();
        while (!type.equals("-")) {
            Scanner firstName = new Scanner(System.in);
            type = firstName.nextLine();
            h91.add(type);
            h92.add(type);
        }

        h91.sort(Comparator.naturalOrder());
        System.out.println("Uporządkowana lista");
        for (String cont: h91) {
            if (cont!="-")
            System.out.println(cont);
        }
        System.out.println();
        System.out.println("Lista unikalna");
        for (String cont: h92) {
            if (cont!="-")
            System.out.println(cont);
        }
        System.out.println("Rozmiar listy: "+(h92.size()-1));
    }


    }


