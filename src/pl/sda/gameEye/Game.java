package pl.sda.gameEye;

import java.util.*;

public class Game {
    private Stack<Card> stack = new Stack();
    private List<Card> list = new LinkedList<>();
    private List<Card> removed = new LinkedList<>();
    private List<Card> tail = CreateStack.createCardStack();
    private List<Integer> scorees = new LinkedList<>();
    private List<Integer> temp = new LinkedList<>();
    private List<Integer> temp2 = new LinkedList<>();
    private Queue players = new LinkedList<>();
    private int value;
    private int choice;
    private int numberOfPlayers;

    private Stack<Card> shuffle() {
        List<Card> shuffle = CreateStack.createCardStack();
        Collections.shuffle(shuffle);
        for (Card c : shuffle) {
            stack.push(c);
        }
        return stack;
    }

    private void generateCardsForPlayer() {
        if (stack.size() > 1) {
            list.removeAll(list);
            if (stack.size() > 0) {
                Card card = stack.pop();
                Card card1 = stack.pop();
                list.add(card);
                tail.removeIf(x -> x.getValue() == card.getValue() && x.getType() == card.getType());
                list.add(card1);
                tail.removeIf(x -> x.getValue() == card1.getValue() && x.getType() == card1.getType());
                getValue();
                System.out.println("Twoje karty na ręce: " + list);
                System.out.println("Liczba zgromadzonych oczek: " + value);
                System.out.println("Pozostało kart: " + stack.size());
            }
        }

    }

    private void nextCard() {
        if (stack.size() > 0) {
            Card temp = stack.pop();
            tail.removeIf(x -> x.getValue() == temp.getValue() && x.getType() == temp.getType());
            list.add(temp);
            value = 0;
            for (Card card : list) {
                value += card.getVal();
            }
            System.out.println("Biorę kartę");
            System.out.println("Twoje karty na ręce: " + list);

            System.out.println("Liczba zgromadzonych oczek: " + value);
            isValueMoreThan21(list.size() - 1);
        }
    }

    private int getValue() {
        value = 0;
        value = list.get(0).getVal() + list.get(1).getVal();
        return value;
    }

    private int isValueMoreThan21(int n) {
        value = 0;
        for (int i = 0; i <= n; i++) {
            value = value + list.get(i).getVal();
        }
        return value;
    }

    private void printChoice() {
        System.out.println("0 - Pozostaw");
        System.out.println("1 - Dobierz karte");
        Scanner scanner2 = new Scanner(System.in);
        choice = scanner2.nextInt();
    }

    private void restCards() {
        if (stack.size() > 0) {
            double numberOfAvailableCards = 0;
            generateCardsForPlayer();
            for (Card card : tail) {
                if (21 - getValue() >= card.getVal())
                    numberOfAvailableCards++;
            }
            while (numberOfAvailableCards / tail.size() > 0.5 && isValueMoreThan21(list.size() - 1) <= 17 && stack.size() > 0)
                nextCard();
        }
    }

    private void printComputer() {
        System.out.println();
        System.out.println("Teraz gra mądry komputer");
        restCards();
        removed.addAll(list);
    }

    private void printScores() {

        if (scorees.size() == players.size()+1) {
            if (temp.size() == 0) {
                for (int i = 0; i < scorees.size(); i++) {
                    temp.add(i, 0);
                }
            }
            temp2.addAll(scorees);
            int closest = 0;
            for (Integer i : temp2) {
                if (i <= 21) {
                    if ((21 - i) < 21 - closest) closest = i;
                }
            }
            for (int i = 0; i < temp2.size(); i++) {
                if (temp2.get(i) == closest) temp2.set(i, 1);
                else temp2.set(i, 0);
            }
            for (int i = 0; i < temp2.size(); i++) {
                temp2.set(i, temp.get(i) + temp2.get(i));
            }
            for (int i = 0; i < temp.size(); i++) {
                temp.set(i, temp2.get(i));
            }
            /*for (int i = 0; i < temp.size(); i++) {
                scorees.set(i, 0);
            }*/
            temp2.removeAll(temp2);
        }
    }

    private void showScore() {
        System.out.println("TABLICA WYNIKÓW");
        System.out.print(players + " Computer");
        System.out.println();
        System.out.println(scorees);
        printScores();
        System.out.println(temp);
    }

    private void printWinner() {
        List<String> winners = new LinkedList<>();
        System.out.println();
        System.out.println("//////KONIEC GRY /////////");
        System.out.println("TABLICA WYNIKÓW");
        System.out.print("[");
        for (Object i : players) System.out.print(i + " ");
        System.out.print("Computer]");
        System.out.println();
        System.out.println(temp);
        int largest = 0;
        for (Integer integer : temp) {
            if (integer > largest) largest = integer;
        }
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i) == largest && i < numberOfPlayers) winners.add("Player" + (i + 1) + " ");
            else if (i == numberOfPlayers && temp.get(i) == largest) {
                winners.add("Computer ");
                break;
            }
        }
        System.out.println("Wygrał " + winners);
    }

    private void prepareAGame() {
        stack = shuffle();
        System.out.println("Podaj liczbę graczy");
        Scanner scanner = new Scanner(System.in);
        numberOfPlayers = scanner.nextInt();
        for (int i = 1; i <= numberOfPlayers; i++) {
            players.add(i);
            scorees.add(i - 1, 0);
        }
    }

    public void playAGame() {
        prepareAGame();
        int counter=1;
        while (stack.size() > 1) {
            System.out.println("Player " + players.peek());
            players.add(players.peek());
            players.remove();
            generateCardsForPlayer();
            while (value <= 21) {
                printChoice();
                if (choice == 1) {
                    System.out.println(value);
                    nextCard();
                    if (value > 21) {
                        if ((int) players.peek() != 1) {
                            System.out.println(value);
                            removed.addAll(list);
                            scorees.set(counter - 1, value);
                            if (counter < numberOfPlayers) counter++;
                        } else {
                            scorees.set(counter - 1, value);
                            counter++;
                            printComputer();
                            if (scorees.size() == numberOfPlayers+1) {
                                System.out.println("counter: "+counter);
                                scorees.set(scorees.size() - 1, value);
                            } else {
                                scorees.add(scorees.size(), value);
                            }
                            showScore();
                        }
                        break;
                    }
                } else if (choice == 0 || value > 21) {
                    System.out.println("counter: "+counter);
                    scorees.set(counter - 1, value);
                    removed.addAll(list);

                    if (counter < numberOfPlayers) counter++;
else counter=1;
                    if ((int) players.peek() == 1) {
                        counter++;
                        printComputer();
                        if (scorees.size() == numberOfPlayers+1) {
                            System.out.println("counter: "+counter);
                            scorees.set(scorees.size() - 1, value);
                        } else {
                            System.out.println("counter: "+counter);
                            scorees.add(scorees.size(), value);
                        }
                        counter=1;
                        System.out.println(scorees);
                        showScore();
                    }
                    break;
                }
            }
        }
        printWinner();
    }
}
