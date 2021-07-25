package com.exercise.StudentLibrarySimulation;

import java.util.ArrayList;
import java.util.Random;

public class Student implements Runnable {

    private int id;
    private ArrayList<Book> books;

    /**
     * Ctor.
     *
     * @param id   int value
     * @param books ArrayList<Book> books
     */
    public Student(int id, ArrayList<Book> books) {
        this.id = id;
        this.books = books;
    }

    @Override
    public void run() {

        Random random = new Random();

        while (true) {
            int bookId = random.nextInt(Constants.NUMBER_OF_BOOKS);

            try {
                books.get(bookId).read(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", books=" + books +
                '}';
    }
}
