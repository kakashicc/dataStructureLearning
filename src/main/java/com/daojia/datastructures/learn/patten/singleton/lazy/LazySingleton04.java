package com.daojia.datastructures.learn.patten.singleton.lazy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: maosen
 * @Description: 懒汉式单例4 注册登记式
 * @Date: Created in 2020/4/12 9:43.
 */
public class LazySingleton04 {

    private static Map<String,Object> iocMap = new ConcurrentHashMap<>();

    private LazySingleton04(){

    }

    public static Object getInstance(String name){
        if(!iocMap.containsKey(name)){
            synchronized (iocMap){
                if(!iocMap.containsKey(name)){
                    try {
                        Class<?> aClass = Class.forName(name);
                        iocMap.put(name,aClass.newInstance());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return iocMap.get(name);
    }


}
