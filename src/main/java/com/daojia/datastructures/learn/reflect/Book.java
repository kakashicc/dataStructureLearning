package com.daojia.datastructures.learn.reflect;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2019/11/13 19:10.
 */
public class Book {

    /**
     * 私有静态变量
     */
    private final static String TAG = "BookTag";

    /**
     * 私有变量name
     */
    private String name;

    /**
     * 私有变量 author
     */
    private String author;


    /**
     * 默认构造方法
     */
    public Book() {
    }

    /**
     * 私有构造方法
     * @param name
     * @param author
     */
    private Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    /**
     * 共有方法
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 共有方法
     * @return
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 共有方法
     * @return
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 共有方法
     * @return
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 私有方法
     * @return
     */
    private String declaredMethod(int index) {
        String string = null;
        switch (index) {
            case 0:
                string = "I am declaredMethod 1 !";
                break;
            case 1:
                string = "I am declaredMethod 2 !";
                break;
            default:
                string = "I am declaredMethod 1 !";
        }

        return string;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
