package com.exercise.ParallelAlgorithms.MergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MergeSort<T extends Comparable<? super T>> {
    private List<T> data;
    private List<T> tempData;

    public MergeSort(List<T> data) {
        this.data = data;
        tempData = new ArrayList<>();
    }

    public void run(int low, int high) {
        if (low >= high)
            return;

        int middle = (low + high) / 2;

        run(low, middle);
        run(middle + 1, high);
        merge(low, middle, high);
    }

    public void print() {
        System.out.println(data.toString());
    }

    public boolean isSorted() {
        return IntStream.range(0, data.size())
                .noneMatch(i -> data.get(i).compareTo(data.get(i + 1)) > 0);
    }

    private void merge(int low, int middle, int high) {
        for (int index = low; index < high; index++) {
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
    }
}
