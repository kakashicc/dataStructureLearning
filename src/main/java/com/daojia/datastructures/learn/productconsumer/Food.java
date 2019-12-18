package com.daojia.datastructures.learn.productconsumer;

/**
 * @Author: maosen
 * @Description: 食物
 * @Date: Created in 2019/12/2 16:56.
 */
public class Food {

    private static int counter = 0;

    /**
     * 第i个food
     */
    private int i;

    public Food() {
        i = ++counter;
    }

    @Override
    public String toString() {
        return "第" + i + "个菜";
    }
}
