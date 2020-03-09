package com.daojia.datastructures.learn.datastructure.a05_array;

/**
 * @Author: maosen
 * @Description: ArrayList
 * @Date: Created in 2020/3/9 14:55.
 */
public class MyArrayList<T> {

    /**
     * 数据
     */
    private T[] data;

    /**
     * 数组大小
     */
    private int size;

    /**
     * 无参构造
     */
    public MyArrayList() {

    }

    /**
     * 有参构造
     *
     * @param capacity
     */
    public MyArrayList(int capacity) {
        if (capacity >= 0) {
            data = (T[]) new Object[capacity];
            size = 0;
        } else {
            throw new RuntimeException("Illegal Capacity:" + capacity);
        }
    }

    /**
     * 获取数组容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取当前元素个数
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 判断数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取index位置元素
     *
     * @param index
     * @return
     */
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    /**
     * 设置index位置元素,返回旧值
     *
     * @param index
     * @param e
     * @return
     */
    public T set(int index, T e) {
        checkIndex(index);
        T result = data[index];
        data[index] = e;
        return result;
    }

    /**
     * 查看数组是否包含元素e
     *
     * @param e
     * @return
     */
    public boolean contains(T e) {
        return getIndex(e) != -1;
    }

    /**
     * 获取对应元素下标
     *
     * @param e
     * @return
     */
    public int getIndex(T e) {
        if (e == null) {
            for (int i = 0; i < size; i++) {
                if (data[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (e.equals(data[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 在index位置,插入元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, T e) {
        checkAddIndex(index);
        if (index == data.length) {
            //扩容为当前数组2倍
            resize(data.length * 2);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }


    /**
     * 头插
     */
    public void addFirst(T e) {
        add(0, e);
    }

    /**
     * 尾插
     */
    public void addLast(T e) {
        add(size, e);
    }

    /**
     * 删除index位置元素,并返回
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        checkAddIndex(index);
        T result = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size - 1] = null;

        if (size == data.length / 4 && data.length / 2 != 0) {
            //扩容为当前数组2倍
            resize(data.length / 2);
        }
        return result;
    }

    /**
     * 删除第一个元素
     *
     * @return
     */
    public T removeFirst() {
        return remove(0);
    }

    /**
     * 删除末尾元素
     *
     * @return
     */
    public T removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除指定元素e
     *
     * @param e
     */
    public void removeElement(T e) {
        int index = getIndex(e);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 容量校验
     *
     * @param index 当前index
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("failed! Require index >= 0 and index < size");
        }
    }

    /**
     * 添加校验
     *
     * @param index
     */
    private void checkAddIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("add failed! Require index >= 0 and index <= size");
        }
    }

    /**
     * 扩容
     *
     * @param capacity
     */
    private void resize(int capacity) {
        T[] result = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            result[i] = data[i];
        }
        data = result;
    }
}
