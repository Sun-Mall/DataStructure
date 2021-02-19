package com.datastructure;

import com.datastructure.utils.ArrayGenerator;
import com.datastructure.utils.SortingHelper;

/**
 * 插入排序法
 *
 * @Author Sun
 * @Date 2021-02-19 07:43:00
 */
public class InsertionSort {

    /**
     * 循环不变量：
     * <p>
     * arr[0...i)是有序的；arr[i...n)是无序的
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            /*for (int j = i; j - 1 >= 0; j--) {
                if (arr[j].compareTo(arr[j - 1])<0) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }*/

            for (int j = i; j - 1 >= 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    public static <E extends Comparable<E>> void newSort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            E temp = arr[i];
            int j;
            for (j = i; j - 1 >= 0 && temp.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    /**
     * 交换数组中两个元素的位置
     *
     * @param arr 需要进行交换的数组
     * @param i   数组原位置
     * @param j   数组需要交换的位置
     */
    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
//        Integer[] arr = {5, 1, 3, 6, 4, 2, 10, 7, 8};
//        sort(arr);
//        for (int e : arr) {
//            System.out.println(e);
//        }
        Integer[] arr = ArrayGenerator.generateRandomArray(10000, 100000);
        SortingHelper.sortTest("InsertionSort", arr);
    }
}
