package com.datastructure;

/**
 * 线性查找法
 *
 * @Author Sun
 * @Date 2021-02-18 10:51
 */
public class LinearSearch {

    /**
     * 从数组中查找特定值元素
     *
     * @param data   目标数组
     * @param target 需要查找的元素
     * @return 目标元素所在数组中的索引，若未找到元素，则返回-1
     */
    public static int search(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从泛型数组中查找特定值元素
     *
     * @param data   目标数组
     * @param target 需要查找的元素
     * @param <T>    泛型类
     * @return 目标元素所在数组中的索引，若未找到元素，则返回-1
     */
    public static <T> int search(T[] data, T target) {
        for (int i = 0; i < data.length; i++) {

            /** 判断类对象相等需要使用equals方法
             * 1. ==
             * 基本数据对象：使用==比较的是他们的值
             * 引用数据类型：使用==比较的是他们在内存中的存放地址(堆内存地址)
             * 2. equals
             * 初始默认行为是比较对象的内存地址值,但可通过重写此方法来进行自定义比较
             */
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = {24, 18, 12, 9, 16, 66, 32, 4};
        int result = LinearSearch.search(data, 99);
        System.out.println(result);
    }
}
