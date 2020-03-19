package com.daojia.datastructures.learn;

import com.daojia.datastructures.learn.datastructure.a05_array.MyArrayList;
import com.daojia.datastructures.learn.datastructure.a06_linkedlist.MyDoubleLinkedList;
import com.daojia.datastructures.learn.datastructure.a06_linkedlist.MySentrySingleLinkedList;
import com.daojia.datastructures.learn.datastructure.a06_linkedlist.MySingleLinkedList;
import com.daojia.datastructures.learn.datastructure.a06_linkedlist.MySingleLinkedList02;
import com.daojia.datastructures.learn.datastructure.a08_stack.StackBasedOnLinkedList;
import com.daojia.datastructures.learn.datastructure.a09_queue.ArrayQueue;
import com.daojia.datastructures.learn.datastructure.a09_queue.CycleQueue;
import com.daojia.datastructures.learn.datastructure.a09_queue.CycleQueueWithSize;
import com.daojia.datastructures.learn.datastructure.a09_queue.DynamicArrayQueue;
import com.daojia.datastructures.learn.datastructure.a09_queue.LinkedQueue;

import javax.management.QueryEval;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2019/11/14 16:09.
 */
public class Test {

    public static void main(String[] args) {

        LinkedQueue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(4);
        System.out.println(queue.dequeue());


        /*StackBasedOnLinkedList stack = new StackBasedOnLinkedList<Integer>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());*/



        /*MySentrySingleLinkedList<Integer> list = new MySentrySingleLinkedList<>();
        System.out.println(list.contains(1));
        System.out.println(list.contains(0));
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println("原list:" + list);
        list.remove(0);
        System.out.println("删除index=0" + list);
        list.add(0, 1);

        list.remove(1);
        System.out.println("删除index=1" + list);
        list.add(1, 2);

        list.remove(3);
        System.out.println("删除index=3" + list);
        list.add(3, 4);

        System.out.println("全部恢复list=" + list);

        System.out.println("contains(3)" + list.contains(3));
        System.out.println("contains(5)" + list.contains(5));
        list.removeElement(1);
        System.out.println("list.removeElement(1)"+list);
        list.add(5);
        System.out.println("list.add(5)"+list);
*/

      /*  System.out.println("Inner.staticTime:"+Outer.Inner.innerStaticTime);
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Outer.staticTime:"+Outer.staticTime);*/


      /*  new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }
        ,"aaa").start();*/

       /* List<Book> list = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            Book book = new Book();
            book.setAuthor(i+"");
            book.setName(i+"");
            list.add(book);
        }

        long startTime = System.currentTimeMillis();
        double count = 0f;
        double finish = 0f;
        for (Book book : list) {
            String s = JSON.toJSONString(book);
            Book book1 = JSON.parseObject(s, Book.class);
            count += Double.parseDouble(book.getName());
            double author = Double.parseDouble(book.getAuthor());
            if(author % 3 == 0){
                finish += author;
            }
        }
        double rate = finish / count;
        System.out.println(rate);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);*/
    }
}
