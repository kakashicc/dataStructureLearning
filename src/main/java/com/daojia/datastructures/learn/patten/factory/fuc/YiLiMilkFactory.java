package com.daojia.datastructures.learn.patten.factory.fuc;

import com.daojia.datastructures.learn.patten.factory.MengNiuMilk;
import com.daojia.datastructures.learn.patten.factory.Milk;
import com.daojia.datastructures.learn.patten.factory.YiLiMilk;

/**
 * @Author: maosen
 * @Description: 蒙牛工厂
 * @Date: Created in 2020/4/10 22:23.
 */
public class YiLiMilkFactory implements MilkFactory{

    @Override
    public Milk getMilk() {
        return new YiLiMilk();
    }
}
