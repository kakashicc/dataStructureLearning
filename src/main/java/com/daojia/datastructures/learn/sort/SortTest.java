package com.daojia.datastructures.learn.sort;

import java.util.Arrays;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2019/12/12 17:16.
 */
public class SortTest {

    public static void main(String[] args) {
        int[] a = gennerateArray(0, 100);
        System.out.println("排序前："+ Arrays.toString(a));
        bubbleSort(a);
        System.out.println("排序后："+ Arrays.toString(a));
    }

    public static void bubbleSort(int[] a) {
        if (a.length == 1) {
            return;
        }
        int tmp;
        boolean changeFlag = false;
        for (int i = 0; i < a.length-1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                    changeFlag = true;
                }
            }
            //无交换,提前结束循环
            if(!changeFlag){
                break;
            }
        }
    }

    public static int[] gennerateArray(int len, int max) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max);
        }
        return arr;
    }
}
