package com.daojia.datastructures.learn.singleton;

/**
 * @Author: maosen
 * @Description: lazy double-check
 * @Date: Created in 2019/11/19 15:33.
 */
public class LazySingleton1 {

    private static volatile LazySingleton1 instance = null;

    private LazySingleton1(){

    }

    public static LazySingleton1 getInstance(){
        if(instance == null){
            synchronized (LazySingleton1.class){
                if(instance == null){
                    instance = new LazySingleton1();
                }
            }
        }
        return instance;
    }
}
