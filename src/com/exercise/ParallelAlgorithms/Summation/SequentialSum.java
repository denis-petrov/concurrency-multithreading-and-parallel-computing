package com.exercise.ParallelAlgorithms.Summation;

import java.math.BigDecimal;
import java.util.Arrays;

public class SequentialSum {
    public static BigDecimal sum(Integer[] data) {
        return Arrays.stream(data)
                .map(BigDecimal::valueOf)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
