package pl.sda.list;

import pl.sda.programowanie1.SortAlgorithm;

import java.util.Comparator;
import java.util.Iterator;

public class MyLinkedList <E> implements myList<E>{
    private Node head;
    private Node last;
    private Node previous;
    //private Node next;


    public MyLinkedList(E value) {
        this.head = new Node(value,null,null);
        this.last = head; // tutaj zapisujemy pierwszy element, pierwszy element jest zarownjo head jak i last
        this.previous = null;
        //this.next =null;
    }

    public class Node<E>{
        E value;
        Node next;
        Node previous;

        public Node(E value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous=previous;
        }
    }

    //Metody z intefejsu
    @Override
    public E get(int id) {
        Node actual = head;
        int counter = 0;
        while (counter!=id) {
            actual=actual.next;
            counter++;
        }
        return (E)actual.value;
    }

    @Override
    public void add(E value) {
        Node newNodeToAdd = new Node(value,null,last);
        this.last.next = newNodeToAdd;
        this.last = newNodeToAdd;
    }

    @Override
    public int size() {
        Node actual = head;
        int elementsNumber=0;
        while (actual !=null) {
            actual=actual.next;
            elementsNumber++;
        }
        return elementsNumber;
    }

    @Override
    public boolean isEmpty() {
        Node actual= head;
        return (actual==null);
    }

    @Override
    public boolean isSorted(Comparator<E> comparator) {
        Node actual=head;

        while(actual.next !=null) {
            if (comparator.compare((E) actual,(E) actual.next) < 0) return false;
            actual = actual.next;
        }
        return true;
    }


      /*  while(actual!=null) {
            if ((int)previous.value < (int)actual.previous.value) {
                return false;
            }
            actual=actual.next;
        }
        return true;
    }*/

    @Override
    public void remove(E data) {
        Node actual = head;

        if (actual!= null && actual.value==data && actual.next == head){
            head=actual.next;
            System.out.println("Value was first");

        }
        while (actual != null && actual.value != data) {
            previous = actual;
            actual = actual.next;
        }
        if (actual != null && actual.value ==data) {
            previous.next = actual.next;
            System.out.println("Value was in the middle");
        }

        if (actual == null) {
            System.out.println("Nothing happened");
        }
    }

    @Override
    public boolean exist(E value) {
        Node actualElement = head;
        while (actualElement !=null)
            if (actualElement.value ==value)
                return true;
            else
                actualElement = actualElement.next;
        return false;
    }


    //POZOSTALE METODY
public void set(int value, int index) {
        Node actual = head;
        int counter =0;
        while (counter!=index){
            actual=actual.next;
            counter++;
        }
        actual.value=value;
    System.out.println("Zmieniono wartość na pozycji: "+index+" na: "+value);
}

public void removeAll(E data) {
        Node actual = head;
        while (actual != null && actual.value !=data) {
            previous = actual;
            actual=actual.next;
            }
        while (actual!=null && actual.value==data) {
            previous.next = actual.next;
            actual=actual.next;
        }
}

    public void print (){
        Node actual = head;
        while (actual.next!=null){
            System.out.print(actual.value+" ");
            actual = actual.next;
        }
        System.out.print(actual.value);
        System.out.println();
    }

}
