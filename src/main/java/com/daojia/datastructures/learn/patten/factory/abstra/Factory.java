package com.daojia.datastructures.learn.patten.factory.abstra;

import com.daojia.datastructures.learn.patten.factory.Milk;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2020/4/10 22:30.
 */
public interface Factory {

    Milk getMengNiu();

    Milk getYiLi();
}
