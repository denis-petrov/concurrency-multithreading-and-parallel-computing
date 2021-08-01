package com.exercise.ForkJoinFramework.SimpleTest;

import java.util.concurrent.RecursiveAction;

public class SimpleRecursiveAction extends RecursiveAction {

    private int simulatedWork;

    public SimpleRecursiveAction(int simulatedWork) {
        this.simulatedWork = simulatedWork;
    }

    @Override
    protected void compute() {
        if (simulatedWork > 100) {
            System.out.println("Parallel execution and split task, work: " + simulatedWork);

            SimpleRecursiveAction first = new SimpleRecursiveAction(simulatedWork / 2);
            SimpleRecursiveAction second = new SimpleRecursiveAction(simulatedWork / 2);

            first.compute();
            second.compute();
        } else {
            System.out.println("Sequential execution, work: " + simulatedWork);
        }
    }
}
