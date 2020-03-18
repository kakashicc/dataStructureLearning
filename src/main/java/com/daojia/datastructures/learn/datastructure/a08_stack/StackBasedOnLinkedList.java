package com.daojia.datastructures.learn.datastructure.a08_stack;

/**
 * @Author: maosen
 * @Description: 基于链表的栈实现
 * @Date: Created in 2020/3/18 15:04.
 */
public class StackBasedOnLinkedList<T> {

    /**
     * 长度
     */
    int size;

    /**
     * 头部元素
     */
    Node<T> top;

    /**
     * 入栈
     * @param item
     */
    public void push(T item) {
        top = new Node<>(item, top);
        size++;
    }

    /**
     * 出栈
     * @return
     */
    public T pop(){
        if(size == 0){
            throw new RuntimeException("error!stack index out of bounds");
        }
        T result = top.item;
        Node<T> nextNode = top.next;
        //help gc
        top.item = null;
        top.next = null;
        top = nextNode;
        size--;
        return result;
    }

    class Node<E> {

        /**
         * 数据
         */
        E item;

        /**
         * 下一个元素
         */
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}
