package com.daojia.datastructures.learn;

import com.alibaba.fastjson.JSON;
import com.daojia.datastructures.learn.reflect.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2019/11/14 16:09.
 */
public class Test {

    public static void main(String[] args) {

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
