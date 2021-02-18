package com.datastructure.utils;

import java.util.Random;

/**
 * 自动生成数组
 *
 * @Author Sun
 * @Date 2021-02-18 19:56
 */
public class ArrayGenerator {

    /**
     * 生成一个长度为n的随机数组，数组长度的为n,数组的值为（0，bound）
     *
     * @param n     数组长度
     * @param bound 随机生成的最大值
     * @return 数组
     */
    public static Integer[] generateRandomArray(int n, int bound) {
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }
}
