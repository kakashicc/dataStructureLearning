package com.daojia.datastructures.learn.patten.factory.abstra2;

import com.daojia.datastructures.learn.patten.factory.Milk;

/**
 * @Author: maosen
 * @Description: 蒙牛吸管
 * @Date: Created in 2020/4/10 21:38.
 */
public class MengNiuXiGuan implements XiGuan {

    private String name;

    public MengNiuXiGuan() {
        name = "蒙牛吸管";
    }

    /**
     * 名称
     */
    @Override
    public String getName() {
        return name;
    }
}