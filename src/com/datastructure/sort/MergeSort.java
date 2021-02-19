package com.datastructure.sort;

import com.datastructure.utils.ArrayGenerator;
import com.datastructure.utils.SortingHelper;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @Author Sun
 * @Date 2021-02-19 22:24:00
 */
public class MergeSort {

    private MergeSort() {
    }

    /**
     * 归并排序
     *
     * @param arr 需要排序的数组
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * 对数组特定区间进行归并排序
     *
     * @param arr 需要排序的数组
     * @param l   左边索引
     * @param r   右边索引
     */
    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        // 取中间值（防止越界）
        int mid = l + (r - l) / 2;

        // 对arr[l,mid]进行归并排序
        sort(arr, l, mid);

        // 对arr[mid,r]进行归并排序
        sort(arr, mid + 1, r);

        // 合并排序
        merge(arr, l, mid, r);

    }

    /**
     * 合并两个有序区间 arr[l,mid] 和 arr[mid,r]
     *
     * @param arr 需要进行合并的数组
     * @param l   左边区间起始索引
     * @param mid 中间索引
     * @param r   右边区间终止索引
     */
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {

        /**
         * 复制需要合并的数组
         *
         * 注意：
         *  Arrays.copyOfRange是前闭后开区间
         */
        E[] tempArr = Arrays.copyOfRange(arr, l, r + 1);
        int i = l, j = mid + 1;

        // 每轮循环为arr[k]复制
        for (int k = l; k <= r; k++) {

            if (i > mid) {
                // 若左边元素越界，则取右边区间元素
                arr[k] = tempArr[j - l];
                j++;
            } else if (j > r) {
                // 若右边元素越界，则取左边区间元素
                arr[k] = tempArr[i - l];
                i++;
            } else if (tempArr[i - l].compareTo(tempArr[j - l]) <= 0) {
                // 若左边区间第一个元素小于等于右边区间第一个元素，则取左边区间第一个元素
                arr[k] = tempArr[i - l];
                i++;
            } else {
                // 否则，取右边区间第一个元素
                arr[k] = tempArr[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = ArrayGenerator.generateRandomArray(1000000, 100000000);
        SortingHelper.sortTest("MergeSort", arr);
        /*int[] arr = {1, 4, 6, 7, 3, 5, 9};
        sort(integers, 0, integers.length - 1);
        for (int a : arr) {
            System.out.println(a);
        }*/
    }
}
