package com.daojia.datastructures.learn.datastructure.a06_linkedlist;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2020/3/11 17:30.
 */
public class MySingleLinkedList<T> {

    /**
     * 头节点
     */
    private Node<T> head;

    /**
     * 链表长度
     */
    private int size;

    public MySingleLinkedList() {

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
        Node<T> node = this.head;
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
        Node<T> node = this.head;
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
        Node<T> node = this.head;
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
        Node<T> preNode = null;
        if (index == 0) {
            Node<T> newNode = new Node<>(e, head);
            head = newNode;
        } else {
            for (int i = 1; i < index; i++) {
                preNode = preNode.next;
            }
            Node<T> nowNode = preNode.next;
            Node<T> newNode = new Node<>(e, nowNode);
            preNode.next = newNode;
        }
        size++;
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
