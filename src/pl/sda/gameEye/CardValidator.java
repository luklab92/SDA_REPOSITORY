package pl.sda.gameEye;

public class CardValidator<E> {

    public CardValidator() {

    }

    private boolean isCorrectSymbol(E value) {
        return (value == CardValue.A || value == CardValue.J || value == CardValue.Q || value == CardValue.K);
    }

    private boolean isCorrectVal(E value) {
        return ((int) value >= 2 && (int) value <= 10);
    }

    public boolean isCorrect(E value) {
        return (isCorrectSymbol(value) || isCorrectVal(value));
    }
}
