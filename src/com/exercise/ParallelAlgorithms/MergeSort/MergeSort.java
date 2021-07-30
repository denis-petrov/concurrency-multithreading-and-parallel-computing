package com.exercise.ParallelAlgorithms.MergeSort;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public final class MergeSort {

    public static <T extends Comparable<? super T>> void sort(List<T> array, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;

            sort(array, start, middle);
            sort(array, middle + 1, end);
            merge(array, start, middle, end);
        }
    }

    public static <T extends Comparable<? super T>> void merge(List<T> array, int start, int middle, int end) {
        List<T> leftArray = new ArrayList<>();
        IntStream.range(0, middle - start + 1)
                .forEach(i -> leftArray.add(i, array.get(start + i)));

        List<T> rightArray = new ArrayList<>();
        IntStream.range(0, end - middle)
                .forEach(i -> rightArray.add(i, array.get(middle + 1 + i)));


        int leftIndex = 0, rightIndex = 0;
        int currentIndex = start;
        while (leftIndex < leftArray.size() && rightIndex < rightArray.size()) {
            if (leftArray.get(leftIndex).compareTo(rightArray.get(rightIndex)) <= 0) {
                array.add(currentIndex, leftArray.get(leftIndex));
                leftIndex++;
            } else {
                array.add(currentIndex, rightArray.get(rightIndex));
                rightIndex++;
            }
            currentIndex++;
        }

        while (leftIndex < leftArray.size())
            array.add(currentIndex++, leftArray.get(leftIndex++));

        while (rightIndex < rightArray.size())
            array.add(currentIndex++, rightArray.get(rightIndex++));
    }

}
