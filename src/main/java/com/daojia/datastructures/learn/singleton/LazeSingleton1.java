package com.daojia.datastructures.learn.singleton;

/**
 * @Author: maosen
 * @Description: lazy double-check
 * @Date: Created in 2019/11/19 15:33.
 */
public class LazeSingleton1 {

    private static volatile LazeSingleton1 instance = null;

    private LazeSingleton1(){

    }

    public static LazeSingleton1 getInstance(){
        if(instance == null){
            synchronized (LazeSingleton1.class){
                if(instance == null){
                    instance = new LazeSingleton1();
                }
            }
        }
        return instance;
    }
}
