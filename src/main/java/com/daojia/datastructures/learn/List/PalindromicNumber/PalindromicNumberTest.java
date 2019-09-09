package com.daojia.datastructures.learn.List.PalindromicNumber;

/**
 * @Author: maosen
 * @Description: 单链表实现回文数判断  回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 例如：121  123321  1234321
 * @Date: Created in 2019/9/5 20:29.
 */
public class PalindromicNumberTest {

    public static void main(String[] args) {

        SingleLinkedList<Integer> list = new SingleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("原："+list +" size="+list.size());

        //test addFirst
        list.addFirst(4);
        list.addFirst(5);

        //test add
        //list.add(0,5);
        //list.add(1,5);
        //list.add(2,5);
        //list.add(3,5);
        //list.add(4,5);

        //test delete
        //list.delete(-1);
        //list.delete(0);
        //list.delete(1);
        //list.delete(2);
        //list.delete(3);

        //test deleteValue
        //System.out.println(list.deleteByValue(1));
        //System.out.println(list.deleteByValue(2));
        //System.out.println(list.deleteByValue(3));
        //System.out.println(list.deleteByValue(4));

        //test clear
        //list.clear();

        //test printFromTail
        System.out.println(list);
        System.out.println(list.printListFromTail());
        //list.add(-1,6);

    }

}
