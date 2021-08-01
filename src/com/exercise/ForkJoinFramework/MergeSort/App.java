package com.exercise.ForkJoinFramework.MergeSort;

import com.exercise.Utils.DataUtil;

import java.util.concurrent.ForkJoinPool;

public class App {

    public static void main(String[] args) {
        Integer[] data = DataUtil.generateRandomIntegerArray(10_000_000);

        long start = System.currentTimeMillis();
        SequentialMergeSort.sort(data);
        System.out.println("Sequential merge sort taken: " + (System.currentTimeMillis() - start));

        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        ParallelMergeSort task = new ParallelMergeSort(data);
        start = System.currentTimeMillis();
        pool.invoke(task);
        System.out.println("Parallel merge sort taken: " + (System.currentTimeMillis() - start));
    }
}
