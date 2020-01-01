package pl.sda.list;

import java.util.ArrayList;
import java.util.List;

public class Queue <T> {
    private List<T> list;
    int priority;

    public Queue(List<T> list) {
        this.list = list;
    }

    public void enqueue(T elem){
        list.add(elem);
    }
    public T peek (int elem) {
        return list.get(elem);
    }
    public void print() {
        System.out.println(list);
    }
    public void change() {
        //T temp = list.get(0);
            list.add(list.get(0));
            list.remove(list.get(0));
        }
    }
