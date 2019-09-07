package com.daojia.datastructures.learn.List.PalindromicNumber;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.LinkedList;

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
     *
     * @param item 值
     * @return
     */
    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        Node<T> temp = first;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    /**
     * 添加元素到指定位置
     *
     * @param index 位置
     * @param item  元素值
     * @return
     */
    public boolean add(int index, T item) {
        int size = size();
        if (index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException();
        }
        //第index-1个节点
        Node<T> preNode = first;
        int nowIndex = -1;
        while (nowIndex < index - 1) {
            preNode = preNode.next;
            nowIndex++;
        }
        //增加节点
        Node<T> nextNode = preNode.next;
        Node<T> newNode = new Node<>(item,nextNode);
        preNode.next = newNode;
        return true;
    }

    /**
     * 删除指定位置元素
     *
     * @param index 元素位置
     * @return
     */
    public boolean delete(int index) {
        int size = size();
        if (index < 0 || index > size-1){
            throw new ArrayIndexOutOfBoundsException();
        }
        //找到第index-1个元素
        Node<T> preNode = first;
        int nowIndex = -1;
        while (nowIndex < index - 1) {
            preNode = preNode.next;
            nowIndex++;
        }
        //删除指定节点
        Node<T> toDelNode = preNode.next;
        Node<T> nextNode = toDelNode.next;
        preNode.next = nextNode;
        toDelNode.next = null;
        return true;
    }

    /**
     * 删除指定元素值元素
     *
     * @param item 元素值
     * @return
     */
    public boolean deleteByValue(T item) {
        if(size() == 0){
            return false;
        }
        Node<T> preNode = first;
        while(preNode.next != null){
            if(preNode.next.equals(item)){
                Node<T> toDelNode = preNode.next;
                Node<T> nextNode = preNode.next.next;
                preNode.next = nextNode;
                toDelNode.next = null;
                return true;
            }
            preNode = preNode.next;
        }
        return false;
    }

    /**
     * 返回链表长度
     *
     * @return
     */
    public int size() {
        int size = 0;
        Node<T> tmp = this.first;
        while (tmp.next != null) {
            size++;
            tmp = tmp.next;
        }
        return size;
    }

    /**
     * 从头打印链表
     *
     * @return
     */
    public String printListFromHead() {
        String result = "SingleLinkedList[";
        Node<T> tmp = this.first;
        while(tmp.next != null){
            tmp = tmp.next;
            result += tmp + ",";
        }
        if(size()>0){
            result = result.substring(0,result.length()-1);
        }
        result+= "]";
        return result;
    }

    /**
     * 从尾打印链表
     *
     * @return
     */
    public String printListFromTail() {
        return null;
    }

    /**
     * 清空链表
     */
    public void clear() {
        if(size()==0){
            return;
        }
        Node<T> nowNode = this.first;
        while(nowNode.next != null){
            Node<T> tmp = nowNode.next;
            nowNode.next = null;
            nowNode = tmp;
        }
    }


    /**
     * 内部类 节点元素
     *
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
         *
         * @param item
         * @param next
         */
        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }

        /**
         * 构造方法
         *
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
            return item.toString();
        }

        @Override
        public boolean equals(Object o) {
            return item.equals(o);
        }

        @Override
        public int hashCode() {
            return item.hashCode();
        }
    }

    @Override
    public String toString() {
        return printListFromHead();
    }
}


