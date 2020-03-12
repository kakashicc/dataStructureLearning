package com.daojia.datastructures.learn.datastructure.a06_linkedlist;

/**
 * @Author: maosen
 * @Description: 有哨兵节点的单链表
 * @Date: Created in 2020/3/11 17:30.
 */
public class MySingleLinkedList02<T> {

    /**
     * 头节点
     */
    private Node<T> head;

    /**
     * 链表长度
     */
    private int size;

    public MySingleLinkedList02() {
        head = new Node(null,null);
    }

    /**
     * 获取当前元素个数
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 判断数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取index位置元素
     *
     * @param index
     * @return
     */
    public T get(int index) {
        checkIndex(index);
        int nowIndex = 0;
        Node<T> node = this.head.next;
        while (nowIndex < index) {
            node = node.next;
            nowIndex++;
        }
        return node.data;
    }

    /**
     * 设置index位置元素
     *
     * @param index
     * @return oldValue
     */
    public T set(int index, T e) {
        checkIndex(index);
        int nowIndex = 0;
        Node<T> node = this.head.next;
        while (nowIndex < index) {
            node = node.next;
            nowIndex++;
        }
        T result = node.data;
        node.data = e;
        return result;
    }

    /**
     * 获取元素下标
     *
     * @param e
     * @return
     */
    public int getIndex(T e) {
        Node<T> node = this.head.next;
        if (e == null) {
            for (int i = 0; i < size; i++) {
                if (node.data == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (e.equals(node.data)) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 是否包含某元素
     *
     * @param e
     * @return
     */
    public boolean contains(T e) {
        int index = getIndex(e);
        if (index != -1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 在index位置添加元素
     *
     * @param index
     * @param e
     */
    public void add(int index, T e) {
        checkIndexAdd(index);
        Node<T> preNode = head;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        Node<T> nowNode = preNode.next;
        Node<T> newNode = new Node<>(e, nowNode);
        preNode.next = newNode;
        size++;
    }

    /**
     * 添加到头部
     * @param e
     */
    public void addHead(T e){
        add(0, e);
    }

    /**
     * 尾部添加元素
     * @param e
     */
    public void add(T e){
        add(size,e);
    }

    /**
     * 移除元素
     * @param index
     * @return
     */
    public T remove(int index){
        checkIndex(index);
        T result;
        Node<T> preNode = this.head;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        Node<T> nowNode = preNode.next;
        preNode.next = nowNode.next;
        result = nowNode.data;
        nowNode.next = null;

        size--;
        return result;
    }

    /**
     * 移除头元素
     * @return
     */
    public T removeFirst(){
        return remove(0);
    }

    /**
     * 移除尾部元素
     * @return
     */
    public T removeLast(){
        return remove(size-1);
    }


    /**
     *
     * @return
     */
    public boolean removeElement(T e){
        int index = getIndex(e);
        if(index == -1){
            return false;
        }else{
            remove(index);
            return true;
        }
    }


    private void checkIndexAdd(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("error,require index > 0 && index <= size");
        }
    }


    /**
     * 校验index是否合法
     *
     * @param index
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("error,index must be > 0 and < size");
        }
    }

    @Override
    public String toString() {
        Node<T> nowNode = this.head.next;
        String s = "MySingleLinkedList{";
        for (int i = 0; i < size; i++) {
            s += nowNode.data+",";
            nowNode = nowNode.next;
        }
        s = s.substring(0,s.lastIndexOf(","));
        s = s+"}";
        return s;
    }

    class Node<E> {

        private E data;

        private Node<E> next;

        public Node(E data) {
            this.data = data;
            next = null;
        }

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
}
