package com.daojia.datastructures.learn.patten.singleton.lazy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @Author: maosen
 * @Description: 懒汉式单例3 内部类实现
 * @Date: Created in 2020/4/12 9:43.
 */
public class LazySingleton03 {

    private LazySingleton03(){
    }

    public static LazySingleton03 getInstance(){
        return LazySingletonHolder.instance;
    }

    private static final class LazySingletonHolder{
         private static final LazySingleton03 instance = new LazySingleton03();
    }
}
