package com.daojia.datastructures.learn.datastructure.a09_queue;

/**
 * @Author: maosen
 * @Description: 基于链表实现的队列
 * @Date: Created in 2020/3/18 16:59.
 */
public class LinkedQueue<T> {

    /**
     * 头结点索引
     */
    Node<T> head;

    /**
     * 尾结点索引
     */
    Node<T> tail;

    /**
     * 数据大小
     */
    int size;

    public LinkedQueue() {

    }

    /**
     * 入队
     *
     * @param item
     */
    public void enqueue(T item) {
        Node newNode = new Node(item, null);
        if(tail == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }

    /**
     * 出队
     */
    public T dequeue() {
        if(size == 0){
            throw new RuntimeException("index out of bounds,queue is empty!");
        }
        T result = head.item;
        Node<T> next = head.next;

        //help gc
        head.next = null;
        head.item = null;

        head = next;
        if(head == null){
            tail = null;
        }
        size--;
        return result;
    }

    class Node<E> {

        /**
         * 元素
         */
        E item;

        /**
         * 下一节点
         */
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

}
