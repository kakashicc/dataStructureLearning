package com.daojia.datastructures.learn.productconsumer;

import java.util.Queue;

/**
 * @Author: maosen
 * @Description: 厨师
 * @Date: Created in 2019/12/2 17:00.
 */
public class Cook extends Thread {

    private Queue<Food> queue;

    public Cook(Queue<Food> queue, String name) {
        super(name);
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            //模拟炒菜时间,随机睡眠1秒内时间
            SleepUtil.randomSleep();
            synchronized (queue) {
                while (queue.size() > 4) {
                    try {
                        System.out.println("队列元素超过4个,size="+queue.size()+" "+this.getName()+"等待中");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Food food = new Food();
                System.out.println(this.getName() + "生产了" + food);
                queue.add(food);
                queue.notifyAll();
            }
        }
    }
}
