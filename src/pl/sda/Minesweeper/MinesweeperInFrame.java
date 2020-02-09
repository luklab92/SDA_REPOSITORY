package pl.sda.Minesweeper;

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
    private long startTime,endTime,duration;
    private String name;

    //Constructor to start a game
    MinesweeperInFrame() {
        prepareAGame();
    }

    //game Prepraation
    private void prepareAGame() {
        JFrame window = new JFrame("Minesweeper menu");
        window.setSize(600, 250);
        JButton button = new JButton("Start a game");
        button.setBounds(100, 125, 150, 50);
        JTextField sizeField = new JTextField();
        JTextField numberOfBombsField = new JTextField();
        JTextField nameField = new JTextField();
        JLabel numberOfBombsLabel = new JLabel("Type number of bombs");
        JLabel nameLabel= new JLabel("Type your name");
        JLabel sizeLabel = new JLabel("Type a size");

        nameField.setBounds(350,50,100,50);
        nameLabel.setBounds(350,0,150,50);

        numberOfBombsField.setBounds(200, 50, 100, 50);
        numberOfBombsLabel.setBounds(175,0,150,50);

        sizeField.setBounds(50, 50, 100, 50);
        sizeLabel.setBounds(65,0,100,50);
        window.add(sizeField);
        window.add(sizeLabel);
        window.add(numberOfBombsField);
        window.add(numberOfBombsLabel);
        window.add(nameField);
        window.add(nameLabel);

        button.addActionListener(actionEvent -> {
            usersArraySize = Integer.parseInt(sizeField.getText());
            numberOfBombs = Integer.parseInt(numberOfBombsField.getText());
            name=nameField.getText();
            initPlayerArrayFrame();
        });
        window.add(button);
        window.setLayout(null);
        window.setVisible(true);
    }

    // creating empty minesweeper GridLayout
    private void initPlayerArrayFrame(){
        JFrame frame = new JFrame("Player name: " + name + "     Minesweeper game");
        filledArray = new Button[usersArraySize][usersArraySize];

        minesweeperGame = new JPanel(new GridLayout(usersArraySize, usersArraySize));
        minesweeperGame.setBounds(50,50,usersArraySize*20,usersArraySize*20);
        frame.add(minesweeperGame);
        frame.setSize(usersArraySize*20+100, usersArraySize*20+100);
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
                newButton.setSize(7,7);
                newButton.setFont(new Font("Arial", Font.PLAIN,8));
                newButton.setMargin( new Insets(5, 5, 5, 5) );
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
                loseGameStatus(button);
            } else if (isSelectedField(button) && button.getValue() == 0) {
                fillArrayWithRecursionIfYouHitZero(button);
                button.setSelected(true);
                button.setOpen(true);
                winGameStatus();
            } else if (button.getIcon()!=null) {
                button.setIcon(null);
                selectWithValue(button);
                currentNumberOfBombs--;
            }

            else if (isSelectedField(button)) {
                selectWithValue(button);
                winGameStatus();
            }
        }

        //setBomb
    private void setBomb(Button button) {
        if (numberOfBombs > currentNumberOfBombs) {
            int x = button.getWidth();
            int y = button.getHeight();
            ImageIcon icon  = new ImageIcon("C:\\Users\\lukla\\IdeaProjects\\javaWro\\src\\pl\\sda\\MinesWeeper\\flag.jpg");
            Image image = icon.getImage();
            Image newimg = image.getScaledInstance(x/2,y/2, Image.SCALE_SMOOTH);
            icon= new ImageIcon(newimg);
            button.setIcon(icon);
            //button.setText("Bomb");
            currentNumberOfBombs++;
            button.setOpen(true);
            winGameStatus();
        } else JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Nie możesz juz wstawić więcej bomb!!");
    }

    //fill selected field with text
    private void selectWithValue(Button button) {

        //ustawic wielkosc tekstu jakis error jest
        button.setSelected(true);
        button.setOpen(true);
        if (button.getValue()==0) {
            button.setText("");
            button.setEnabled(false);
        } else {
            button.setFont(new Font("Arial", Font.PLAIN,7));
            button.setText(button.getValue() +"");
            //button.setEnabled(false); ustawic niezmienialne ale nie szare
        }
    }

    //End of the game setting the field
    private void selectWithBomb(Button button) {
        int x = button.getWidth();
        int y = button.getHeight();
        ImageIcon icon  = new ImageIcon("C:\\Users\\lukla\\IdeaProjects\\javaWro\\src\\pl\\sda\\MinesWeeper\\bomb.jpg");
        Image image = icon.getImage();
        Image newimg = image.getScaledInstance(x/2,y/2, Image.SCALE_SMOOTH);
        icon= new ImageIcon(newimg);
        button.setIcon(icon);

    }

    //print numbers around zeroValue
    private void printNumbersAround(Button button) {
       int startRow;
       int startColumn;
       int endRow;
       int endColumn;

       if (moveUpPossibility(button)) startRow = button.getRow()-1;
       else startRow = button.getRow();

        if (moveDownPossibility(button)) endRow = button.getRow()+1;
        else endRow = button.getRow();

        if (moveLeftPossibility(button)) startColumn = button.getColumn()-1;
        else startColumn = button.getColumn();

        if (moveRightPossibility(button)) endColumn = button.getColumn()+1;
        else endColumn = button.getColumn();


        for (int rows =startRow; rows <= endRow; rows++) {
            for (int col = startColumn; col <= endColumn; col++) {
                if (col >= 0 && rows >= 0 && col < usersArraySize && rows < usersArraySize && filledArray[rows][col].getValue() !=-1 && !isSelectedField(filledArray[rows][col]) && filledArray[rows][col].getIcon()==null)
                    selectWithValue(filledArray[rows][col]);
            }
        }
    }

    //check statements around button
    private Boolean moveUpPossibility(Button button) {
        return button.getRow() - 1 >= 0;
    }

    private Boolean moveDownPossibility(Button button) {
        return button.getRow() + 1 < filledArray.length;
    }

    private Boolean moveRightPossibility(Button button) {
        return button.getColumn() + 1 < filledArray.length;
    }

    private Boolean moveLeftPossibility(Button button) {
        return button.getColumn() - 1 >= 0;
    }

    private Boolean isSelectedField(Button button) {
        return button.isSelected();
    }

    //checking fields around clicked field
    private boolean isVisibleAnyAround(Button button) {
        int rowOfButton = button.getRow();
        int colOfButton = button.getColumn();
        for (int i = rowOfButton - 1; i <= rowOfButton + 1; i++) {
            for (int j = colOfButton - 1; j <= colOfButton + 1; j++) {
                if (j >= 0 && i >= 0 && j < usersArraySize && i < usersArraySize) {
                    var checkButton = filledArray[i][j];
                    if (!checkButton.isOpen()) return false;
                }
            }
        }
        return true;
    }

    //Can - I - Do - Recursion method
    private boolean canDoRecursion(Button button) {
    return button.getValue() == 0 && !isVisibleAnyAround(button);
}

//recursion method to setText to all fields around zeros
    private void fillArrayWithRecursionIfYouHitZero(Button button) {
        printNumbersAround(button);
        int rowOfButton = button.getRow();
        int colOfButton = button.getColumn();
        filledArray[rowOfButton][colOfButton].setOpen(true);
            if (rowOfButton > 0) {
                int indexX = rowOfButton - 1;
                var nextButton = filledArray[indexX][colOfButton];
                if (canDoRecursion(nextButton)) fillArrayWithRecursionIfYouHitZero(nextButton);
            }
            if (colOfButton > 0) {
                int indexY = colOfButton - 1;
                var nextButton = filledArray[rowOfButton][indexY];
                if (canDoRecursion(nextButton)) fillArrayWithRecursionIfYouHitZero(nextButton);
            }
            if (rowOfButton < usersArraySize -1) {
                int indexX = rowOfButton + 1;
                var nextButton = filledArray[indexX][colOfButton];
                if (canDoRecursion(nextButton)) fillArrayWithRecursionIfYouHitZero(nextButton);
            }

            if (colOfButton < usersArraySize -1) {
                int indexY = colOfButton + 1;
                var nextButton = filledArray[rowOfButton][indexY];
                if (canDoRecursion(nextButton)) fillArrayWithRecursionIfYouHitZero(nextButton);
            }
        }

        //has all fields been revealed?
    private boolean endOfTheGame() {
        boolean endGameStatus=true;
        for (int i = 0; i < usersArraySize; i++) {
            for (int j = 0; j < usersArraySize; j++) {
                if (!filledArray[i][j].isOpen() && filledArray[i][j].getValue() != -1) {
                    endGameStatus = false;
                    break;
                }
            }
        }
        return endGameStatus;
    }

    // has all fields without bombs been revealed?
    private boolean allFieldFilledWithValues() {
        int notOpened = 0;
        for (int i = 0; i < usersArraySize; i++) {
            for (int j = 0; j < usersArraySize; j++) {
                if (!filledArray[i][j].isOpen()&& filledArray[i][j].getValue()!=-1) {
                    notOpened++;
                }
            }
        }
                return notOpened == 0;
        }

    //end of the game method
    private void winGameStatus() {
        if (endOfTheGame() || allFieldFilledWithValues()) {
            endTime = System.nanoTime();
            duration = (endTime-startTime)/1000000000;
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "You won, in time: "+duration+"s");
        }
    }

    //end Game method shows all bombs
private void showAllBombsAndMarkWrongBomb(Button button) {
    int rowOfButton = button.getWidth();
    int colOfButton = button.getHeight();
    ImageIcon bomb  = new ImageIcon("C:\\Users\\lukla\\IdeaProjects\\javaWro\\src\\pl\\sda\\MinesWeeper\\bomb.jpg");
    ImageIcon exploded  = new ImageIcon("C:\\Users\\lukla\\IdeaProjects\\javaWro\\src\\pl\\sda\\MinesWeeper\\exploded.png");
    for (int i = 0; i <usersArraySize; i++) {
        for (int j = 0; j <usersArraySize; j++) {
            if (filledArray[i][j].getValue()==-1 && !button.equals(filledArray[i][j])) {
                Image image = bomb.getImage();
                Image newimg = image.getScaledInstance(rowOfButton/2,colOfButton/2, Image.SCALE_SMOOTH);
                bomb= new ImageIcon(newimg);
                filledArray[i][j].setIcon(bomb);
            }
        }
    }
    Image image = exploded.getImage();
    Image newimg = image.getScaledInstance(rowOfButton/2,colOfButton/2, Image.SCALE_SMOOTH);
    exploded= new ImageIcon(newimg);
    button.setIcon(exploded);
}

    //lost game method
    private void loseGameStatus(Button button) {
        showAllBombsAndMarkWrongBomb(button);
        endTime=System.nanoTime();
        duration=(endTime-startTime)/1000000000;
        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "You lost, in time: "+duration+"s");
    }
}