package com.daojia.datastructures.learn;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2019/12/2 19:30.
 */
@SuppressWarnings("all")
public class DeadLockDemo {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1){
                    System.out.println(Thread.currentThread().getName()+"获取了lock1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (lock2){
                        System.out.println(Thread.currentThread().getName()+"获取了lock2");
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2){
                    System.out.println(Thread.currentThread().getName()+"获取了lock2");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (lock1){
                        System.out.println(Thread.currentThread().getName()+"获取了lock1");
                    }
                }
            }
        }).start();
    }
}
