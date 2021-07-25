package com.exercise.DiningPhilosophersProblem;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;


public class Chopstick {

    private final int id;
    private final Lock lock;

    /**
     * Ctor.
     *
     * @param id   int value
     * @param lock Lock value
     */
    public Chopstick(final int id, final Lock lock) {
        this.id = id;
        this.lock = lock;
    }

    /**
     * Try to pick up chopstick
     *
     * @param philosopher Philosopher philosopher
     * @param state       State state
     * @throws InterruptedException If fails
     */
    public boolean pickUp(final Philosopher philosopher, final State state) throws InterruptedException {
        if (lock.tryLock(10, TimeUnit.MILLISECONDS)) {
            System.out.println(philosopher + " picked up " + state.toString() + " " + this);
            return true;
        }
        return false;
    }

    /**
     * Put down the chopstick and unlock it lock
     *
     * @param philosopher Philosopher philosopher
     */
    public void putDown(final Philosopher philosopher, final State state) {
        lock.unlock();
        System.out.println(philosopher + " picked down "  + state.toString() + " " + this);
    }

    @Override
    public String toString() {
        return "Chopstick{" +
                "id=" + id +
                ", lock=" + lock +
                '}';
    }
}
