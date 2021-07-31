package com.exercise.ParallelAlgorithms.MergeSort;

import com.exercise.ParallelAlgorithms.DataUtil;

public class App {

    public static void main(String[] args) {
        int numOfThreads = Runtime.getRuntime().availableProcessors();

        System.out.println("Number of threads/cores: " + numOfThreads);
        System.out.println("");

        Integer[] dataForParallelSort = DataUtil.generateRandomIntegerArray(10000000);
        Integer[] dataForSequentialSort = new Integer[dataForParallelSort.length];
        System.arraycopy(dataForParallelSort, 0, dataForSequentialSort, 0, dataForParallelSort.length);

        long startTime = System.currentTimeMillis();
        ParallelMergeSort.sort(dataForParallelSort, 0, dataForParallelSort.length - 1, numOfThreads);
        long endTime = System.currentTimeMillis();

        System.out.printf("Time taken for 1 000 000 elements parallel =>  %6d ms \n", endTime - startTime);
        System.out.println("");

        startTime = System.currentTimeMillis();
        SequentialMergeSort.sort(dataForSequentialSort, 0, dataForSequentialSort.length - 1);
        endTime = System.currentTimeMillis();

        System.out.printf("Time taken for 1 000 000 elements sequential =>  %6d ms \n", endTime - startTime);
        System.out.println("");

    }

}
