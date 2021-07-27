package com.exercise.MinerGameImplementation.app;


import com.exercise.MinerGameImplementation.constants.Constants;
import com.exercise.MinerGameImplementation.view.Board;
import com.exercise.MinerGameImplementation.view.ButtonListener;
import com.exercise.MinerGameImplementation.workers.MineLayer;
import com.exercise.MinerGameImplementation.workers.MineSweeper;
import javafx.scene.control.ToolBar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainFrame extends JFrame implements ButtonListener {

    public static final long serialVersionUID = 1L;
    private final ToolBar toolBar;
    private final Board board;
    private ExecutorService layersExecutor;
    private ExecutorService sweepersExecutor;
    private ArrayList<MineLayer> mineLayers = new ArrayList<MineLayer>();
    private ArrayList<MineSweeper> mineSweepers = new ArrayList<MineSweeper>();


    public MainFrame() {
        super(Constants.APP_NAME);

        toolBar = new ToolBar();
        board = new Board();

        add(toolBar, BorderLayout.NORTH);
        add(board, BorderLayout.CENTER);

        setSize(Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void startClicked() {
        layersExecutor = Executors.newFixedThreadPool(Constants.NUMBER_OF_LAYERS);
        sweepersExecutor = Executors.newFixedThreadPool(Constants.NUMBER_OF_SWEEPERS);

        try {
            for (int index = 0; index < Constants.NUMBER_OF_LAYERS; index++) {
                mineLayers.add(new MineLayer(index, board));
                layersExecutor.execute(mineLayers.get(index));
            }

            for (int index = 0; index < Constants.NUMBER_OF_SWEEPERS; index++) {
                mineSweepers.add(new MineSweeper(index, board));
                sweepersExecutor.execute(mineSweepers.get(index));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            layersExecutor.shutdown();
            sweepersExecutor.shutdown();
        }
    }

    @Override
    public void stopClicked() {
        mineLayers.forEach(mineLayer -> mineLayer.setLayerRunning(false));
        mineSweepers.forEach(mineSweeper -> mineSweeper.setSweeperRunning(false));

        layersExecutor.shutdown();
        sweepersExecutor.shutdown();

        try {
            layersExecutor.awaitTermination(1, TimeUnit.MINUTES);
            sweepersExecutor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        layersExecutor.shutdownNow();
        sweepersExecutor.shutdownNow();

        board.clearBoard();
    }
}
