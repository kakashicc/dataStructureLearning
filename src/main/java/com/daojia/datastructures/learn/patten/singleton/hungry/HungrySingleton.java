package com.daojia.datastructures.learn.patten.singleton.hungry;

/**
 * @Author: maosen
 * @Description: 饿汉式单例
 * @Date: Created in 2020/4/12 9:42.
 */
public class HungrySingleton {

    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton(){

    }

    public static HungrySingleton getInstance(){
        return instance;
    }
}
