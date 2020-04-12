package com.daojia.datastructures.learn.patten.proxy.staticproxy;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2020/4/12 19:46.
 */
public class Son implements Person{

    /**
     * 谈恋爱方法
     */
    @Override
    public void getLove(){
        System.out.println("son 谈恋爱");
    }

    /**
     * 找工作
     */
    @Override
    public void getJob(){
        System.out.println("son 找工作");
    }
}
