package com.datastructure.utils;

import com.datastructure.InsertionSort;
import com.datastructure.SelectionSort;

/**
 * TODO:Description
 *
 * @Author Sun
 * @Date 2021-02-18 20:02
 */
public class SortingHelper {

    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortName, E[] arr) {
        long startTime = System.nanoTime();
        if (sortName == "SelectionSort") {
            SelectionSort.sort(arr);
        }
        if (sortName == "InsertionSort") {
            InsertionSort.newSort(arr);
        }
        long endTime = System.nanoTime();
        double time = (endTime-startTime)/1000000000.0;
        if (!SortingHelper.isSorted(arr)){
            throw new RuntimeException("Sort failed");
        }
        System.out.println(sortName+" n="+arr.length+" : "+time+"s");
    }
}
