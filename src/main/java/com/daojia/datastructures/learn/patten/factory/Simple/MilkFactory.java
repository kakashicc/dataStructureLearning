package com.daojia.datastructures.learn.patten.factory.Simple;

import com.daojia.datastructures.learn.patten.factory.MengNiuMilk;
import com.daojia.datastructures.learn.patten.factory.Milk;
import com.daojia.datastructures.learn.patten.factory.YiLiMilk;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2020/4/10 22:00.
 */
public class MilkFactory {

    /**
     * 获取牛奶
     * @param name 牛奶种类
     * @return
     */
    public Milk getMilk(String name){
        if("MengNiu".equals(name)){
            return new MengNiuMilk();
        }else if("YiLi".equals(name)){
            return new YiLiMilk();
        }else{
            throw new RuntimeException(name+" Milk is not exist");
        }
    }
}
