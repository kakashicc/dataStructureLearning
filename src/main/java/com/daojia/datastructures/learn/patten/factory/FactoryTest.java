package com.daojia.datastructures.learn.patten.factory;

import com.daojia.datastructures.learn.patten.factory.Simple.MilkFactory;
import com.daojia.datastructures.learn.patten.factory.abstra.AbsMilkFactory;
import com.daojia.datastructures.learn.patten.factory.abstra2.MengNiuMilkFactory2;
import com.daojia.datastructures.learn.patten.factory.abstra2.YiLiMilkFactory2;
import com.daojia.datastructures.learn.patten.factory.fuc.MengNiuMilkFactory;
import com.daojia.datastructures.learn.patten.factory.fuc.YiLiMilkFactory;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @Author: maosen
 * @Description: 工厂模式测试类
 * @Date: Created in 2020/4/10 21:41.
 */
public class FactoryTest {

    public static void main(String[] args) {
        //1 普通模式  用户关心过程和结果 耦合严重
        MengNiuMilk mengNiuMilk = new MengNiuMilk();
        System.out.println(mengNiuMilk.getName());

        YiLiMilk yiLiMilk = new YiLiMilk();
        System.out.println(yiLiMilk.getName());

        //2 简单工厂模式  用户不关心过程,只关心结果 与 对象解耦,但是与工厂耦合
        // 每次扩展都需要修改工厂类  不符合开闭原则
        MilkFactory mf = new MilkFactory();
        Milk mengNiu = mf.getMilk("MengNiu");
        System.out.println(mengNiu.getName());
        Milk yiLi = mf.getMilk("YiLi");
        System.out.println(yiLi.getName());

        //3 工厂方法模式 符合开闭原则，但是生成了太多的工厂类
        Milk mnMilk = new MengNiuMilkFactory().getMilk();
        System.out.println(mnMilk.getName());

        Milk ylMilk = new YiLiMilkFactory().getMilk();
        System.out.println(ylMilk.getName());

        //4 抽象工厂模式  是这样吗？？？存疑
        AbsMilkFactory absMilkFactory = new AbsMilkFactory();
        Milk mengNiu1 = absMilkFactory.getMengNiu();
        System.out.println(mengNiu1.getName());
        Milk yiLi1 = absMilkFactory.getYiLi();
        System.out.println(yiLi1.getName());

        //5 抽象工厂模式  产品线 (多条产品线为抽象工厂，单条产品线为工厂方法)
        MengNiuMilkFactory2 mengNiuMilkFactory2 = new MengNiuMilkFactory2();
        System.out.println(mengNiuMilkFactory2.getMilk().getName());
        System.out.println(mengNiuMilkFactory2.getXiGuan().getName());

        YiLiMilkFactory2 yiLiMilkFactory2 = new YiLiMilkFactory2();
        System.out.println(yiLiMilkFactory2.getMilk().getName());
        System.out.println(yiLiMilkFactory2.getXiGuan().getName());
    }
}
