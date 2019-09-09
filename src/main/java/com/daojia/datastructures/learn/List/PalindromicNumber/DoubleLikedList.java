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

    /**
     * 尾结点
     */
    Node<T> tail;

    /**
     * 尾插入
     * @param item 元素值
     */
    public void add(T item){

    }

    /**
     * 头插入
     * @param item 元素值
     */
    public void addFirst(T item){

    }

    /**
     * 大小
     * @return
     */
    public int size(){

    }

    /**
     * 删除指定位置值
     * @param index
     * @return
     */
    public boolean delele(int index){

    }

    /**
     * 删除指定值
     * @param value
     * @return
     */
    public boolean deleteByValue(T value){

    }

    /**
     * 清空列表
     */
    public void clear(){

    }

    /**
     * 从头遍历值
     * @return
     */
    public String getFromHead(){

    }

    /**
     * 从尾部遍历值
     * @return
     */
    public String getFromTail(){

    }

    @Override
    public String toString() {
        return getFromHead();
    }

    /**
     * 节点内部类
     * @param <E>
     */
    private class Node<E>{

        /**
         * 元素值
         */
        E item;

        /**
         * 前一个节点
         */
        Node<E> preNode;

        /**
         * 后一个节点
         */
        Node<E> nextNode;

        public Node(E item) {
            this.item = item;
        }

        public Node(E item, Node<E> preNode, Node<E> nextNode) {
            this.item = item;
            this.preNode = preNode;
            this.nextNode = nextNode;
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
