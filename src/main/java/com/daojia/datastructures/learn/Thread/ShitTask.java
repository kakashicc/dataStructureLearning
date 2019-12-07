package com.daojia.datastructures.learn.Thread;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2019/11/24 21:38.
 */
public class ShitTask implements Runnable{

        private Washroom washroom;

        private String name;

        public ShitTask(Washroom washroom, String name) {
            this.washroom = washroom;
            this.name = name;
        }

        @Override
        public void run() {
            synchronized (washroom.getLock()) {
                System.out.println(name + " 获取了厕所的锁");
                while (!washroom.isAvailable()) {
                    // 一直等
                    try {
                        washroom.getLock().wait(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(name + " 上完了厕所");
            }
        }
}
