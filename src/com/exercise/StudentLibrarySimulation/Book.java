package com.exercise.StudentLibrarySimulation;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Book {

    private int id;
    private Lock lock;

    /**
     * Ctor.
     *
     * @param id   int value
     * @param lock Lock value
     */
    public Book(int id, Lock lock) {
        this.id = id;
        this.lock = lock;
    }

    /**
     * Given student try to read this book
     *
     * @param student Student student
     */
    public void read(final Student student) throws InterruptedException {
        lock.tryLock(1, TimeUnit.MINUTES);
        System.out.println(student + " stats reading " + this);
        Thread.sleep(2000);
        lock.unlock();
        System.out.println(student + " has finished reading " + this);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", lock=" + lock +
                '}';
    }
}
