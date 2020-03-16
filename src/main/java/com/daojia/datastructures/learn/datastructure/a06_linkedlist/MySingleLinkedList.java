package com.daojia.datastructures.learn.datastructure.a06_linkedlist;

import javax.swing.plaf.TreeUI;

/**
 * @Author: maosen
 * @Description: 单链表
 * @Date: Created in 2020/3/16 10:46.
 */
public class MySingleLinkedList<T> {

    /**
     * 当前大小
     */
    int size;

    /**
     * 头节点指针
     */
    Node<T> head;

    /**
     * 添加元素到指定位置
     *
     * @param index 位置
     * @param item  数据
     */
    public void add(int index, T item) {
        //校验index是否合法
        checkAddIndex(index);
        if (index == 0) {
            //添加到头部   新增节点插入到头部并处理头部指针

            Node newNode = new Node(item, head);
            head = newNode;
        } else {
            //添加到非头部  新增节点插入到当前节点和前一节点之间

            //前一节点
            Node<T> prevNode = node(index - 1);
            //当前节点
            Node<T> nowNode = prevNode.next;
            //新添加节点 指向当前index节点
            Node<T> newNode = new Node<>(item, nowNode);
            //前一节点指向新添加节点
            prevNode.next = newNode;
        }
        size++;
    }

    /**
     * 添加到头部
     *
     * @param item
     */
    public void addFirst(T item) {
        add(0, item);
    }

    /**
     * 添加到尾部
     *
     * @param item
     */
    public void add(T item) {
        add(size, item);
    }

    /**
     * 移除index处元素
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        checkIndex(index);
        T result;
        if (index == 0) {
            //移除头部元素 移除头节点,并修改head指针

            //下一节点
            Node<T> nextNode = head.next;
            //删除元素数据值
            result = head.item;
            //help gc
            head.item = null;
            head.next = null;
            //head指向下一节点
            head = nextNode;
        } else {
            //移除非头部元素  移除当前节点,并修改前后节点指针

            //获取前一节点
            Node<T> prevNode = node(index - 1);
            //当前节点 待删除
            Node<T> nowNode = prevNode.next;
            //下一节点
            Node<T> nextNode = nowNode.next;
            //返回结果
            result = nowNode.item;
            //help gc
            nowNode.next = null;
            nowNode.item = null;
            //前一节点指针指向后一节点
            prevNode.next = nextNode;
        }
        size--;
        return result;
    }

    /**
     * 移除元素
     *
     * @param item
     * @return
     */
    public boolean removeElement(T item) {
        Node<T> node = this.head;
        if (item == null) {
            for (int i = 0; i < size; i++) {
                if (node.item == null) {
                    remove(i);
                    return true;
                }
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (item.equals(node.item)) {
                    remove(i);
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    /**
     * 获取元素下标
     *
     * @param item
     * @return
     */
    public int getIndex(T item) {
        Node<T> node = this.head;
        if (item == null) {
            for (int i = 0; i < size; i++) {
                if (node.item == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (item.equals(node.item)) {
                    return i;
                }
                node = node.next;
            }
        }
        return -1;
    }

    /**
     * 获取下标值
     *
     * @param index
     * @return
     */
    public T get(int index) {
        checkIndex(index);
        Node<T> node = node(index);
        return node.item;
    }

    /**
     * 设置指定位置元素值
     *
     * @param index 指定位置
     * @param item  新值
     * @return 旧值
     */
    public T set(int index, T item) {
        checkIndex(index);
        Node<T> node = node(index);
        T oldValue = node.item;
        node.item = item;
        return oldValue;
    }

    /**
     * 是否包含某元素
     *
     * @param item
     * @return
     */
    public boolean contains(T item) {
        int index = getIndex(item);
        if (index != -1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 校验index合法性
     *
     * @param index
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("illegal index!require >=0 && < size");
        }
    }

    /**
     * 获取非null节点元素
     *
     * @param index
     * @return
     */
    private Node<T> node(int index) {
        Node<T> node = this.head;
        for (int i = 1; i <= index; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * 校验添加index是否合法
     *
     * @param index 下标索引
     */
    private void checkAddIndex(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("illegal index! require >=0 && < size");
        }
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "MySingleLinkedList{}";
        }

        String result = "MySingleLinkedList{";
        Node<T> node = this.head;
        for (int i = 0; i < size; i++) {
            result += node.item + ",";
            node = node.next;
        }
        result = result.substring(0, result.lastIndexOf(","));
        result += "}";
        return result;
    }

    private class Node<E> {

        /**
         * 数据
         */
        E item;

        /**
         * 下一个节点
         */
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}
