package com.daojia.datastructures.learn;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2019/11/19 16:02.
 */
public class Outer {

    static{
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("beforeStatic:"+System.currentTimeMillis());
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Long staticTime = System.currentTimeMillis();

    static{
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("afterStatic:"+System.currentTimeMillis());
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class Inner{
        public static Long innerStaticTime = System.currentTimeMillis();
    }



}
