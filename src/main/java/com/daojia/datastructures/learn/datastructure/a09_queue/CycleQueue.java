package com.daojia.datastructures.learn.datastructure.a09_queue;

/**
 * @Author: maosen
 * @Description: 基础环形队列  容量比实际容量小1
 * @Date: Created in 2020/3/19 11:07.
 */
public class CycleQueue<T> {

    /**
     * 元素
     */
    T[] items;

    /**
     * 头节点索引
     */
    int head;

    /**
     * 尾结点索引
     */
    int tail;

    /**
     * 容量
     */
    int capacity;

    public CycleQueue(int capacity){
        this.capacity = capacity;
        items = (T[])new Object[capacity];
    }

    /**
     * 入队
     */
    public void enqueue(T item){
        if((tail+1)%capacity == head){
            throw new RuntimeException("index out of bounds,queue is full!");
        }
        items[tail] = item;
        tail = (tail+1)%capacity;
    }

    /**
     * 出队
     */
    public T dequeue(){
        if(head == tail){
            throw new RuntimeException("index out of bounds,queue is empty");
        }
        T result = items[head];
        head = (head+1)%capacity;
        return result;
    }

}
