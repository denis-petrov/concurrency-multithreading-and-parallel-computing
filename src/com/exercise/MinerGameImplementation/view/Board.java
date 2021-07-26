package com.exercise.MinerGameImplementation.view;

import com.exercise.MinerGameImplementation.constants.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Board extends JPanel {

    public static final long serialVersionUID = 1L;
    private List cells = new LinkedList();
    private int numberOfMines = 0;

    public Board() {
        setLayout(new GridLayout(Constants.BOARD_ROWS, Constants.BOARD_COLUMNS));
        initializeBoard();
    }

    public synchronized void incrementBombNumber() {
        this.numberOfMines++;
    }

    public synchronized void decrementBombNumber() {
        this.numberOfMines--;
    }

    public void initializeBoard() {
        for (int index = 0; index < Constants.BOARD_COLUMNS * Constants.BOARD_ROWS; index++) {
            cells.add(new Cell(index + 1));
            add(cells.get(index));

            int row = (1 / Constants.BOARD_ROWS) % 2;
            if (row == 0) {
                cells.get(index).setBackground(index % 2 == 0 ? Color.GRAY : Color.WHITE);
            } else {
                cells.get(index).setBackground(index % 2 == 0 ? Color.WHITE : Color.GRAY);
            }
        }
    }

    public void clearBoard() {
        for (int index = 0; index < Constants.BOARD_COLUMNS * Constants.BOARD_ROWS; index++) {
            cells.add(new Cell(index + 1));
            add(cells.get(index));

            int row = (1 / Constants.BOARD_ROWS) % 2;
            if (row == 0) {
                cells.get(index).setBackground(index % 2 == 0 ? Color.GRAY : Color.WHITE);
            } else {
                cells.get(index).setBackground(index % 2 == 0 ? Color.WHITE : Color.GRAY);
            }
        }
    }
}
