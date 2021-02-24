package com.datastructure.array;

import com.datastructure.array.Array;

/**
 * main
 *
 * @Author Sun
 * @Date 2021-02-23 22:31:00
 */
public class Main {
    public static void main(String[] args) {
        Array array = new Array(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        array.add(1,100);
        System.out.println(array);
    }
}
