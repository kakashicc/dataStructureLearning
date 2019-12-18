package com.daojia.datastructures.learn.singleton;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2019/11/19 15:36.
 */
public class LazySingleton2 {

    private static class SingletonHolder{
        private static LazySingleton2 instance = new LazySingleton2();
    }

    /**
     * 私有化默认构造方法
     */
    private LazySingleton2(){

    }

    public static LazySingleton2 getInstance(){
        return SingletonHolder.instance;
    }

}
