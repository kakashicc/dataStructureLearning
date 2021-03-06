package com.daojia.datastructures.learn.list.PalindromicNumber;

import java.util.LinkedList;

/**
 * @Author: maosen
 * @Description: 基础单链表类  头节点永远存在
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
     * 添加节点元素  尾插
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
     * 添加节点元素  头插
     *
     * @param item 值
     * @return
     */
    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);
        Node<T> temp = first.next;
        newNode.next = temp;
        first.next = newNode;
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
        if (index < 0 || index > size) {
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
        Node<T> newNode = new Node<>(item, nextNode);
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
        if (index < 0 || index > size - 1) {
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
        if (size() == 0) {
            return false;
        }
        Node<T> preNode = first;
        while (preNode.next != null) {
            if (preNode.next.equals(item)) {
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

    public Node<T> getNode(int index){
        int size = size();
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int nowIndex = -1;
        Node<T> tmp = this.first;
        while(tmp.next != null){
            tmp = tmp.next;
            nowIndex++;
            if(nowIndex == index){
                return tmp;
            }
        }
        return null;
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
        while (tmp.next != null) {
            tmp = tmp.next;
            result += tmp + ",";
        }
        if (size() > 0) {
            result = result.substring(0, result.length() - 1);
        }
        result += "]";
        return result;
    }

    /**
     * 从尾打印链表
     *
     * @return
     */
    public String printListFromTail() {
        String result = "SingleLinkedList[";
        Node<T> current;
        Node<T> end = null;
        while (end != first.next) {
            current = first.next;
            while(current.next != end){
                current = current.next;
            }
            result += current + ",";
            end = current;
        }
        if (size() > 0) {
            result = result.substring(0, result.length() - 1);
        }
        result += "]";
        return result;
    }

    /**
     * 清空链表
     */
    public void clear() {
        if (size() == 0) {
            return;
        }
        Node<T> nowNode = this.first;
        while (nowNode.next != null) {
            Node<T> tmp = nowNode.next;
            nowNode.next = null;
            nowNode = tmp;
        }
    }

    /**
     * 是否有环
     */
    public boolean hasCycle(){
        if(size() == 0){
            return false;
        }

        //慢指针
        Node<T> slow = this.first;
        //快指针
        Node<T> fast = this.first;
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
            if(fast ==null){
                return false;
            }
            fast = fast.next;
            if(slow == fast){
                return true;
            }
        }
        LinkedList list1 = new LinkedList();
        list1.iterator();
        return false;
    }

    public SingleLinkedList<Integer> buildCycleList(){
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        Node<Integer> node2 = (Node<Integer>) list.getNode(2);
        Node<Integer> node0 = (Node<Integer>) list.getNode(0);
        node2.next = node0;
        return list;
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>().buildCycleList();
        System.out.println(list.hasCycle());
    }



    @Override
    public String toString() {
        return printListFromHead();
    }
}


