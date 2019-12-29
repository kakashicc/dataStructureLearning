package com.daojia.datastructures.learn.productconsumer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2019/12/2 17:12.
 */
public class Restaurant {

    public static void main(String[] args) {
        Queue<Food> queue = new LinkedList<>();
        new Cook(queue, "1号厨师").start();
        new Cook(queue, "2号厨师").start();
        new Cook(queue, "3号厨师").start();
        new Cook(queue, "4号厨师").start();
        new Cook(queue, "5号厨师").start();
        new Cook(queue, "6号厨师").start();
        new Waiter(queue, "1号服务员").start();
        new Waiter(queue, "2号服务员").start();
        new Waiter(queue, "3号服务员").start();
        new Waiter(queue, "4号服务员").start();
        new Waiter(queue, "5号服务员").start();
        new Waiter(queue, "6号服务员").start();
    }
}
