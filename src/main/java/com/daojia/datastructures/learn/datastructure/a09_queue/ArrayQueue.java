package com.daojia.datastructures.learn.datastructure.a09_queue;

/**
 * @Author: maosen
 * @Description: 基于数组实现的队列
 * @Date: Created in 2020/3/18 16:59.
 */
public class ArrayQueue<T> {

    /**
     * 队列容量
     */
    int capacity;

    /**
     * 头结点索引
     */
    int head;

    /**
     * 尾结点索引
     */
    int tail;

    /**
     * 数据
     */
    T[] items;

    /**
     * 数据大小
     */
    int size;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        items = (T[]) new Object[capacity];
    }

    /**
     * 入队
     *
     * @param item
     */
    public void enqueue(T item) {
        if (tail == capacity) {
            throw new RuntimeException("index out of bounds");
        }
        items[tail++] = item;
        size++;
    }

    /**
     * 出队
     */
    public T dequeue() {
        if (head == tail) {
            throw new RuntimeException("index out of bounds");
        }
        T result = items[head++];
        size--;
        return result;
    }

}
