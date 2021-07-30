package com.exercise.ParallelAlgorithms.MergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        Random random = new Random();

        List<Integer> data = new ArrayList<>();
        IntStream.range(0, 10)
                .forEach(i -> data.add(i, random.nextInt()));

        System.out.println(data);
    }
}
