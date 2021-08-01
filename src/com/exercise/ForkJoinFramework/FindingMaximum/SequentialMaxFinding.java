package com.exercise.ForkJoinFramework.FindingMaximum;

/**
 * Sequential variant of finding max element in array
 */
public class SequentialMaxFinding {

    /**
     * Find maximum element in T type array, searched by full range
     * @param data T[] data
     * @return T object - max in array
     */
    public static <T extends Comparable<? super T>> T findMaximum(final T[] data) {
        return findMaximum(data, 0, data.length);
    }

    /**
     * Find maximum element in T type array, searched by segment range
     * @param data T[] data
     * @param start int start - start index of the segment for searching
     * @param end int end - end index of the segment for searching
     * @return T object - max in array
     */
    public static <T extends Comparable<? super T>> T findMaximum(final T[] data, int start, int end) {
        if (start < 0)
            start = 0;

        if (end - 1 > data.length)
            end = data.length;

        T res = data[0];
        for (int i = start; i < end; i++) {
            T currEl = data[i];
            if (res.compareTo(currEl) < 0) {
                res = currEl;
            }
        }
        return res;
    }
}
