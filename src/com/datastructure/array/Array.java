package com.datastructure.array;

/**
 * 数组
 * 数组中的重要概念：索引
 * 优点：快速查询(数组最好应用于“索引有语义”的情况)
 *
 * @Author Sun
 * @Date 2021-02-23 22:30:00
 */
public class Array<E> {

    /**
     * 用于保存数组数据
     */
    private E[] data;

    /**
     * 数组大小
     */
    private int size;

    /**
     * 数组扩容
     * @param newCapacity 扩容后的容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 构造函数
     *
     * @param capacity 数组的容量
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 构造函数，默认容量为10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组中元素的个数
     *
     * @return 数组中的元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组容量
     *
     * @return 数组容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 数组是否为空
     *
     * @return True or False
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在所有元素前添加一个元素
     *
     * @param e 需要添加的元素
     */
    public void addFirst(E e) {
        add(0, e);
        size++;
    }

    /**
     * 向所有元素后添加一个新元素
     *
     * @param e 要添加的元素
     */
    public void addLast(E e) {

        if (size == data.length) {
            throw new IllegalArgumentException("AddList failed. Array is full.");
        }
        data[size] = e;
        size++;
    }

    /**
     * 在指定位置插入元素
     *
     * @param index 需要插入元素的位置
     * @param e     待插入元素
     */
    public void add(int index, E e) {
        if (size == data.length) {
            resize(2 * data.length);
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index < size");
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }

    /**
     * 获取元素
     *
     * @param index 需要获取元素的位置
     * @return 元素的值
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }


    /**
     * 修改数组特定位置的元素值
     *
     * @param index 要修改的位置
     * @param e     修改的元素
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否包含某个元素
     *
     * @param e 需要查找的元素
     * @return True or False
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找元素索引
     *
     * @param e 要查找的元素
     * @return 元素索引，若元素不存在返回-1
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除第一个元素
     *
     * @return 要删除的元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素
     *
     * @return 要删除的元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除某个特定元素
     *
     * @param e 要删除的元素
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 从数组中删除元素
     *
     * @param index 需要删除的元素的位置
     * @return 删除的元素
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        return ret;
    }

    /**
     * 输入数组信息
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array size = %d ,capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();

    }
}
