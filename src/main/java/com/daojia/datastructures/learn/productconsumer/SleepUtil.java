package com.daojia.datastructures.learn.productconsumer;

import java.util.Random;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2019/12/2 16:58.
 */
public class SleepUtil {

    private static Random random = new Random();

    public static void randomSleep(){
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
