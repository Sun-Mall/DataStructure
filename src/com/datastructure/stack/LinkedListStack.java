package com.datastructure.stack;

import com.datastructure.linkedlist.LinkedList;

/**
 * TODO:Add Your Description
 *
 * @Author Sun
 * @Date 2021-02-26 08:37:00
 */
public class LinkedListStack<E> implements Stack<E>  {

    private LinkedList<E> list;

    public LinkedListStack(){
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void push(E e) {

    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }
}
