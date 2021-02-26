package com.datastructure.stack;

/**
 * TODO:Add Your Description
 *
 * @Author Sun
 * @Date 2021-02-26 08:35:00
 */
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
