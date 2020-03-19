package com.daojia.datastructures.learn.datastructure.a09_queue;

/**
 * @Author: maosen
 * @Description: 基础环形队列 添加size 容量=实际容量小
 * @Date: Created in 2020/3/19 11:07.
 */
public class CycleQueueWithSize<T> {

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
     * 总容量
     */
    int capacity;

    /**
     * 当前数据量
     */
    int size;

    public CycleQueueWithSize(int capacity){
        this.capacity = capacity;
        items = (T[])new Object[capacity];
    }

    /**
     * 入队
     */
    public void enqueue(T item){
        if(size == capacity){
            throw new RuntimeException("index out of bounds,queue is full!");
        }
        items[tail] = item;
        tail = (tail+1)%capacity;
        size++;
    }

    /**
     * 出队
     */
    public T dequeue(){
        if(size == 0){
            throw new RuntimeException("index out of bounds,queue is empty");
        }
        T result = items[head];
        head = (head+1)%capacity;
        size--;
        return result;
    }

}
