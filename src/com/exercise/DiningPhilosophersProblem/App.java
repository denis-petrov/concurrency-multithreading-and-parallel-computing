package com.exercise.DiningPhilosophersProblem;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class App {

    /**
     *  The aim of the simulation is that is it possible to avoid thread starvation
     *      - all of the threads are going to be executed by executor service
     *      - we are able to avoid deadlocks because we use tryLock()
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = null;
        final ArrayList<Philosopher> philosophers = new ArrayList<>(Constants.NUMBER_OF_PHILOSOPHERS);
        final ArrayList<Chopstick> chopsticks = new ArrayList<>(Constants.NUMBER_OF_CHOPSTICKS);

        try {
            executorService = Executors.newFixedThreadPool(Constants.NUMBER_OF_PHILOSOPHERS);

            for (int index = 0; index < Constants.NUMBER_OF_CHOPSTICKS; index++) {
                chopsticks.add(new Chopstick(index, new ReentrantLock()));
            }

            for (int index = 0; index < Constants.NUMBER_OF_CHOPSTICKS; index++) {
                philosophers.add(new Philosopher(index, chopsticks.get(index), chopsticks.get((index + 1) % Constants.NUMBER_OF_CHOPSTICKS)));
                executorService.execute(philosophers.get(index));
            }

            Thread.sleep(Constants.SIMULATION_RUNNING_TIME);
            executorService.shutdown();

            philosophers.forEach(philosopher -> philosopher.setFull(true));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (executorService != null) {
                executorService.shutdown();

                while (!executorService.isTerminated())
                    Thread.sleep(1000);

                philosophers.forEach(philosopher -> System.out.println(philosopher + " eat #" + philosopher.getEatingCounter() + " times"));
            }
        }
    }
}
