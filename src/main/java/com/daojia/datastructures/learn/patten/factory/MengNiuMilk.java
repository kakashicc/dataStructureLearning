package com.daojia.datastructures.learn.patten.factory;

/**
 * @Author: maosen
 * @Description: 蒙牛牛奶
 * @Date: Created in 2020/4/10 21:38.
 */
public class MengNiuMilk implements Milk{

    private String name;

    public MengNiuMilk() {
        name = "蒙牛牛奶";
    }

    /**
     * 名称
     */
    @Override
    public String getName() {
        return name;
    }
}