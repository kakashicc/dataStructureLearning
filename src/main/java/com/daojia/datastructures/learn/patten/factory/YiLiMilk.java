package com.daojia.datastructures.learn.patten.factory;

/**
 * @Author: maosen
 * @Description: 伊利牛奶
 * @Date: Created in 2020/4/10 21:38.
 */
public class YiLiMilk implements Milk{

    private String name;

    public YiLiMilk() {
        name = "伊利牛奶";
    }


    /**
     * 名称
     */
    @Override
    public String getName() {
        return name;
    }
}