package com.daojia.datastructures.learn;

import com.daojia.datastructures.learn.datastructure.a05_array.MyArrayList;
import com.daojia.datastructures.learn.datastructure.a06_linkedlist.MySingleLinkedList;
import com.daojia.datastructures.learn.datastructure.a06_linkedlist.MySingleLinkedList02;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2019/11/14 16:09.
 */
public class Test {

    public static void main(String[] args) {

        MySingleLinkedList02<Integer> list = new MySingleLinkedList02<>();
        System.out.println(list.contains(1));
        System.out.println(list.contains(0));
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println("原list:"+list);
        list.remove(0);
        System.out.println("删除index=0"+list);
        list.add(0,1);

        list.remove(1);
        System.out.println("删除index=1"+list);
        list.add(1,2);

        list.remove(3);
        System.out.println("删除index=3"+list);
        list.add(3,4);

        System.out.println("全部恢复list="+list);

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
