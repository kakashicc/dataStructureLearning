package com.daojia.datastructures.learn.patten.proxy.staticproxy;

import javax.sound.midi.Soundbank;

/**
 * @Author: maosen
 * @Description: 静态代理类
 * @Date: Created in 2020/4/12 19:46.
 */
public class Father implements Person{

    private Person person;

    public Father(Person person){
        this.person = person;
    }

    @Override
    public void getJob() {
        System.out.println("代理帮忙投简历");
        person.getJob();
        System.out.println("代理帮忙办入职");
    }

    @Override
    public void getLove() {
        System.out.println("代理帮忙找对象");
        person.getLove();
        System.out.println("代理帮忙办结婚证");
    }


}
