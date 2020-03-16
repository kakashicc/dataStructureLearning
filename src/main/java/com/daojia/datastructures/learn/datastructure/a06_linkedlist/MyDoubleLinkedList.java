package com.daojia.datastructures.learn.datastructure.a06_linkedlist;


/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2020/3/16 14:30.
 */
public class MyDoubleLinkedList<T> {

    /**
     * 头结点
     */
    Node<T> first;

    /**
     * 尾结点
     */
    Node<T> last;

    /**
     * 数据条数
     */
    int size;

    /**
     * 添加数据到指定位置
     *
     * @param index
     * @param item
     */
    public void add(int index, T item) {
        checkAddIndex(index);
        if (index == 0) {
            //add first

            //获取当前头节点
            Node<T> node = this.first;
            //构造新节点
            Node newNode = new Node(item, null, node);
            //头节点指针调整
            first = newNode;
            if (node != null) {
                //后节点prev指针调整
                node.prev = newNode;
            } else {
                //尾结点指针调整
                last = newNode;
            }
        } else {
            //add after node

            //获取前一节点
            Node<T> prevNode = node(index - 1);
            //获取当前index节点
            Node<T> nowNode = prevNode.next;
            //构造新节点
            Node<T> newNode = new Node<>(item, prevNode, nowNode);
            //修改前节点next指向
            prevNode.next = newNode;
            if (nowNode != null) {
                //修改后节点prev指向
                nowNode.prev = newNode;
            } else {
                //修改last指针指向
                last = newNode;
            }
        }
        size++;
    }

    /**
     * 头插
     *
     * @param item
     */
    public void addFirst(T item) {
        add(0, item);
    }

    /**
     * 尾插
     *
     * @param item
     */
    public void add(T item) {
        add(size, item);
    }

    /**
     * 添加元素到指定位置
     *
     * @param index
     * @param item
     */
    public void add1(int index, T item) {
        checkAddIndex(index);
        if (index == size) {
            //添加到尾结点
            Node<T> nowNode = this.last;
            Node<T> newNode = new Node<>(item, nowNode, null);
            last = newNode;
            if (nowNode != null) {
                nowNode.next = newNode;
            } else {
                first = newNode;
            }

        } else {
            //add before node

            Node<T> nowNode = node(index);
            Node<T> prevNode = nowNode.prev;
            Node<T> newNode = new Node<>(item, prevNode, nowNode);
            nowNode.prev = newNode;
            if (prevNode == null) {
                first = newNode;
            } else {
                prevNode.next = newNode;
            }
        }
        size++;
    }

    /**
     * 移除指定下标值
     * @param index
     * @return
     */
    public T remove(int index){
        checkIndex(index);
        return remove(node(index));
    }

    /**
     * 移除指定元素
     * @param item
     * @return
     */
    public boolean removeElement(T item){
        Node<T> node = this.first;
        if(item == null){
            for (int i = 0; i < size; i++) {
                if(node.item == null){
                    remove(node);
                    return true;
                }
                node = node.next;
            }
        }else{
            for (int i = 0; i < size; i++) {
                if(item.equals(node.item)){
                    remove(node);
                    return true;
                }
                node = node.next;
            }

        }
        return false;
    }

    /**
     * 是否包含某元素
     * @param item
     * @return
     */
    public boolean contains(T item){
        int index = indexOf(item);
        if(index != -1){
            return true;
        }else{
            return false;
        }
    }

    public int indexOf(T item){
        Node<T> node = this.first;
        if(item == null){
            for (int i = 0; i < size; i++) {
                if(node.item == null){
                    return i;
                }
                node = node.next;
            }
        }else{
            for (int i = 0; i < size; i++) {
                if(item.equals(node.item)){
                    return i;
                }
                node = node.next;
            }

        }
        return -1;
    }

    /**
     * 移除节点
     * @param node
     * @return
     */
    public T remove(Node<T> node){
        T result = node.item;
        Node<T> prevNode = node.prev;
        Node<T> nextNode = node.next;

        //help gc
        node.prev = null;
        node.next = null;
        node.item = null;

        if(prevNode != null){
            prevNode.next = nextNode;
        }else{
            first = nextNode;
        }

        if(nextNode != null){
            nextNode.prev = prevNode;
        }else{
            last = prevNode;
        }

        size--;
        return result;
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException("illegal index error!require >= 0 && < size");
        }
    }

    /**
     * 获取node元素结果
     *
     * @param index
     * @return
     */
    private Node<T> node(int index) {
        Node<T> node = this.first;
        for (int i = 1; i <= index; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * index校验
     *
     * @param index
     */
    private void checkAddIndex(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("illegal index error!require > 0 && <= size");
        }
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "MyDoubleLinkedList{}";
        }

        String result = "MyDoubleLinkedList{";
        Node<T> node = this.first;
        for (int i = 0; i < size; i++) {
            result += node.item + ",";
            node = node.next;
        }
        result = result.substring(0, result.lastIndexOf(","));
        result += "}";
        return result;
    }

    class Node<E> {

        /**
         * 元素值
         */
        E item;

        /**
         * 上一个值
         */
        Node<E> prev;

        /**
         * 下一个值
         */
        Node<E> next;

        public Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

}
