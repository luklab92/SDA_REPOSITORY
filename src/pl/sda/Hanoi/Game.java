package pl.sda.Hanoi;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Game {

    private List<Stack<Integer>> listOfStacks = new LinkedList<>();
    private int lowerBarrier, upperBarrier;

    private void createStacks() {
        for (int i = 1; i <=3; i++) {
            Stack<Integer> stack = new Stack<>();
            listOfStacks.add(stack);
        }
    }

    private void addElementsToStack(int init) {
        createStacks();
        for (int i = init; i >0; i--) {
            listOfStacks.get(0).add(i);
        }
    }
    private void prepareAGame(int init) {
        addElementsToStack(init);
    }

    private boolean enfOfTheGameCheck (int init) {
        int lastTower = 2;
        return (listOfStacks.get(lastTower).size() !=init);
    }

    private boolean isMoveCorrect(int to, int from) {
        return (to < 1 || to > 3 || from < 1 || from > 3);
    }

    private void userMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type Stack 1-3");
        System.out.println(listOfStacks);
        System.out.println("Get number from Stack");
        lowerBarrier = scanner.nextInt();
        System.out.println("Give number into Stack");
        upperBarrier = scanner.nextInt();
    }

    public void playAGame(int init) {
        int counter = 0;
        prepareAGame(init);
        long startTime = System.nanoTime();
        while (enfOfTheGameCheck(init)) {
            userMove();
            if (isMoveCorrect(upperBarrier, lowerBarrier)) {
                System.out.println("Type correct value");
            } else {
                int peekValue = listOfStacks.get(lowerBarrier - 1).peek();
                listOfStacks.get(upperBarrier - 1).add(peekValue);
                if (isStackCorrect(upperBarrier - 1)) {
                    listOfStacks.get(lowerBarrier - 1).pop();
                    System.out.println(listOfStacks);
                } else {
                    listOfStacks.get(upperBarrier - 1).pop();
                    System.out.println("You cannot do this move");
                }
                counter++;
            }
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("You won, number of steps " + counter + " in time: " + duration / 1000000000 + "s");
    }

    private boolean isStackCorrect(int index) {
        Stack<Integer> temp = listOfStacks.get(index);

        if (temp.size() > 1) {
            return temp.get(temp.size() - 1) < temp.get(temp.size() - 2);
        }
        return true;
    }
}