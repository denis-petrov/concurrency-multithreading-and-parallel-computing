package com.exercise.StudentLibrarySimulation;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class App {

    public static void main(String[] args) {

        ArrayList<Student> students = null;
        ArrayList<Book> books = null;
        ExecutorService executorService = Executors.newFixedThreadPool(Constants.NUMBER_OF_STUDENTS);

        try {

            books = new ArrayList<>(Constants.NUMBER_OF_BOOKS);
            students = new ArrayList<>(Constants.NUMBER_OF_BOOKS);

            for (int index = 0; index < Constants.NUMBER_OF_BOOKS; index++) {
                books.add(new Book(index, new ReentrantLock()));
            }

            for (int index = 0; index < Constants.NUMBER_OF_STUDENTS; index++) {
                students.add(new Student(index, books));
                executorService.execute(students.get(index));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
