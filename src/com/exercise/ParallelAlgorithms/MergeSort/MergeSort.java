package com.exercise.ParallelAlgorithms.MergeSort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public final class MergeSort {

    public static <T> void sort(List<T> data, Comparator<T> comparator) {
        if (data.isEmpty()) throw new IllegalArgumentException("Input data is null.");
        if (data.size() < 2) return;

        int median = data.size() / 2;
        int leftSize = median;
        int rightSize = data.size() - median;

        List<T> left = new ArrayList<>();
        IntStream.range(0, leftSize)
                .forEach(l -> left.add(l, data.get(l)));

        List<T> right = new ArrayList<>();
        IntStream.range(0, rightSize)
                .forEach(r -> right.add(r, data.get(leftSize + r)));

        sort(left, comparator);
        sort(right, comparator);

        merge(data, left, right, comparator);
    }

    private static <T> void merge(List<T> data, List<T> left, List<T> right, Comparator<T> comparator) {
        int leftIndex = 0;
        int rightIndex = 0;
        int sortedIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (comparator.compare(left.get(leftIndex), right.get(rightIndex)) <= 0) {
                data.add(sortedIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                data.add(sortedIndex, right.get(rightIndex));
                rightIndex++;
            }
            sortedIndex++;
        }

        while (leftIndex < left.size()) {
            data.add(sortedIndex, left.get(leftIndex));
            leftIndex++;
            sortedIndex++;
        }

        while (rightIndex < right.size()) {
            data.add(sortedIndex, right.get(rightIndex));
            rightIndex++;
            sortedIndex++;
        }
    }
   /*
    public void run(int low, int high) {
        if (low >= high)
            return;

        int middle = (low + high) / 2;

        run(low, middle);
        run(middle + 1, high);
        merge(low, middle, high);
    }

    public void print() {
        for (T datum : data) {
            System.out.println(datum.toString() + " ");
        }
    }

    public boolean isSorted() {
        return IntStream.range(0, data.size())
                .noneMatch(i -> data.get(i).compareTo(data.get(i + 1)) > 0);
    }

    private void merge(int low, int middle, int high) {
        for (int index = low; index <= high; index++) {
            tempData.add(index, data.get(index));
        }

        int lhsIndex = low;
        int rhsIndex = middle + 1;
        int resIndex = high;

        while ((lhsIndex <= middle) && (resIndex <= high)) {
            if (tempData.get(lhsIndex).compareTo(tempData.get(rhsIndex)) < 0) {
                data.add(resIndex, tempData.get(lhsIndex));
                lhsIndex++;
            } else {
                data.add(resIndex, tempData.get(rhsIndex));
                rhsIndex++;
            }
            resIndex++;
        }

        while (lhsIndex <= middle) {
            data.add(resIndex, tempData.get(lhsIndex));
            resIndex++;
            lhsIndex++;
        }

        while (rhsIndex <= high) {
            data.add(resIndex, tempData.get(rhsIndex));
            resIndex++;
            rhsIndex++;
        }
    }*/
}
