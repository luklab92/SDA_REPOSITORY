package pl.sda.day5;
import pl.sda.zajecia_161711.*;
import java.util.*;


public class Main{

    public static <E> E getFirst(E[] tab) {  //typ generyczny
        return tab[0];
    }

    public static void main(String[] args) {
Person[] person = {
        new Person("jan","Kowalski",2000,Gender.MAN),
        new Person("Miłosz","Krasinski",2011,Gender.MAN)
};

Person p1 = person[1];
p1.getAge();

Person p2 = getFirst(person);
p2.getAge(); // poprzez tworzenie typu generycznego mamy dostep do funkcji getAge
//p2.getAge(); <nie stosujemy object bo getfirst nie ma dostepu do getAge, nalezaloby wykonac rzutowanie na klase Person2;


   /* Scanner number1 = new Scanner(System.in);
        System.out.println("Podaj liczbę");
int a =number1.nextInt();
        Scanner number2 = new Scanner(System.in);
        System.out.println("Podaj drugą liczbę");
      int b = number2.nextInt();
      int sum = a+b;
        System.out.println("Suma= "+ sum);*/
int x=55;
int[] table = {2,3,4};

   try {
       /*Scanner scanner = new Scanner(System.in);
       x = scanner.nextInt();*/
       System.out.println(table[3]);

   }
   catch (Exception ex) {
       System.out.println(ex.getMessage());
       System.out.println(ex.getClass().getName());
   }
        //System.out.println(x);

   /*try {
       //int i=1/0;
       day5tasks.doSth(2);
   }
                    catch (ArithmeticException ex) {
                    ex.getMessage();
                        System.out.println("Nie dziel przez 0");

                    }
   catch (Exception ex) {
                        ex.getMessage();
       System.out.println("błąd");
        }*/
        List<String> names = new LinkedList<>();
        names.add("Ola");
        names.add("Ala");
        names.add(1, "luuk");

        for(String name: names) {
            System.out.println(name);
        }
        System.out.println(names.size());
        for (int i = 0; i <names.size(); i++) {
            System.out.print(names.get(i)+" ");
        }
        System.out.println();
        names.set(2,"Alicja");
        System.out.println(names);

        List <String> newList = new ArrayList<> (
                Arrays.asList("marek", "józef", "jan", "krystian"));
        ;  // array list jako argument konstruktora
List <Integer> nums = new ArrayList<> (Arrays.asList(2,3,5,2,1,3,4));
        nums.sort(Comparator.reverseOrder());
        System.out.println("lista odwrocona: "+nums);
        int min = Collections.min(nums);
        System.out.println("wartość minimalna: "+min);
        int max = Collections.max(nums);
        System.out.println("wartość maksymalna: "+max);
        int freq3 = Collections.frequency(nums,3);
        System.out.println("Liczba 3 występuje "+freq3+" razy");
        Collections.swap(nums,1,2);
        System.out.println(nums);
        Collections.replaceAll(nums,3,2);
        System.out.println(nums);
        nums.sort(Comparator.naturalOrder());
        System.out.println(nums);

        newList.sort(Comparator.naturalOrder());
        System.out.println(newList);


        /*List<Integer> numbers = new LinkedList<>();
        List<Integer> numbers2 = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i <10000; i++) {
            numbers.add(i);
        }
        long endTime = System.currentTimeMillis();
        long duration= endTime-startTime;
        System.out.println(""+duration);


         startTime = System.currentTimeMillis();
        for (int i = 0; i <10000; i++) {
            numbers2.add(i);
        }
         endTime = System.currentTimeMillis();
         duration= endTime-startTime;
        System.out.println(duration);


         startTime = System.currentTimeMillis();
        for (int i = 0; i <10000; i++) {
            numbers.get(i);
        }
         endTime = System.currentTimeMillis();
         duration= endTime-startTime;
        System.out.println(""+duration);


         startTime = System.currentTimeMillis();
        for (int i = 0; i <10000; i++) {
            numbers2.get(i);
        }
         endTime = System.currentTimeMillis();
         duration= endTime-startTime;
        System.out.println(duration);*/

    }
}
