package com.daojia.datastructures.learn;

import java.util.concurrent.CyclicBarrier;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2019/11/19 20:50.
 */
public class Example {

    int x = 0;
    boolean v = false;

    public void writer() {
        x = 42;
        v = true;
    }

    public void reader() {
            if (v == true) {
                // 这里 x 会是多少呢？
                System.out.print(x);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
    }

    public static void main(String[] args) {
        Example example = new Example();
        new Thread(() -> {
            example.writer();
        }).start();
        new Thread(() -> {
            example.reader();
        }).start();
        CyclicBarrier cb = new CyclicBarrier(2);

    }
}

