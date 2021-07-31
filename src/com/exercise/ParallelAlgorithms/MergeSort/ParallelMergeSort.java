package com.exercise.ParallelAlgorithms.MergeSort;

public final class ParallelMergeSort extends SequentialMergeSort {

    public static <T extends Comparable<? super T>> void sort(T[] array, int start, int end, int numberOfThreads) {
        if (numberOfThreads <= 1) {
            sort(array, start, end);
            return;
        }

        int middle = (start + end) / 2;

        Thread leftSorter = sortParallel(array, start, middle, numberOfThreads);
        Thread rightSorter = sortParallel(array, middle + 1, end, numberOfThreads);

        leftSorter.start();
        rightSorter.start();

        try {
            leftSorter.join();
            rightSorter.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static <T extends Comparable<? super T>> Thread sortParallel(T[] array, int start, int end, int numberOfThreads) {
        return new Thread(() -> sort(array, start, end, numberOfThreads / 2));
    }
}
