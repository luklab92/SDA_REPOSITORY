package pl.sda.gameEye;

import java.util.LinkedList;
import java.util.List;

public class CreateStack {

    public static List<Card> createCardStack() {
        List<Card> cards = new LinkedList<>();
        Type[] types = Type.values();
        CardValue[] values = CardValue.values();
        for (Type type : types) {
            for (int j = 2; j <= 10; j++) {
                cards.add(new Card(type, j));
            }
            for (CardValue value : values) {
                cards.add(new Card(type, value));
            }
        }
        return cards;
    }
}
