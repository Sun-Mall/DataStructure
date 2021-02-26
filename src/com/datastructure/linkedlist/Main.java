package com.datastructure.linkedlist;

/**
 * TODO:Add Your Description
 *
 * @Author Sun
 * @Date 2021-02-26 08:20:00
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList= new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(666,2);
        System.out.println(linkedList);
    }
}
