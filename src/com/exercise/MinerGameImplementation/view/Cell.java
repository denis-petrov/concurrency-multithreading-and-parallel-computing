package com.exercise.MinerGameImplementation.view;

import com.exercise.MinerGameImplementation.constants.State;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cell extends JPanel {

    public static final long serialVersionUID = 1L;
    private int id;
    private Lock lock = new ReentrantLock();
    private State state = State.EMPTY;
    private boolean hasBomb = false;

    public Cell(int id) {
        this.id = id;
        setLayout(new GridLayout());
    }

    public void lock() {
        try {
            lock.tryLock(10, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void unlock() {
        lock.unlock();
    }



    @Override
    public String toString() {
        return "Cell{" +
                "id=" + id +
                ", lock=" + lock +
                ", state=" + state +
                ", hasBomb=" + hasBomb +
                '}';
    }
}
