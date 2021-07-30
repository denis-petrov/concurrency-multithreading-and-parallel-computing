package com.exercise.ParallelAlgorithms.MergeSort;

import java.util.stream.IntStream;

public final class MergeSort {

    public static <T extends Comparable<? super T>> void sort(T[] array, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;

            sort(array, start, middle);
            sort(array, middle + 1, end);
            merge(array, start, middle, end);
        }
    }

    public static <T extends Comparable<? super T>> void merge(T[] array, int start, int middle, int end) {
        T[] leftArray = (T[]) new Comparable[middle - start + 1];
        IntStream.range(0, leftArray.length).forEach(i -> leftArray[i] = array[start + i]);

        T[] rightArray = (T[]) new Comparable[end - middle];
        IntStream.range(0, rightArray.length).forEach(i -> rightArray[i] = array[middle + 1 + i]);

        int leftIndex = 0, rightIndex = 0;
        int currentIndex = start;
        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex].compareTo(rightArray[rightIndex]) <= 0) {
                array[currentIndex] = leftArray[leftIndex];
                leftIndex++;
            } else {
                array[currentIndex] = rightArray[rightIndex];
                rightIndex++;
            }
            currentIndex++;
        }

        while (leftIndex < leftArray.length)
            array[currentIndex++] = leftArray[leftIndex++];

        while (rightIndex < rightArray.length)
            array[currentIndex++] = rightArray[rightIndex++];
    }

}
