package com.daojia.datastructures.learn.patten.factory.abstra;

import com.daojia.datastructures.learn.patten.factory.MengNiuMilk;
import com.daojia.datastructures.learn.patten.factory.Milk;
import com.daojia.datastructures.learn.patten.factory.YiLiMilk;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2020/4/10 22:31.
 */
public class AbsMilkFactory implements Factory {
    @Override
    public Milk getMengNiu() {
        return new MengNiuMilk();
    }

    @Override
    public Milk getYiLi() {
        return new YiLiMilk();
    }
}
