package pl.sda.Hanoi;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

 class MyStack {

    private List<Stack<Integer>> listOfStacks = new LinkedList<>();

    private void createStacks() {
        for (int i = 1; i <=3; i++) {
            Stack<Integer> stack = new Stack<>();
            listOfStacks.add(stack);
        }
    }

     void addElementsToStack() {
        createStacks();
        for (int i = 5; i >0; i--) {
            listOfStacks.get(0).add(i);
        }
    }
     List<Stack<Integer>> getListOfStacks() {
        return listOfStacks;
    }

}
