package com.daojia.datastructures.learn.patten.proxy.jdkproxy;

import com.daojia.datastructures.learn.patten.proxy.staticproxy.Person;
import com.daojia.datastructures.learn.patten.proxy.staticproxy.Son;

import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2020/4/12 20:48.
 */
public class JDKProxy implements InvocationHandler{

    /**
     * 被代理对象
     */
    private Person target;

    public Person getInstance(Person person){
        this.target = person;
        Class<? extends Person> targetClass = person.getClass();
        Person result = (Person)Proxy.newProxyInstance(targetClass.getClassLoader(), targetClass.getInterfaces(), this);
        return result;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进行动态代理之前");
        Object invoke = method.invoke(target, args);
        System.out.println("进行动态代理之后");
        return invoke;
    }
}
