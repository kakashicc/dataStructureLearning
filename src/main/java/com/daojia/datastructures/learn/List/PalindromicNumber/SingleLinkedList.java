package com.daojia.datastructures.learn.List.PalindromicNumber;

/**
 * @Author: maosen
 * @Description: 单链表类
 * @Date: Created in 2019/9/5 20:33.
 */
public class SingleLinkedList<T> {

    public SingleLinkedList() {
        first = new Node<>();
    }

    /**
     * 头节点
     */
    Node<T> first;


    /**
     * 添加节点元素
     * @param item 值
     * @return
     */
    public boolean add(T item){

    }

    /**
     * 添加元素到指定位置
     * @param index 位置
     * @param item 元素值
     * @return
     */
    public boolean add(int index,T item){

    }

    /**
     * 删除指定位置元素
     * @param index 元素位置
     * @return
     */
    public boolean delete(int index){

    }

    /**
     * 删除指定元素值元素
     * @param item 元素值
     * @return
     */
    public boolean deleteByValue(T item){

    }

    /**
     * 返回链表长度
     * @return
     */
    public int size(){

    }

    /**
     * 从头打印链表
     * @return
     */
    public String printListFromHead(){

    }

    /**
     * 从尾打印链表
     * @return
     */
    public String printListFromHead(){

    }

    /**
     * 清空链表
     */
    public void clear(){

    }



    /**
     * 内部类 节点元素
     * @param <E> 节点类型
     */
    private class Node<E> {
        /**
         * 节点元素
         */
        E item;

        /**
         * 下一个节点
         */
        Node<E> next = null;

        /**
         * 构造方法
         * @param item
         * @param next
         */
        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }

        /**
         * 构造方法
         * @param item
         */
        public Node(E item) {
            this.item = item;
        }

        /**
         * 构造方法
         */
        public Node() {
            this.item = null;
        }

        public E getItem() {
            return item;
        }

        public void setItem(E item) {
            this.item = item;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "item=" + item +
                    '}';
        }
    }

    @Override
    public String toString() {

    }
}


