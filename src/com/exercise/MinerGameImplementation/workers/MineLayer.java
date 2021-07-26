package com.exercise.MinerGameImplementation.workers;

import com.exercise.MinerGameImplementation.constants.Constants;
import com.exercise.MinerGameImplementation.view.Board;

import java.util.Random;

public class MineLayer implements Runnable {
    private int id;
    private Board board;
    private volatile boolean layerRunning;

    public MineLayer(int id, Board board) {
        this.id = id;
        this.board = board;
        this.layerRunning = true;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (layerRunning) {
            if (Thread.currentThread().isInterrupted())
                break;

            int index = random.nextInt(Constants.BOARD_ROWS * Constants.BOARD_COLUMNS);
            board.setMine(index);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isLayerRunning() {
        return layerRunning;
    }

    public void setLayerRunning(boolean layerRunning) {
        this.layerRunning = layerRunning;
    }
}
