package com.daojia.datastructures.learn.List.PalindromicNumber;

/**
 * @Author: maosen
 * @Description: 单链表实现回文数判断  回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 例如：121  123321  1234321
 * @Date: Created in 2019/9/5 20:29.
 */
public class PalindromicNumberTest {

    public static void main(String[] args) {

        SingleLinkedList list = new SingleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(1);

        System.out.println(list);

    }

}
