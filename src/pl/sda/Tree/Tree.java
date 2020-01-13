package pl.sda.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Tree {

private List<Integer> ints= new LinkedList<>(
        Arrays.asList(9,8,7,5,6,5,6,4,3,1,2,1,3)
);

    public int returnRoot() {
        return ints.get(0);
    }

    public List<Integer> returnChildrens(int n) {
        List<Integer> childrens = new LinkedList<>();
        childrens.add(ints.get(2*n+1));
        childrens.add(ints.get(2*n+2));
        return childrens;
    }
    public List<Integer> ints() {
        List<Integer> templist = new LinkedList<>();
        for (int i = 0; i <ints.size(); i++) {
            if (2*i+1>ints.size()) templist.add(ints.get(i));
        }
        return templist;
    }
    public List<Integer> ex4() {
        List<Integer> templist = new LinkedList<>();
        int x = 1;
        templist.add(ints.get(0));
        while (x < ints.size()) {
            templist.add(ints.get(x));
            x=2*x+1;
        }
        return templist;
    }

}

