package pl.sda.Hanoi;

import java.util.Scanner;
import java.util.Stack;

public class Game {
    private MyStack myStack = new MyStack();
    private long startTime;


    private void prepareAGame(int init) {
        myStack.addElementsToStack(init);
    }

    public void doAction(int init) {
        prepareAGame(init);
        int from,to;
        int counter =0;
        while (myStack.getListOfStacks().get(2).size() != init) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Type Stack 1-3");
            System.out.println(myStack.getListOfStacks());
            System.out.println("Get number from Stack");
            from = scanner.nextInt();
                System.out.println("Give number into Stack");
                to = scanner.nextInt();
                if (to < 1 || to >3 || from < 1 || from > 3) {
                    System.out.println("Podaj prawidłową wartość");
                }else {
                    int temp = myStack.getListOfStacks().get(from - 1).peek();
                    myStack.getListOfStacks().get(to - 1).add(temp);
                    if (isStackCorrect(to - 1)) {
                        myStack.getListOfStacks().get(from - 1).pop();
                        System.out.println(myStack.getListOfStacks());
                    } else {
                        myStack.getListOfStacks().get(to - 1).pop();
                        System.out.println("Nie można wykonać operacji");
                    }
                    counter++;
                }
            startTime = System.nanoTime();
                }
        long endTime = System.nanoTime();
        long duration = endTime-startTime;
        System.out.println("Wygrałeś, liczba kroków " + counter+ " w czasie: "+duration/1000000+"s");
            }



    private boolean isStackCorrect(int index) {
Stack<Integer> temp = myStack.getListOfStacks().get(index);

        if (temp.size()>1) {
            return temp.get(temp.size()-1) < temp.get(temp.size()-2);
        }
        return true;
    }
}
