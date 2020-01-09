package pl.sda.gameEye;
import java.util.*;

public class Card<E> {
    private Type type;
    private E value;

    public E getValue() {
        return value;
    }

    public Type getType() {
        return type;
    }

    public Card(Type type, E value) {
        new CardValidator<E>().isCorrect(value);
        this.type = type;
        this.value = value;
    }

    public int getVal() {
        int val;
        if (value == CardValue.A) val = 11;
        else if (value == CardValue.J) val = 2;
        else if (value == CardValue.Q) val = 3;
        else if (value == CardValue.K) val = 4;
        else if ((int) value == 9) val = 0;
        else val = (int) value;
        return val;
    }

    public List<Card> create() {
        return CreateStack.createCardStack();
    }

    @Override
    public String toString() {
        return "Card{" +
                value + "," + type +
                '}';
    }
}
