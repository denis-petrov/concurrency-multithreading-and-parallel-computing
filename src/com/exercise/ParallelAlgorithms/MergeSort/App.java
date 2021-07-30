package com.exercise.ParallelAlgorithms.MergeSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        Random random = new Random();

        List<Integer> data = new ArrayList<>();
        data.add(10);
        data.add(-1);
        data.add(2);
        data.add(5);
        data.add(0);
        data.add(-12);

        /*Double[] arrayOfDoubles = {0.35, 0.02, 0.36, 0.82, 0.27, 0.49, 0.41, 0.17, 0.30, 0.89, 0.37, 0.66, 0.82, 0.17, 0.20, 0.96, 0.18, 0.25, 0.37, 0.52};
        MergeSort.sort(arrayOfDoubles, 0, arrayOfDoubles.length - 1);
        System.out.println(java.util.Arrays.toString(arrayOfDoubles));*/


        MergeSort.sort(data, 0, data.size());
        System.out.println(data);
    }
}
