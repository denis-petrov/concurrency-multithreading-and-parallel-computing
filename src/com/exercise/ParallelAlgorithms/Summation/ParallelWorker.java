package com.exercise.ParallelAlgorithms.Summation;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * Thread safe class, for calculating sum
 * in the given segment of some array
 */
public class ParallelWorker extends Thread implements Callable<BigInteger> {

    private final Integer[] data;
    private final int low;
    private final int high;

    /**
     * Ctor.
     */
    public ParallelWorker(Integer[] data, int low, int high) {
        this.data = data;
        this.low = low;
        this.high = high;
    }

    @Override
    public BigInteger call() {
        BigInteger result = BigInteger.ZERO;
        for (int i = low; i < high; i++) {
            result = result.add(BigInteger.valueOf(data[i]));
        }
        return result;
    }
}
