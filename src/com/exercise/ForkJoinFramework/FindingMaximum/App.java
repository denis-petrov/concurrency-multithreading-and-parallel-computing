package com.exercise.ForkJoinFramework.FindingMaximum;

import com.exercise.Utils.DataUtil;

import java.util.concurrent.ForkJoinPool;

public class App {

    public static int THRESHOLD = 0;

    public static void main(String[] args) {

        Integer[] data = DataUtil.generateRandomIntegerArray(10_000_000);

        long start = System.currentTimeMillis();
        System.out.println("Sequential finding of the max equals: " + SequentialMaxFinding.findMaximum(data));
        System.out.println("Time taken is: " + (System.currentTimeMillis() - start));

        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        ParallelMaxFinding<Integer> task = new ParallelMaxFinding<>(data, 0, data.length);
        start = System.currentTimeMillis();
        System.out.println("Parallel finding of the max equals: " +  pool.invoke(task));
        System.out.println("Time taken is: " + (System.currentTimeMillis() - start));
    }
}
