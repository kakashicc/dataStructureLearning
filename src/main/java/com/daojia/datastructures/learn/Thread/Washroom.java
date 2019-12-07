package com.daojia.datastructures.learn.Thread;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2019/11/24 21:36.
 */
public class Washroom {

    private volatile boolean isAvailable = false;    //表示厕所是否是可用的状态

    private Object lock = new Object(); //厕所门的锁

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public Object getLock() {
        return lock;
    }
}
