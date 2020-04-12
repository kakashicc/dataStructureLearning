package com.daojia.datastructures.learn.patten.proxy.staticproxy;

import com.daojia.datastructures.learn.patten.proxy.cglibproxy.CglibInterceptor;
import com.daojia.datastructures.learn.patten.proxy.jdkproxy.JDKProxy;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2020/4/12 19:55.
 */
public class ProxyTest {

    public static void main(String[] args) {
        /*Father father = new Father(new Son());
        father.getLove();
        father.getJob();*/

        JDKProxy proxy = new JDKProxy();
        Person person = (Person)proxy.getInstance(new Son());
        person.getJob();

        /*Person person = (Person)new CglibInterceptor().getInstance(new Son());
        person.getJob();*/
    }
}
