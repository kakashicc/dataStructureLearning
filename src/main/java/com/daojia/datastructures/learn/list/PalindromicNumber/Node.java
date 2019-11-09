package com.daojia.datastructures.learn.list.PalindromicNumber;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2019/9/10 20:05.
 */
/**
 * 内部类 节点元素
 *
 * @param <E> 节点类型
 */
class Node<E> {
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