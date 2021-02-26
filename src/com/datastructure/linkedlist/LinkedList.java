package com.datastructure.linkedlist;

/**
 * 链表
 *
 * @Author Sun
 * @Date 2021-02-25 23:13:00
 */
public class LinkedList<E> {

    /**
     * 节点
     */
    private class Node {

        /**
         * 节点中的元素
         */
        public E e;

        /**
         * 下一个节点
         */
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyead;
    int size;

    public LinkedList() {
        dummyead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 在链表的特定位置插入元素
     * 1. 定义prev=head
     * 2. 遍历[prev,index-1),找到待插入节点的前一个节点
     * 3. 新建一个节点，其元素为e,next为prev.next
     * 4. 修改prev.next=node
     *
     * @param e     要插入的元素
     * @param index 要插入的索引
     */
    public void add(E e, int index) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index < size");
        }

        Node prev = dummyead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

            /*Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;*/

        prev.next = new Node(e, prev.next);

        size++;
    }

    public void addFirst(E e) {
        /*Node node = new Node(e);
        node.next = head;
        head = node;*/

//        head = new Node(e, head);
//        size++;
        add(e, 0);
    }

    /**
     * 在链表的末尾添加元素
     *
     * @param e 需要添加的元素
     */
    public void addLast(E e) {
        add(e, size);
    }

    /**
     * 获取特定index 的元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index < size");
        }

        Node cur = dummyead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index < size");
        }

        Node cur = dummyead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e){
        Node cur =dummyead.next;
        while (cur!=null){
            if (cur.e.equals(e)){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }

    public E remove(int index){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index < size");
        }

        Node prev = dummyead;
        for (int i = 0; i < index; i++) {
            prev=prev.next;
        }

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next=null;

        size--;
        return retNode.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    @Override
    public String toString() {
        StringBuilder res =new StringBuilder();
        Node cur =dummyead.next;
        while (cur!=null){
            res.append(cur+"->");
            cur=cur.next;
        }
        res.append("Null");
        return res.toString();
    }
}
