package com.daojia.datastructures.learn.datastructure.a06_linkedlist;

/**
 * @Author: maosen
 * @Description: 单链表 带哨兵节点，简化操作
 * @Date: Created in 2020/3/16 10:46.
 */
public class MySentrySingleLinkedList<T> {

    /**
     * 当前大小
     */
    int size;

    /**
     * 头节点指针  哨兵节点,永远存在
     */
    Node<T> head = new Node(null,null);


    /**
     * 添加元素到指定位置
     *
     * @param index 位置
     * @param item  数据
     */
    public void add(int index, T item) {
        //校验index是否合法
        checkAddIndex(index);
        //获取前一节点,永远存在
        Node<T> prevNode = node(index - 1);
        //当前index节点
        Node<T> nowNode = prevNode.next;
        //新节点
        Node newNode = new Node(item, nowNode);
        prevNode.next = newNode;
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

        //前一个元素，永远存在
        Node<T> prevNode = node(index - 1);
        //当前节点
        Node<T> nowNode = prevNode.next;
        result = nowNode.item;
        //下一节点
        Node<T> nextNode = nowNode.next;
        prevNode.next = nextNode;
        //help gc
        nowNode.next = null;
        nowNode.item = null;
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
        Node<T> node = this.head.next;
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
        Node<T> node = this.head.next;
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
        for (int i = 0; i <= index; i++) {
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
        Node<T> node = this.head.next;
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
