package pl.sda.sortAlgorithms;

import java.util.LinkedList;
import java.util.List;

public class ChoiceSort implements SortAlgorithm{

    public List<Integer> sort (List<Integer> items) {
        List<Integer> myData= new LinkedList<>();
        myData.addAll(items);
        int index,min;
        for (int i = 0; i <myData.size(); i++) {
            index=i;
            for (int j = i+1; j <myData.size(); j++) {
                if (myData.get(j)<myData.get(index)) {
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
