package com.daojia.datastructures.learn.sort;

import sun.reflect.generics.reflectiveObjects.LazyReflectiveObjectGenerator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2019/12/12 17:16.
 */
@SuppressWarnings("all")
public class SortTest {

    public static void main(String[] args) throws Exception {
//        String methodName = "bubbleSort";
//        String methodName = "selectSort";
//        String methodName = "insertSort";
        String methodName = "mergeSort";
//        String methodName = "bubbleSort";
        SortTest st = SortTest.class.newInstance();
        Method method = st.getClass().getMethod(methodName, int[].class);
        testSort(st, method);
        /*int[] a = gennerateArray(20000, 100);
        long startTime = System.currentTimeMillis();
        System.out.println("Sort-before：     " + Arrays.toString(a));
       *//* bubbleSort(a);
        System.out.println("bubbleSort-after："+ Arrays.toString(a));*//*
         *//* selectSort(a);
        System.out.println("selectSort-after："+ Arrays.toString(a));*//*
        insertSort2(a);
        System.out.println("insertSort-after：" + Arrays.toString(a));
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");*/
    }

    /**
     * bubble sort
     *
     * @param a
     */
    public static void bubbleSort(int[] a) {
        int temp;
        for (int i = 0; i < a.length - 2; i++) {
            boolean changeFlag = false;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    changeFlag = true;
                }
            }
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

    /**
     * insert sort
     *
     * @param a
     */
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

    /**
     * merge sort
     *
     * @param a
     */
    public static void mergeSort(int[] a) {
        mergeSortInternally(a, 0, a.length - 1);
    }

    /**
     * 递归计算
     *
     * @param a 数组
     * @param p 开始位置
     * @param r 结束位置
     */
    private static void mergeSortInternally(int[] a, int p, int r) {
        //递归终止条件
        if (p >= r) {
            return;
        }
        //取中间值递归
        int q = p + (r - p) / 2;
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q + 1, r);
        //合并排序数组
        //merge(a,p,q,r);
        mergeBySentry(a, p, q, r);
    }

    /**
     * 合并排序数组
     *
     * @param a
     * @param p
     * @param q
     * @param r
     */
    private static void merge(int[] a, int p, int q, int r) {
        //建立临时数组获取有序数据
        int i = p;
        int j = q + 1;
        int k = 0;
        int[] temp = new int[r - p + 1];
        //临时数组赋值
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        //剩余数组赋值
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end) {
            temp[k++] = a[start++];
        }

        //数组复制回来
        for (int m = 0; m < r - p + 1; m++) {
            a[p + m] = temp[m];
        }
    }

    /**
     * 哨兵模式合并数组
     *
     * @param a
     * @param p
     * @param q
     * @param r
     */
    public static void mergeBySentry(int[] a, int p, int q, int r) {
        //建立两个临时数组
        int[] leftArr = new int[q - p + 2];
        int[] rightArr = new int[r - q + 1];

        //左边数组赋值
        for (int i = 0; i < leftArr.length - 1; i++) {
            leftArr[i] = a[p + i];
        }
        leftArr[q - p + 1] = Integer.MAX_VALUE;

        //右边数组赋值
        for (int i = 0; i < rightArr.length - 1; i++) {
            rightArr[i] = a[q + 1 + i];
        }
        rightArr[r - q] = Integer.MAX_VALUE;

        //排序获取
        int i = 0;
        int j = 0;
        int k = p;
        while (k <= r) {
            if (leftArr[i] <= rightArr[j]) {
                a[k++] = leftArr[i++];
            } else {
                a[k++] = rightArr[j++];
            }
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

    public static void testSort(SortTest st, Method sortMethod) throws InvocationTargetException, IllegalAccessException {
        for (int i = 0; i < 2000; i++) {
            int[] origin = gennerateArray(i, i + 1000);
            int[] a = Arrays.copyOf(origin, origin.length);
            int[] b = Arrays.copyOf(origin, origin.length);
            sortMethod.invoke(st, a);
            Arrays.sort(b);
            if (!Arrays.equals(a, b)) {
                System.out.println("validate faild ===================== MethodName:" + sortMethod.getName());
                System.out.println("origin arr=" + Arrays.toString(origin));
                System.out.println("right sort=" + Arrays.toString(b));
                System.out.println("your  sort=" + Arrays.toString(a));
                return;
            }
        }

        int origin1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] a1 = Arrays.copyOf(origin1, origin1.length);
        int[] b1 = Arrays.copyOf(origin1, origin1.length);
        sortMethod.invoke(st, a1);
        Arrays.sort(b1);
        if (!Arrays.equals(a1, b1)) {
            System.out.println("validate faild ===================== MethodName:" + sortMethod.getName());
            System.out.println("origin arr=" + Arrays.toString(origin1));
            System.out.println("right sort=" + Arrays.toString(b1));
            System.out.println("your  sort=" + Arrays.toString(a1));
            return;
        }

        int origin2[] = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] a2 = Arrays.copyOf(origin2, origin2.length);
        int[] b2 = Arrays.copyOf(origin2, origin2.length);
        sortMethod.invoke(st, a2);
        Arrays.sort(b2);
        if (!Arrays.equals(a2, b2)) {
            System.out.println("validate faild ===================== MethodName:" + sortMethod.getName());
            System.out.println("origin arr=" + Arrays.toString(origin1));
            System.out.println("right sort=" + Arrays.toString(b2));
            System.out.println("your  sort=" + Arrays.toString(a2));
            return;
        }

        System.out.println("validate success ===================== MethodName:" + sortMethod.getName());
    }
}
