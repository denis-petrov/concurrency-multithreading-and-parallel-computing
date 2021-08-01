package com.exercise.ForkJoinFramework.SimpleTest;

import java.util.concurrent.ForkJoinPool;

public class App {
    
    public static void main(String[] args) {
        System.out.println("Pool with action:");
        ForkJoinPool poolWithAction = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        SimpleRecursiveAction action = new SimpleRecursiveAction(200);
        poolWithAction.invoke(action);

        System.out.println("\nPool with task:");
        ForkJoinPool poolWithTask = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        SimpleRecursiveTask task = new SimpleRecursiveTask(120);
        System.out.println(poolWithTask.invoke(task));
    }
}
