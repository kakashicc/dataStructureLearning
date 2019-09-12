package com.daojia.datastructures.learn.List.PalindromicNumber;

/**
 * @Author: maosen
 * @Description: 基础单链表类  头节点永远存在
 * @Date: Created in 2019/9/5 20:33.
 */
@SuppressWarnings("all")
public class SingleLinkedList111 {

    public SingleLinkedList111() {
        //first = new Node<>();
    }

    /**
     * 头节点
     */
    static Node first = new Node<Integer>();


    /**
     * 添加节点元素  尾插
     *
     * @param item 值
     * @return
     */
    public static void add(Integer item) {
        Node newNode = new Node<>(item);
        Node temp = first;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }


    public static void addNode(Node node) {
        Node temp = first;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    /**
     * 添加节点元素  头插
     *
     * @param item 值
     * @return
     */
    public void addFirst(Integer item) {
        Node newNode = new Node<>(item);
        Node temp = first.next;
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
    public boolean add(int index, Integer item) {
        int size = size();
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        //第index-1个节点
        Node preNode = first;
        int nowIndex = -1;
        while (nowIndex < index - 1) {
            preNode = preNode.next;
            nowIndex++;
        }
        //增加节点
        Node nextNode = preNode.next;
        Node newNode = new Node<>(item, nextNode);
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
        Node preNode = first;
        int nowIndex = -1;
        while (nowIndex < index - 1) {
            preNode = preNode.next;
            nowIndex++;
        }
        //删除指定节点
        Node toDelNode = preNode.next;
        Node nextNode = toDelNode.next;
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
    public boolean deleteByValue(Integer item) {
        if (size() == 0) {
            return false;
        }
        Node preNode = first;
        while (preNode.next != null) {
            if (preNode.next.equals(item)) {
                Node toDelNode = preNode.next;
                Node nextNode = preNode.next.next;
                preNode.next = nextNode;
                toDelNode.next = null;
                return true;
            }
            preNode = preNode.next;
        }
        return false;
    }

    public static Node getNode(int index){
        int size = size();
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int nowIndex = -1;
        Node tmp = first;
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
    public static int size() {
        int size = 0;
        Node tmp = first;
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
    public static String printListFromHead() {
        String result = "SingleLinkedList[";
        Node tmp = first;
        int count = 0;
        while (tmp.next != null) {
            tmp = tmp.next;
            result += tmp + ",";
            count++;
            if(count > 30){
                break;
            }
        }
        /*if (size() > 0) {
            result = result.substring(0, result.length() - 1);
        }*/
        result += "]";
        return result;
    }

    /**
     * 从尾打印链表
     *
     * @return
     */
    public String printListFromIntegerail() {
        String result = "SingleLinkedList[";
        Node current;
        Node end = null;
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
        Node nowNode = first;
        while (nowNode.next != null) {
            Node tmp = nowNode.next;
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
        Node slow = first;
        //快指针
        Node fast = first;
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
        return false;
    }

    public static void buildCycleList(){
        add(0);
        add(1);
        add(2);
        add(3);
        add(4);

        //System.out.println(this);
        Node node4 = (Node) getNode(4);
        Node node1 = (Node) getNode(1);
        Node node = new Node<>(5, node1);
        addNode(node);
        //System.out.println(node4.next);
        //System.out.println(node1.next);
        //node4.next = node1;
        System.out.println(printListFromHead());
        //return this;
    }

    public static void main(String[] args) {
        buildCycleList();
        //System.out.println(list.hasCycle());
    }




    @Override
    public String toString() {
        return printListFromHead();
    }
}


