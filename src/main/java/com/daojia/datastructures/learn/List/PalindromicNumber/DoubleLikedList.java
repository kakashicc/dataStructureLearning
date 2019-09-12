package com.daojia.datastructures.learn.List.PalindromicNumber;

import java.util.Objects;

/**
 * @Author: maosen
 * @Description: 双向链表
 * @Date: Created in 2019/9/9 21:09.
 */
public class DoubleLikedList<T> {

    /**
     * 头节点
     */
    Node<T> head;

    public DoubleLikedList() {
        head = new Node<T>();
    }

    /**
     * 尾插入
     *
     * @param item 元素值
     */
    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        Node<T> tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        newNode.pre = tmp;
        tmp.next = newNode;
    }

    /**
     * 插入指定位置
     *
     * @param item 元素值
     */
    public void add(int index,T item) {
        Node<T> newNode = new Node<>(item);
        int size = size();
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node<T> preNode = this.head;
        int nowIndex = -1;
        while (nowIndex < index - 1) {
            preNode = preNode.next;
            nowIndex++;
        }
        Node<T> nextNode = preNode.next;
        newNode.next = nextNode;
        newNode.pre = preNode;
        preNode.next = newNode;
        if(nextNode != null){
            nextNode.pre = newNode;
        }
    }

    /**
     * 头插入
     *
     * @param item 元素值
     */
    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);
        Node<T> nextNode = head.next;
        newNode.next = nextNode;
        nextNode.pre = newNode;
        head.next = newNode;
        newNode.pre = head;
    }

    /**
     * 大小
     *
     * @return
     */
    public int size() {
        Node<T> tmp = this.head;
        int size = 0;
        while (tmp.next != null) {
            tmp = tmp.next;
            size++;
        }
        return size;
    }

    /**
     * 删除指定位置值
     *
     * @param index
     * @return
     */
    public boolean delete(int index) {
        int size = size();
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node<T> preNode = this.head;
        int nowIndex = -1;
        while (nowIndex < index - 1) {
            preNode = preNode.next;
            nowIndex++;
        }
        Node<T> toDeleteNode = preNode.next;
        preNode.next = toDeleteNode.next;
        if (toDeleteNode.next != null) {
            toDeleteNode.next.pre = preNode;
        }
        toDeleteNode.pre = null;
        toDeleteNode.next = null;
        return true;
    }

    /**
     * 删除指定值
     *
     * @param value
     * @return
     */
    public boolean deleteByValue(T value) {
        Node<T> preNode = this.head;
        while (preNode.next != null) {
            if (preNode.next.item.equals(value)) {
                Node<T> toDeleteNode = preNode.next;
                preNode.next = toDeleteNode.next;
                if (toDeleteNode.next != null) {
                    toDeleteNode.next.pre = preNode;
                }
                toDeleteNode.pre = null;
                toDeleteNode.next = null;
                return true;
            }
            preNode = preNode.next;
        }
        return false;

    }

    /**
     * 清空列表
     */
    public void clear() {
        Node<T> nowNode = this.head;
        while (nowNode.next != null) {
            Node<T> tmp = nowNode.next;
            nowNode.next = null;
            nowNode.pre = null;
            nowNode = tmp;
        }
    }

    /**
     * 从头遍历值
     *
     * @return
     */
    public String getFromHead() {
        String result = "DoubleLinkedList[";
        Node<T> tmp = this.head;
        while (tmp.next != null) {
            tmp = tmp.next;
            result += tmp.item + ",";
        }
        if (head.next != null) {
            result = result.substring(0, result.length() - 1);
        }
        result += "]";
        return result;
    }

    /**
     * 从尾部遍历值
     *
     * @return
     */
    public String getFromTail() {
        String result = "DoubleLinkedList[";
        Node<T> current;
        Node<T> end = null;
        while (end != head.next) {
            current = head.next;
            while (current.next != end) {
                current = current.next;
            }
            result += current.item + ",";
            end = current;
        }
        if (head.next != null) {
            result = result.substring(0, result.length() - 1);
        }
        result += "]";
        return result;
    }

    @Override
    public String toString() {
        return getFromHead();
    }

    /**
     * 节点内部类
     *
     * @param <E>
     */
    private class Node<E> {

        /**
         * 元素值
         */
        E item;

        /**
         * 前一个节点
         */
        Node<E> pre;

        /**
         * 后一个节点
         */
        Node<E> next;

        public Node() {
            this.item = null;
        }

        public Node(E item) {
            this.item = item;
        }

        public Node(E item, Node<E> pre, Node<E> next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node<?> node = (Node<?>) o;
            return item.equals(node.item);
        }

        @Override
        public int hashCode() {
            return Objects.hash(item);
        }

        @Override
        public String toString() {
            return item.toString();
        }
    }
}
