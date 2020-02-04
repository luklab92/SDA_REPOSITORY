package pl.sda.MinesWeeper;

import lombok.var;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MinesweeperInFrame {
    private int usersArraySize;
    private int numberOfBombs;
    private Button[][] filledArray;
    private int currentNumberOfBombs;
    private JPanel minesweeperGame;
    private JFrame frame;
    private long startTime,endTime,duration;

    //Constructor to start a game
    MinesweeperInFrame() {
        prepareAGame();
        this.frame = new JFrame("Minesweeper");
    }

    //game Prepraation
    private void prepareAGame() {
        JFrame window = new JFrame("Minesweeper menu");
        window.setSize(400, 250);
        JButton button = new JButton("Start a game");
        button.setBounds(100, 125, 150, 50);
        JTextField sizeField = new JTextField();
        JTextField numberOfBombsField = new JTextField();
        JLabel sizeLabel = new JLabel("Type a size");
        sizeLabel.setBounds(50,0,100,50);
        window.add(sizeLabel);
        JLabel numberOfBombsLabel = new JLabel("Type number of bombs");
        numberOfBombsLabel.setBounds(175,0,150,50);
        window.add(numberOfBombsLabel);
        sizeField.setBounds(50, 50, 100, 50);
        numberOfBombsField.setBounds(200, 50, 100, 50);
        window.add(sizeField);
        window.add(numberOfBombsField);
        button.addActionListener(actionEvent -> {
            usersArraySize = Integer.parseInt(sizeField.getText());
            numberOfBombs = Integer.parseInt(numberOfBombsField.getText());
            initPlayerArrayFrame();
        });
        window.add(button);
        window.setLayout(null);
        window.setVisible(true);

    }

    // creating empty minesweeper GridLayout
    private void initPlayerArrayFrame(){
        filledArray = new Button[usersArraySize][usersArraySize];
        minesweeperGame = new JPanel(new GridLayout(usersArraySize, usersArraySize));
        minesweeperGame.setBounds(0,80,1385,755);
        frame.add(minesweeperGame);
        frame.setSize(1400, 900);
        printUI();
        createCompletedArray();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
        startTime = System.nanoTime();
    }

    //fill gridLayout with buttons
    private void printUI(){
        for (int rows = 0; rows < filledArray.length; rows++) {
            for (int cols = 0; cols <filledArray.length; cols++) {
                var newButton = new Button(rows,cols);
                newButton.addActionListener(e-> showField(newButton));
                newButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            setBomb(newButton);
                    }
                }
                });
                minesweeperGame.add(newButton);
                filledArray[rows][cols] = newButton;
            }
        }
    }

    //random bomb maker value
    private boolean statementForMakeBombs() {
        return Math.random() > 0.98;
    }

    //bomb maker
    private void makeBombs() {
        int counter = 0;
        while (counter < numberOfBombs) {
            for (int i = 0; i < usersArraySize; i++) {
                for (int j = 0; j < usersArraySize; j++) {
                    if (statementForMakeBombs() && counter < numberOfBombs && filledArray[i][j].getValue()!=-1) {
                        filledArray[i][j].setValue(-1);
                        counter++;
                    }
                }
            }
        }
    }

    //init array - filling with "0"
    private void createCompletedArray() {
        for (int i = 0; i < usersArraySize; i++) {
            for (int j = 0; j < usersArraySize; j++) {
                filledArray[i][j].setValue(0);
            }
        }
        makeBombs();
        fillCompletedArrayWithNumbers();
    }

    //setValues to correct values
    private void fillCompletedArrayWithNumbers() {
        for (int i = 0; i < usersArraySize; i++) {
            for (int j = 0; j < usersArraySize; j++) {
                if (filledArray[i][j].getValue()==-1) {
                    for (int k = i - 1; k <= i + 1; k++) {
                        for (int l = j - 1; l <= j + 1; l++) {
                            if (l >= 0 && k >= 0 && l < usersArraySize && k < usersArraySize && filledArray[k][l].getValue() != -1) {
                                int x = filledArray[k][l].getValue() + 1;
                                filledArray[k][l].setValue(x);
                            }
                        }
                    }
                }
            }
        }
    }

    //Actions when you click a button
    private void showField(Button button) {
            if (button.getValue() == -1) {
                selectWithBomb(button);
                loseGameStatus();
            } else if (isSelectedCell(button) && button.getValue() == 0) {
                fillArrayWithRecursionIfYouHitZero(button);
                button.setSelected(true);
                button.setRevealed(true);

                if (endOfTheGame()) {
                    winGameStatus();
                }
            } else if (button.getText().equals("Bomb")) {
                selectWithValue(button);
                currentNumberOfBombs--;
            }

            else if (isSelectedCell(button)) {
                selectWithValue(button);
                winGameStatus();
            }
        }

        //setBomb
    private void setBomb(Button button) {
        if (numberOfBombs > currentNumberOfBombs) {
            //button.setIcon(new ImageIcon("C:\\Users\\lukla\\IdeaProjects\\javaWro\\src\\pl\\sda\\MinesWeeper\\Bomb.jpg"));
            button.setText("Bomb");
            currentNumberOfBombs++;
            button.setRevealed(true);
            winGameStatus();
        } else System.out.println("Nie możesz juz wstawić więcej bomb!!");
    }

    //fill selected field with text
    private void selectWithValue(Button button) {
        button.setSelected(true);
        button.setRevealed(true);
        if (button.getValue()==0) {
            button.setText("");
            button.setEnabled(false);
        } else {
            button.setText(button.getValue() +"");
        }
    }


    //End of the game setting the field
    private void selectWithBomb(Button button) {
        button.setText("Explosion");
    }

    //print numbers around zeroValue
    private void printNumbersAround(Button button) {
       int startRow;
       int startColumn;
       int endRow;
       int endColumn;

       if (canGoUp(button)) startRow = button.getRow()-1;
       else startRow = button.getRow();

        if (canGoDown(button)) endRow = button.getRow()+1;
        else endRow = button.getRow();

        if (canGoLeft(button)) startColumn = button.getColumn()-1;
        else startColumn = button.getColumn();

        if (canGoRight(button)) endColumn = button.getColumn()+1;
        else endColumn = button.getColumn();


        for (int rows =startRow; rows <= endRow; rows++) {
            for (int col = startColumn; col <= endColumn; col++) {
                if (col >= 0 && rows >= 0 && col < usersArraySize && rows < usersArraySize && filledArray[rows][col].getValue() !=-1 && !filledArray[rows][col].getText().equals("Bomb")&& !isSelectedCell(filledArray[rows][col]))
                    selectWithValue(filledArray[rows][col]);

            }
        }
    }

    //check statements around button
    private Boolean canGoUp(Button button) {
        return button.getRow() - 1 >= 0;
    }

    private Boolean canGoDown(Button button) {
        return button.getRow() + 1 < filledArray.length;
    }

    private Boolean canGoRight(Button button) {
        return button.getColumn() + 1 < filledArray.length;
    }

    private Boolean canGoLeft(Button button) {
        return button.getColumn() - 1 >= 0;
    }

    private Boolean isSelectedCell(Button button) {
        return button.isSelected();
    }

    //checking fields around clicked field
    private boolean isVisibleAnyAround(Button button) {
        int x = button.getRow();
        int y = button.getColumn();
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (j >= 0 && i >= 0 && j < usersArraySize -1 && i < usersArraySize -1) {
                    var checkButton = filledArray[i][j];
                    if (checkButton.isRevealed()) return false;
                }
            }
        }
        return true;
    }

    //Can - I - Do - Recursion method
    private boolean canDoRecursion(Button button) {
    return !isVisibleAnyAround(button) && button.getValue() == 0 && !isSelectedCell(button);
}

//recursion method to setText to all fields around zeros
    private void fillArrayWithRecursionIfYouHitZero(Button button) {
        selectWithValue(button);
        printNumbersAround(button);
        int x = button.getRow();
        int y = button.getColumn();
            if (x > 0) {
                int indexX = x - 1;
                var nextButton = filledArray[indexX][y];
                if (canDoRecursion(nextButton)) fillArrayWithRecursionIfYouHitZero(nextButton);
            }
            if (y > 0) {
                int indexY = y - 1;
                var nextButton = filledArray[x][indexY];
                if (canDoRecursion(nextButton)) fillArrayWithRecursionIfYouHitZero(nextButton);
            }
            if (x < usersArraySize -1) {
                int indexX = x + 1;
                var nextButton = filledArray[indexX][y];
                if (canDoRecursion(nextButton)) fillArrayWithRecursionIfYouHitZero(nextButton);
            }

            if (y < usersArraySize -1) {
                int indexY = y + 1;
                var nextButton = filledArray[x][indexY];
                if (canDoRecursion(nextButton)) fillArrayWithRecursionIfYouHitZero(nextButton);
            }
            if (x > 0 && y > 0) {
                int indexX = x - 1;
                int indexY = y - 1;
                var nextButton = filledArray[indexX][indexY];
                if (canDoRecursion(nextButton)) fillArrayWithRecursionIfYouHitZero(nextButton);
            }
            if (x > 0 && y < usersArraySize -1) {
                int indexX = x - 1;
                int indexY = y + 1;
                var nextButton = filledArray[indexX][indexY];
                if (canDoRecursion(nextButton)) fillArrayWithRecursionIfYouHitZero(nextButton);
            }
            if (x < usersArraySize -1 && y > 0) {
                int indexX = x + 1;
                int indexY = y - 1;
                var nextButton = filledArray[indexX][indexY];
                if (canDoRecursion(nextButton)) fillArrayWithRecursionIfYouHitZero(nextButton);
            }
            if (x < usersArraySize -1 && y < usersArraySize -1) {
                int indexX = x + 1;
                int indexY = y + 1;
                var nextButton = filledArray[indexX][indexY];
                if (canDoRecursion(nextButton)) fillArrayWithRecursionIfYouHitZero(nextButton);
            }
        }

        //has all fields been revealed?
    private boolean endOfTheGame() {
        for (int i = 0; i < usersArraySize; i++) {
            for (int j = 0; j < usersArraySize; j++) {
                if (!filledArray[i][j].isRevealed()) return false;
            }
        }
        return true;
    }

    //end of the game method
    private void winGameStatus() {
        if (endOfTheGame()) {
            endTime = System.nanoTime();
            duration = (endTime-startTime)/1000000000;
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "You won, in time: "+duration+"s");
        }
    }

    //lost game method
    private void loseGameStatus() {
        endTime=System.nanoTime();
        duration=(endTime-startTime)/1000000000;
        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "You lost, in time: "+duration+"s");
    }
}

 /*private void fillArrayWithRecursionIfYouHitZero(Button button) {
        button.setSelected(true);
        printNumbersAround(button);
        if (canGoRight(button)) {
            var nextButton = filledArray[button.getRow()][button.getColumn() +1];
            if (!isSelectedCell(nextButton) && nextButton.getValue() ==0)
                fillArrayWithRecursionIfYouHitZero(nextButton);
            }
        if (canGoLeft(button)) {
            var nextButton = filledArray[button.getRow()][button.getColumn() -1];
            if (!isSelectedCell(nextButton) && nextButton.getValue() ==0)
                fillArrayWithRecursionIfYouHitZero(nextButton);
        }
        if (canGoUp(button)) {
            var nextButton = filledArray[button.getRow()-1][button.getColumn()];
            if (!isSelectedCell(nextButton) && nextButton.getValue() ==0)
                fillArrayWithRecursionIfYouHitZero(nextButton);
        }
        if (canGoDown(button)) {
            var nextButton = filledArray[button.getRow()+1][button.getColumn()];
            if (!isSelectedCell(nextButton) && nextButton.getValue() ==0)
                fillArrayWithRecursionIfYouHitZero(nextButton);
        }
    }*/