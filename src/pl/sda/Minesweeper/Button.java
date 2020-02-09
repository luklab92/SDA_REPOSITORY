package pl.sda.Minesweeper;

import javax.swing.*;

public class Button extends JToggleButton {
    private int value;
    private final int row;
    private final int column;
    private boolean isOpen;

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

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        this.isOpen = open;
    }

}
