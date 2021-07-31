package com.exercise.ParallelAlgorithms.Summation;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Thread safe class, for parallel calculating sum
 * in the given array
 */
public final class ParallelSum {

    /**
     * Calculate sum in int array
     *
     * @param data            int[] given array
     * @param numberOfThreads int number of used threads
     * @return sum of all elements
     */
    public static BigInteger sum(Integer[] data, int numberOfThreads) {
        BigInteger result = BigInteger.ZERO;

        ParallelWorker[] workers = new ParallelWorker[numberOfThreads];
        int steps = (int) Math.ceil(data.length * 1.0 / numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            workers[i] = new ParallelWorker(data, i * steps, (i + 1) * steps);
            result = result.add(workers[i].call());
        }

        Arrays.stream(workers).peek(worker -> {
            try {
                worker.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return result;
    }
}
