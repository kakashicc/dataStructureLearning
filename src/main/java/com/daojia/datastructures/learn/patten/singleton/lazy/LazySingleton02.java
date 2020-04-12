package com.daojia.datastructures.learn.patten.singleton.lazy;

/**
 * @Author: maosen
 * @Description: 懒汉式单例2 双重检查
 * @Date: Created in 2020/4/12 9:43.
 */
public class LazySingleton02 {

    //变量添加volatile关键字,消除指令重排序
    private static volatile LazySingleton02 instance;

    private LazySingleton02(){

    }

    //双重检查，减小锁粒度，保证线程安全
    public LazySingleton02 getInstance(){
        if(instance == null){
            synchronized (LazySingleton02.class){
                if(instance == null){
                    instance = new LazySingleton02();
                }
            }
        }
        return instance;
    }
}
