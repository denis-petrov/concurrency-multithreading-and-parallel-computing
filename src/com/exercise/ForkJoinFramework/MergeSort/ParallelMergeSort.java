package com.exercise.ForkJoinFramework.MergeSort;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public final class ParallelMergeSort<T extends Comparable<? super T>> extends RecursiveAction {

    private final T[] data;

    public ParallelMergeSort(T[] data) {
        this.data = data;
    }

    @Override
    protected void compute() {
        if (data.length < 10) {
            SequentialMergeSort.sort(data);
            return;
        }

        int middleIndex = data.length / 2;

        T[] leftSubarray = Arrays.copyOfRange(data, 0, middleIndex);
        T[] rightSubarray = Arrays.copyOfRange(data,middleIndex + 1, data.length);

        ParallelMergeSort leftTask = new ParallelMergeSort(leftSubarray);
        ParallelMergeSort rightTask = new ParallelMergeSort(rightSubarray);

        invokeAll(leftTask, rightTask);

        SequentialMergeSort.merge(data, leftSubarray, rightSubarray);
    }
}
