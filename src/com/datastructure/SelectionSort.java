package com.datastructure;

/**
 * 选择排序
 *
 * @Author Sun
 * @Date 2021-02-18 19:31
 */
public class SelectionSort {

    /**
     * 选择排序
     *
     * @param arr 需要进行排序的数组
     */
    public static void sort(Integer[] arr) {
        /**
         * 循环不变量：
         *
         * arr[0...i)是有序的；arr[i...n)是无序的
         */
        for (int i = 0; i < arr.length; i++) {

            // 选择arr[i...n)中最小值得索引
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // 交换arr[i]和arr[minIndex]的位置
            swap(arr, i, minIndex);
        }
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {

            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            // 交换arr[i]和arr[minIndex]的位置
            swap(arr, i, minIndex);
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
        Integer[] arr = {5, 1, 3, 6, 4, 2};
        sort(arr);
        for (int e : arr) {
            System.out.println(e);
        }
    }
}
