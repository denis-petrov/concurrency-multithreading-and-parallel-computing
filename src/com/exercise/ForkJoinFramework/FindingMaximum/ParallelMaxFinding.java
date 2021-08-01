package com.exercise.ForkJoinFramework.FindingMaximum;

import java.util.concurrent.RecursiveTask;

/**
 * Parallel variant of finding max element in array
 */
public class ParallelMaxFinding<T extends Comparable<? super T>> extends RecursiveTask<T> {

    private final T[] data;
    private final int startIndex;
    private final int endIndex;

    /**
     * Ctor.
     */
    public ParallelMaxFinding(T[] data, int startIndex, int endIndex) {
        this.data = data;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    protected T compute() {
        if (startIndex - endIndex < App.THRESHOLD) {
            return SequentialMaxFinding.findMaximum(data, startIndex, endIndex);
        } else {
            int middleIndex = (startIndex + endIndex) / 2;

            ParallelMaxFinding<T> firstTask = new ParallelMaxFinding<>(data, startIndex, middleIndex);
            ParallelMaxFinding<T> secondTask = new ParallelMaxFinding<>(data, middleIndex + 1, endIndex);

            invokeAll(firstTask, secondTask);

            T firstRes = firstTask.join();
            T secondRes = secondTask.join();
            return firstRes.compareTo(secondRes) > 0 ? firstRes : secondRes;
        }
    }
}
