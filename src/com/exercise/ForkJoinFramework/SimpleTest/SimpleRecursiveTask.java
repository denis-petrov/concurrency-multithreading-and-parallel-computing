package com.exercise.ForkJoinFramework.SimpleTest;

import java.util.concurrent.RecursiveTask;

public class SimpleRecursiveTask extends RecursiveTask<Integer> {

    private int simulatedWork;

    public SimpleRecursiveTask(int simulatedWork) {
        this.simulatedWork = simulatedWork;
    }
    @Override
    protected Integer compute() {
        if (simulatedWork > 100) {
            System.out.println("Parallel execution and split task, work: " + simulatedWork);

            SimpleRecursiveTask first = new SimpleRecursiveTask(simulatedWork / 2);
            SimpleRecursiveTask second = new SimpleRecursiveTask(simulatedWork / 2);

            first.fork();
            second.fork();

            return first.join() + second.join();
        } else {
            System.out.println("Sequential execution, work: " + simulatedWork);
            return simulatedWork;
        }
    }
}
