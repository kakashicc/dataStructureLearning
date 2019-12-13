package com.daojia.datastructures.learn.sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2019/12/12 17:16.
 */
public class SortTest {

    public static void main(String[] args) {
        testSort();
       /* int[] a = gennerateArray(100000, 100);
        long startTime = System.currentTimeMillis();
        *//*System.out.println("Sort-before：     "+ Arrays.toString(a));
        bubbleSort(a);
        System.out.println("bubbleSort-after："+ Arrays.toString(a));
        selectSort(a);
        System.out.println("selectSort-after："+ Arrays.toString(a));*//*
        insertSort(a);
        System.out.println("insertSort-after："+ Arrays.toString(a));
        long endTime = System.currentTimeMillis();
        System.out.println("耗时："+(endTime-startTime)+"ms");*/
    }

    /**
     * bubble sort
     *
     * @param a
     */
    public static void bubbleSort(int[] a) {
        int tmp;
        boolean changeFlag = false;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                    changeFlag = true;
                }
            }
            //无交换,提前结束循环
            if (!changeFlag) {
                break;
            }
        }
    }

    /**
     * select sort
     *
     * @param a
     */
    public static void selectSort(int[] a) {
        int temp;
        for (int i = 0; i < a.length - 1; i++) {
            int tmp = i;
            boolean changeFlag = false;
            for (int j = i + 1; j < a.length; j++) {
                if (a[tmp] > a[j]) {
                    tmp = j;
                    changeFlag = true;
                }
            }
            if (changeFlag) {
                temp = a[tmp];
                a[tmp] = a[i];
                a[i] = temp;
            }
        }
    }

    public static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int value = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > value) {
                a[j + 1] = a[j];
                --j;
            }
            a[j + 1] = value;
        }
    }

    public static void insertSort2(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                }
            }
            a[j + 1] = value;
        }
    }

    /**
     * 生成随机数组
     *
     * @param len 数组长度
     * @param max 数组最大值
     * @return
     */
    public static int[] gennerateArray(int len, int max) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max);
        }
        return arr;
    }

    public static void testSort() {
        for (int i = 0; i < 2000; i++) {
            int[] a = gennerateArray(i, i + 1000);
            int[] b = Arrays.copyOf(a, a.length);
            insertSort(a);
            Arrays.sort(b);
            if (!Arrays.equals(a, b)) {
                System.out.println("数组不相等 a=" + Arrays.toString(a));
                System.out.println("a=" + Arrays.toString(a));
                System.out.println("b=" + Arrays.toString(b));
                return;
            }
        }

        int a1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] b1 = Arrays.copyOf(a1, a1.length);
        insertSort(a1);
        Arrays.sort(b1);
        if (!Arrays.equals(a1, b1)) {
            System.out.println("数组不相等 a1=" + Arrays.toString(a1));
            System.out.println("a1=" + Arrays.toString(a1));
            System.out.println("b1=" + Arrays.toString(b1));
            return;
        }

        int a2[] = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] b2 = Arrays.copyOf(a2, a2.length);
        insertSort(a2);
        Arrays.sort(b2);
        if (!Arrays.equals(a2, b2)) {
            System.out.println("数组不相等 a2=" + Arrays.toString(a2));
            System.out.println("a2=" + Arrays.toString(a2));
            System.out.println("b2=" + Arrays.toString(b2));
            return;
        }

        System.out.println("排序方法校验通过");
    }
}
