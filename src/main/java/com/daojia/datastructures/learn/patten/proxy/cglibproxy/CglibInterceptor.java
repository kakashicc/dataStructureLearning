package com.daojia.datastructures.learn.patten.proxy.cglibproxy;

import com.daojia.datastructures.learn.patten.proxy.staticproxy.Person;
import com.daojia.datastructures.learn.patten.proxy.staticproxy.Son;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.Method;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2020/4/12 22:27.
 */
public class CglibInterceptor implements MethodInterceptor{

    private Person target;

    public Object getInstance(Person person){
        this.target = person;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(person.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }


    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("增强之前");
        Object result = methodProxy.invokeSuper(o, objects);
        //Object result = method.invoke(target, objects);
        System.out.println("增强之后");
        return result;
    }
}
