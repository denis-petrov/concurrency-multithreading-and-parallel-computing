package com.exercise.MinerGameImplementation.workers;

import com.exercise.MinerGameImplementation.constants.Constants;
import com.exercise.MinerGameImplementation.view.Board;

import java.util.Random;

public class MineSweeper implements Runnable {
    private int id;
    private final Board board;
    private volatile boolean sweeperRunning;

    public MineSweeper(int id, Board board) {
        this.id = id;
        this.board = board;
        this.sweeperRunning = true;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (sweeperRunning) {
            if (Thread.currentThread().isInterrupted())
                break;

            int index = random.nextInt(Constants.BOARD_ROWS * Constants.BOARD_COLUMNS);
            board.sweepMine(index);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isSweeperRunning() {
        return sweeperRunning;
    }

    public void setSweeperRunning(boolean sweeperRunning) {
        this.sweeperRunning = sweeperRunning;
    }
}
