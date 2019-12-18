package com.daojia.datastructures.learn.productconsumer;

import java.util.Queue;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2019/12/2 17:07.
 */
public class Waiter extends Thread {

    private Queue<Food> queue;

    public Waiter(Queue<Food> queue, String name) {
        super(name);
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            Food food;
            synchronized (queue) {
                while (queue.size() < 1) {
                    try {
                        System.out.println("队列元素小于1个,size=" + queue.size() + " " + getName() + "等待中");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                food = queue.remove();
                System.out.println(getName() + "获取到的食物为" + food);
                queue.notifyAll();
            }
            //模拟端菜时间
            SleepUtil.randomSleep();
        }
    }
}
