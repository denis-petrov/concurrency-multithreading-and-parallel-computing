package com.exercise.ForkJoinFramework.MergeSort;

import java.util.Arrays;

public final class SequentialMergeSort {

    public static <T extends Comparable<? super T>> T[] sort(T[] data) {
        if (data.length <= 1)
            return data;

        int middleIndex = data.length / 2;

        T[] leftSubarray = Arrays.copyOfRange(data, 0, middleIndex);
        T[] rightSubarray = Arrays.copyOfRange(data, middleIndex, data.length);

        return merge(data, sort(leftSubarray), sort(rightSubarray));
    }

    public static <T extends Comparable<? super T>> T[] merge(T[] data, final T[] leftSubarray, final T[] rightSubarray) {
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while (leftIndex < leftSubarray.length && rightIndex < rightSubarray.length)
            data[resultIndex++] = (leftSubarray[leftIndex].compareTo(rightSubarray[rightIndex]) < 0)
                    ? leftSubarray[leftIndex++]
                    : rightSubarray[rightIndex++];

        while (leftIndex < leftSubarray.length)
            data[resultIndex++] = leftSubarray[leftIndex++];

        while (rightIndex < rightSubarray.length)
            data[resultIndex++] = rightSubarray[rightIndex++];

        return data;
    }

}
