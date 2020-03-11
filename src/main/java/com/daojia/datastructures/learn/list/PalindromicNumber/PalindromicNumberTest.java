package com.daojia.datastructures.learn.list.PalindromicNumber;

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
        list.add(2);
        list.add(1);
        System.out.println("原：" + list + " size=" + list.size());
        System.out.println("原list:"+list);

        //test addFirst
        //list.addFirst(4);
        //list.addFirst(5);
        System.out.println(isPalindrome(list));
        System.out.println("现list:"+list);
        //System.out.println("addFirst:" + list);

        //test add
        //list.add(0,5);
//        list.add(1,5);
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
//        System.out.println(list.deleteByValue(1));
//        System.out.println(list.deleteByValue(2));
//        System.out.println(list.deleteByValue(3));
//        System.out.println(list.deleteByValue(4));
//
        //test clear
//        list.clear();

        //test printFromTail
        //System.out.println(list);
        //System.out.println(list.getFromTail());
        //list.add(-1,6);

    }

    /**
     * 判断是否为回文数
     *
     * @param list 单链表
     * @return
     */
    public static boolean isPalindrome(SingleLinkedList<Integer> list) {
        Node<Integer> head = list.first.next;
        //小于等于1个元素时，是回文数
        if (head == null || head.next == null) {
            return true;
        }
        //反转头链表头节点
        Node<Integer> reverseHead = null;
        //下半链表头节点
        Node<Integer> normalHead = null;
        if(head.next.next == null){
            //只有两个元素
            reverseHead = head;
            normalHead = head.next;
            reverseHead.next = null;
        }else{
            //慢指针，每次走1步
            Node<Integer> slow = head;
            //快指针，每次走2步
            Node<Integer> fast = head;

            Node<Integer> tmpSlow;

            //循环遍历找到中间节点,同时反转前半链表
            while (fast.next != null && fast.next.next != null) {
                tmpSlow = slow.next;
                fast = fast.next.next;
                slow.next = reverseHead;
                reverseHead = slow;
                slow = tmpSlow;
            }

            tmpSlow = slow.next;
            slow.next = reverseHead;
            reverseHead = slow;

            //中间节点处理
            if (fast.next == null) {
                reverseHead = reverseHead.next;
            }

            normalHead = tmpSlow;
        }


        //遍历判断元素是否相等
        while(reverseHead != null && normalHead!=null){
            if(!reverseHead.item.equals(normalHead.item)){
                return false;
            }
            reverseHead = reverseHead.next;
            normalHead = normalHead.next;
        }
        return true;
    }

}
