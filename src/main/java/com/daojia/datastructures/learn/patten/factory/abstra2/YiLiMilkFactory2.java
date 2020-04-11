package com.daojia.datastructures.learn.patten.factory.abstra2;

import com.daojia.datastructures.learn.patten.factory.Milk;
import com.daojia.datastructures.learn.patten.factory.YiLiMilk;

/**
 * @Author: maosen
 * @Description: 蒙牛工厂
 * @Date: Created in 2020/4/10 22:23.
 */
public class YiLiMilkFactory2 implements MilkFactory2 {

    @Override
    public Milk getMilk() {
        return new YiLiMilk();
    }

    @Override
    public XiGuan getXiGuan() {
        return new YiLiXiGuan();
    }
}
