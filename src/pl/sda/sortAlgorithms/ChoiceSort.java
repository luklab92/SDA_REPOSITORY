package pl.sda.sortAlgorithms;


import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ChoiceSort implements SortAlgorithm{


    public <E>List<E> sort (List<E> items, Comparator<E> comparator) {
        List<E> myData = new LinkedList<>(items);
        int index;
        E min;
        for (int i = 0; i <myData.size(); i++) {
            index=i;
            for (int j = i+1; j <myData.size(); j++) {
                if (comparator.compare(myData.get(j),myData.get(index))<0) {
                    index=j;
                }

            }
            min = myData.get(index);
            myData.set(index,myData.get(i));
            myData.set(i,min);
        }
        return myData;
    }

    public List<String> sortString (List<String> items) {
        List<String> myData= new LinkedList<>();
        myData.addAll(items);
        int index;
        String min;
        for (int i = 0; i <myData.size(); i++) {
            index=i;
            for (int j = i+1; j <myData.size(); j++) {
                if (myData.get(j).equals(myData.get(index))) {
                    index=j;
                }
            }
            min = myData.get(index);
            myData.set(index,myData.get(i));
            myData.set(i,min);
        }
        return myData;
    }

    @Override
    public String sayHello() {
        return "Choice sort";
    }

}
