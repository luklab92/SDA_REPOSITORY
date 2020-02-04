package pl.sda.MinesWeeper;

import javax.swing.*;

public class Button extends JToggleButton {
    private int value;
    private final int row;
    private final int column;
    private boolean revealed;

    public Button(int row, int column) {
        super();
        this.row=row;
        this.column=column;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }

}
