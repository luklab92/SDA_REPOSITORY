package pl.sda.list;

import pl.sda.programowanie1.GenericPair;

import java.util.*;

public class Main {

    public static void main(String[] args) {


        MyLinkedList mylist = new MyLinkedList(2);
        System.out.println("Czy lista jest pusta? "+mylist.isEmpty());
        mylist.add(5);
        mylist.add(3);
        mylist.add(4);
        mylist.print();
        System.out.println("Czy wartość znajduje się w liście? "+mylist.exist(4));
        mylist.remove(5);
        mylist.print();
        System.out.println("Pobierz 3ci element listy: "+mylist.get(2));
        System.out.println("Liczba elementów listy: "+mylist.size());
        System.out.println("Czy lista jest pusta? "+mylist.isEmpty());
        mylist.print();
        mylist.set(3,1);
        mylist.print();
        System.out.println(mylist.isSorted((x,y)->1));
       // mylist.removeAll(4);
        mylist.print();



        List<String> testList = new ArrayList<>(
                Arrays.asList("anna", "ada", "kasia")
        );
        String[] tab = {"Anna", "Kasia", "Basia"};


        Stack stack = new Stack(tab);
        stack.push("zosia");
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.peek());
        stack.print();
        stack.push(2);
        stack.print();
        System.out.println("Czy stos jest pusty: "+stack.isEmpty());
        stack.replaceAll();
        stack.print();
        System.out.println("Czy element jest palindromem? "+stack.isPalindrome(1));

        String[] ONP = {"12","2","3","4","*","10","5","/","+","*","+"};
        Stack ONPstack = new Stack(ONP);
        ONPstack.print();
        ONPstack.ONPcalc();
        Stack fact = new Stack();

        fact.factorial(10);

        GenericPair pair = new GenericPair("Anna", 5);
        System.out.println(pair.getFirst()+" "+pair.getSecond());

        Queue que = new Queue(testList);
        que.enqueue("aga");
        que.print();
        que.change();
        que.print();
        mylist.print();
        System.out.println(mylist.isSorted((x,y)->1));
myTable tab1 = new myTable();
        System.out.println("Czy jest pusta: "+tab1.isEmpty());
tab1.add("ada");
tab1.add("ania");
        System.out.println(tab1.get(1));
        tab1.printAll();
        tab1.add(2);
        tab1.printAll();
        tab1.remove("ania");
        tab1.printAll();
        System.out.println("Czy jest pusta: "+tab1.isEmpty());
        System.out.println("Rozmiar tablicy: "+tab1.size());
        System.out.println("Czy element 2 istnieje?: "+tab1.exist(2));

    }


}
