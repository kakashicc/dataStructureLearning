package com.daojia.datastructures.learn.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.SQLOutput;
import java.util.concurrent.Delayed;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2019/11/13 19:12.
 */
public class ReflectClass {

    private final static String TAG = "peter.log.ReflectClass";

    /**
     * 反射直接创建对象
     */
    public static void reflectNewInstance(){
        try{
            Class<?> bookClass = Class.forName("com.daojia.datastructures.learn.reflect.Book");
            Book book = (Book)bookClass.newInstance();
            book.setAuthor("aa");
            book.setName("反射创建对象");
            System.out.println(book);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 反射默认构造方法
     */
    public static void reflectConstructor(){
        try{
            Class<?> bookClass = Class.forName("com.daojia.datastructures.learn.reflect.Book");


            Book book = (Book)bookClass.newInstance();
            book.setAuthor("aa");
            book.setName("反射创建对象");
            System.out.println(book);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        //reflectNewInstance();
        Class<?> bookClass = Class.forName("com.daojia.datastructures.learn.reflect.Book");
        //转换对象
        System.out.println("bookClass转换对象");
        Book bk = (Book)bookClass.cast(new Book());
        System.out.println(bk);
        //获得类加载器
        System.out.println("获得类加载器");
        ClassLoader classLoader = bookClass.getClassLoader();
        System.out.println(classLoader.loadClass("com.daojia.datastructures.learn.reflect.Book").getName());
        //获取类路径
        System.out.println("获取类路径");
        System.out.println(bookClass.getPackage());
        //获得类名字
        System.out.println("获得类名字");
        System.out.println(bookClass.getSimpleName());
        //获得对象
        Book book = (Book)bookClass.newInstance();
        //获得所有公有构造方法
        System.out.println("获得所有公有构造方法");
        Constructor<?>[] constructors = bookClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.toGenericString());
        }
        //获得所有构造方法
        System.out.println("获得所有构造方法");
        Constructor<?>[] declaredConstructors = bookClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor.toGenericString());
        }
        //获得指定公有构造方法
        System.out.println("获得指定公有构造方法");
        Constructor<?> constructor = bookClass.getConstructor();
        System.out.println(constructor.toGenericString());
        //获得指定私有构造方法
        System.out.println("获得指定私有构造方法");
        Constructor<?> privateConstructor = bookClass.getDeclaredConstructor(String.class, String.class);
        System.out.println(privateConstructor.toGenericString());
        //公有构造方法获取对象
        Book book1 = (Book) constructor.newInstance();
        System.out.println("book1"+book1);

        //私有构造方法获取对象  必须设置Accessible属性
        privateConstructor.setAccessible(true);
        Book book2 = (Book) privateConstructor.newInstance("bbb","私有构造方法获取对象");
        System.out.println("book2"+book2);

        //获得公有属性列表
        System.out.println("获得公有属性列表");
        Field[] fields = bookClass.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        //获得所有属性列表
        System.out.println("获得所有属性列表");
        Field[] declaredFields = bookClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field.getName());
        }

        //获得指定属性
        Field fieldAuthor = bookClass.getDeclaredField("author");
        fieldAuthor.setAccessible(true);
        fieldAuthor.set(book,"aaaaaaaaa");
        System.out.println(fieldAuthor.getName());
        System.out.println(book);

    }
}
