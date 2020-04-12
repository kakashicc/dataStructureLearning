package com.daojia.datastructures.learn.patten.singleton.lazy;

/**
 * @Author: maosen
 * @Description: 懒汉式单例1 同步方法,效率较低
 * @Date: Created in 2020/4/12 9:43.
 */
public class LazySingleton01 {

    private static LazySingleton01 instance;

    private LazySingleton01(){

    }

    public synchronized LazySingleton01 getInstance(){
        if(instance == null){
            instance = new LazySingleton01();
        }
        return instance;
    }
}
