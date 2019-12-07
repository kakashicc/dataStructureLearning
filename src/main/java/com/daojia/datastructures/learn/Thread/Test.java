package com.daojia.datastructures.learn.Thread;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2019/11/24 21:38.
 */
public class Test {

    private static class MyObj {
        int i;

        public MyObj(int i) {
            this.i = i;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MyObj myObj = (MyObj) o;

            return i == myObj.i;
        }

        @Override
        public int hashCode() {
            return i;
        }
    }

    private static AtomicReference<MyObj> atomicReference = new AtomicReference<>();

    public static void main(String[] args) {
        MyObj myObj = new MyObj(5);
        MyObj myObj1 = new MyObj(5);
        atomicReference.set(myObj);
        boolean result = atomicReference.compareAndSet(myObj1, new MyObj(6));
        System.out.println("atomicReference的比较并交换成功了么：" + result + " 结果是：" + atomicReference.get().i);
    }
}
