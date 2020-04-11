package com.daojia.datastructures.learn.patten.factory.fuc;

import com.daojia.datastructures.learn.patten.factory.MengNiuMilk;
import com.daojia.datastructures.learn.patten.factory.Milk;

/**
 * @Author: maosen
 * @Description: 蒙牛工厂
 * @Date: Created in 2020/4/10 22:23.
 */
public class MengNiuMilkFactory implements MilkFactory{
    @Override
    public Milk getMilk() {
        return new MengNiuMilk();
    }
}
