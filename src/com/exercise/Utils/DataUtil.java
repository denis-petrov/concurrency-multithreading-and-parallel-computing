package com.exercise.Utils;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Helper class for generate some data
 */
public final class DataUtil {

    /**
     * Generate array of Integer with random values
     *
     * @param size int size of result array
     * @return filled array with random Integer values
     */
    public static Integer[] generateRandomIntegerArray(int size) {
        Random random = new Random(size);
        return IntStream.generate(() -> Math.abs(random.nextInt(size)))
                .limit(size)
                .boxed()
                .toArray(Integer[]::new);
    }
}
