package pl.sda.list;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Stack<E> {
    private E[] table;
    private int last;
    //private E[] a;

    public Stack(E[] table) {
        this.table = table;
        this.last = table.length - 1;
    }
    public Stack(){
    }

    public void push(E val) {

        //a = type.cast(Array.newInstance(type.getComponentType(),last));
if (table==null) {
   E[] arr = (E[]) new Object[1];
    arr[0] = val;
    table=arr;
}
else {
    last = table.length + 1;

   E[] arr = (E[]) new Object[last];

    System.arraycopy(table, 0, arr, 0, last - 1);   // w tej metodzie zastosowalem skrocony zapis arracycopy

    arr[last - 1] = val;
    table = arr;
}
    }

    public E pop() {
        last = table.length - 1;
        E removed = table[last];
        //a = type.cast(Array.newInstance(type.getComponentType(),length));

        @SuppressWarnings("unchecked")
        E[] arr = (E[]) new Object[last];
        for (int i = 0; i < last; i++) {  // w tej metodzie zastsoowalem standardowy zapis kopiowania tablicy
            arr[i] = table[i];
        }
        table = arr;
        return removed;
    }

    public E peek() {
        return table[table.length - 1];
    }


    public void print() {
        for (E l : table) System.out.print(l + " ");
        System.out.println();
    }



    public boolean isEmpty() {
        return table.length == 0;
    }

    public void replaceAll() {

        @SuppressWarnings("unchecked")
        E[] temp = (E[]) new Object[last];

        for (int i = 0; i < last; i++) {
            temp[i] = table[last - 1 - i];
        }
        table = temp;
    }

    public boolean isPalindrome(int id) {
        String myText = table[id].toString().toLowerCase();
        for (int i = 0; i < myText.length() / 2; i++) {
            if (myText.charAt(i) != myText.charAt(myText.length() - 1 - i))
                return false;
        }
        return true;
    }

    public Stack ONPcalc () {
        String[] stack1={};
        Stack temp = new Stack(stack1);
        Pattern p = Pattern.compile("^([1-9]|[1-9][0-9])$");
        for (int i = 0; i <table.length; i++) {
            Matcher m = p.matcher(table[i].toString());
            boolean b = m.matches();
            if (b) {
                temp.push(table[i]);
            }
            if (table[i].toString()=="*") {
                int x = Integer.parseInt(temp.pop().toString());
                int y = Integer.parseInt(temp.pop().toString());
                temp.push(x*y);
            }
            if (table[i].toString()=="/"){
                int x = Integer.parseInt(temp.pop().toString());
                int y = Integer.parseInt(temp.pop().toString());
                temp.push(y/x);
            }
            if (table[i].toString()=="+") {
                int x = Integer.parseInt(temp.pop().toString());
                int y = Integer.parseInt(temp.pop().toString());
                temp.push(x+y);
            }
            }
        temp.print();
        return temp;
        }
        //zrobic z zapisu w tradycyjnej notacji do ONP
public Stack factorial (int n) {
        Stack test = new Stack();
    for (int i = 1; i <=n; i++) {
        test.push(i);
    }
    test.print();
    for (int i = 1; i <n; i++) {
        int x1 = Integer.parseInt(test.pop().toString());
        int x2 = Integer.parseInt(test.pop().toString());
        test.push(x1 + x2);
    }
    System.out.println("Silnia z "+n+" wynosi: ");
    test.print();
    return test;
}



    /* public void printChar() {
        for (char l : charTable) System.out.print(l + " ");
        System.out.println();
    }*/
}
