package com.exercise.ParallelAlgorithms.Summation;

import com.exercise.ParallelAlgorithms.DataUtil;

public class App {

    public static void main(String[] args) {
        Integer[] data = DataUtil.generateRandomIntegerArray(10_000_000);

        long startTime = System.currentTimeMillis();
        System.out.println(SequentialSum.sum(data));
        System.out.println("Sequential sum takes: " + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        System.out.println(ParallelSum.sum(data, Runtime.getRuntime().availableProcessors()));
        System.out.println("Parallel sum takes: " + (System.currentTimeMillis() - startTime) + "ms");
    }
}
