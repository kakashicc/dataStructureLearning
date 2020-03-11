package com.daojia.datastructures.learn.sort;

import sun.management.snmp.util.MibLogger;
import sun.reflect.generics.reflectiveObjects.LazyReflectiveObjectGenerator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ForkJoinPool;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2019/12/12 17:16.
 */
@SuppressWarnings("all")
public class SortTest {

    public static void main(String[] args) throws Exception {
       /* BigDecimal decimal = new BigDecimal("5");
        System.out.println(squrtTest(decimal));
        System.out.println(Math.sqrt(decimal.doubleValue()));

        System.out.println(squrtTest2(decimal.doubleValue()));*/
        int[] a = {1, 2, 3, 4, 5, 5,6};
        int k = 8;
        System.out.println(binarySearch(a, k));
        System.out.println("fisrtIndex:"+getFirstEqualsWithBinarySearch(a,k));
        System.out.println("lastIndex:"+getLastEqualsWithBinarySearch(a,k));
        System.out.println("lastEqualsOrLowerIndex:"+getLastEqualsOrLowerWithBinarySearch(a,k));
        /*for (int k = 1; k <= 10; k++) {
            int[] a = gennerateArray(10, 100);
           *//* a = new int[]{3,1,2};
            k=3;*//*
            int maxKValue = getMaxKValue(a, k);
            Arrays.sort(a);
            System.out.println("arr=" + Arrays.toString(a));
            System.out.println("第" + k + "大的元素为：" + maxKValue);
        }*/
//        String methodName = "bubbleSort";
            //System.out.println("第"+k+"大的元素为："+maxKValue);

        //String methodName = "bubbleSort";
//        String methodName = "selectSort";
//        String methodName = "insertSort";
//        String methodName = "mergeSort";
//        String methodName = "quickSort";
        String methodName = "bucketSort";
//        String methodName = "quickSort";
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
     * quick sort
     *
     * @param a
     */
    public static void quickSort(int[] a) {
        quickSortInternally(a, 0, a.length - 1);
    }

    private static void quickSortInternally(int[] a, int p, int r) {
        //递归终止条件
        if (p >= r) {
            return;
        }
        //获取中间元素index
        int q = partition2(a, p, r);
        quickSortInternally(a, p, q - 1);
        quickSortInternally(a, q + 1, r);
    }

    /**
     * 左右分组
     *
     * @param a
     * @param p
     * @param r
     * @return
     */
    private static int partition(int[] a, int left, int right) {
        //取最后一个元素作为基准点
        int pivot = a[right];
        //i指向大值,j指向小值
        int i = left;
        for (int j = left; j < right; j++) {
            if (a[j] < pivot) {
                if (i == j) {
                    //相同，不交换
                    i++;
                } else {
                    //指向不同，交换值
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    i++;
                }
            }
        }
        //循环遍历完成后,交换pivot位置
        int temp = a[i];
        a[i] = pivot;
        a[right] = temp;
        //返回参照元素索引
        return i;
    }

    private static int partition2(int[] a, int left, int right) {
        //取最后一个元素作为基准点
        int pivot = a[right];
        //i指向左边值,j指向右边值
        int i = left;
        int j = right - 1;

        while (true) {
            //左标记大于参照值 || 左标记到最右边时,循环停止
            while (a[i] <= pivot && i < right) {
                i++;
            }
            //右标记小于等于参照值 ||右标记与左标记重合时,循环停止
            while (a[j] > pivot && j > i) {
                j--;
            }

            if (i == j || i == right) {
                //标记汇合 或者 左标记到达最右边 循环停止
                int temp = a[i];
                a[i] = pivot;
                a[right] = temp;
                break;
            }

            if (i != j) {
                //循环未停止 只交换值
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }

        }
        //返回参照元素索引
        return i;
    }

    public static int getMaxKValue(int[] a, int k) {
        if (k > a.length || k <= 0) {
            throw new RuntimeException("参数异常");
        }
        return getMaxKValueInternally(a, 0, a.length - 1, k);
    }

    public static int getMaxKValueInternally(int[] a, int left, int right, int k) {
        //获取参照index
        int q = partition(a, left, right);
        if (right - q >= k) {
            //处理右边部分
            left = q + 1;
        } else if (right - q + 1 == k) {
            //
            return a[q];
        } else {
            //处理左边部分
            k = k - (right - q + 1);
            right = q - 1;
        }
        return getMaxKValueInternally(a, left, right, k);
    }

    /**
     * 桶排序
     *
     * @param a
     */
    public static void bucketSort(int[] a) {
        //提前结束条件
        if (a.length <= 1) {
            return;
        }

        /**
         * 每个桶容量
         */
        int bucketSize = 10;

        //获取数组值范围
        int minValue = a[0];
        int maxValue = a[0];

        for (int i = 0; i < a.length; i++) {
            if (minValue > a[i]) {
                minValue = a[i];
            } else if (maxValue < a[i]) {
                maxValue = a[i];
            }
        }
        //获得桶数量
        int bucketCount = (maxValue - minValue) / bucketSize + 1;

        //桶数据 二维数组
        int[][] buckets = new int[bucketCount][bucketSize];
        // 一维数组index
        int[] indexArr = new int[bucketCount];

        //将值分配到不同的桶中
        for (int i = 0; i < a.length; i++) {
            //获取桶index
            int bucketIndex = (a[i] - minValue) / bucketSize;
            //桶扩容
            if (indexArr[bucketIndex] == buckets[bucketIndex].length) {
                ensureCapacity(buckets, bucketIndex);
            }
            //分配
            buckets[bucketIndex][indexArr[bucketIndex]] = a[i];
            indexArr[bucketIndex]++;
        }

        //对每个桶进行快排
        int k = 0;
        for (int i = 0; i < bucketCount; i++) {
            if (indexArr[i] == 0) {
                continue;
            }
            //对桶进行快排
            quickSortInternally(buckets[i], 0, indexArr[i] - 1);
            for (int j = 0; j < indexArr[i]; j++) {
                a[k++] = buckets[i][j];
            }
        }
    }

    public static int binarySearch(int[] a, int k) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int middle = (right + left) / 2;
            if (a[middle] == k) {
                return middle;
            } else if (a[middle] > k) {
                right = middle - 1;
            } else if (a[middle] < k) {
                left = middle + 1;
            }
        }
        return -1;
    }

    public static int getFirstEqualsWithBinarySearch(int[] a, int k){
        int left = 0;
        int right = a.length - 1;
        int targetIndex = -1;
        while (left <= right) {
            int middle = (right + left) / 2;
            if (a[middle] == k) {
                targetIndex = middle;
                right = middle-1;
            } else if (a[middle] > k) {
                right = middle - 1;
            } else if (a[middle] < k) {
                left = middle + 1;
            }
        }
        return targetIndex;
    }

    public static int getLastEqualsWithBinarySearch(int[] a, int k){
        int left = 0;
        int right = a.length - 1;
        int targetIndex = -1;
        while (left <= right) {
            int middle = (right + left) / 2;
            if (a[middle] == k) {
                targetIndex = middle;
                left = middle+1;
            } else if (a[middle] > k) {
                right = middle - 1;
            } else if (a[middle] < k) {
                left = middle + 1;
            }
        }
        return targetIndex;
    }

    public static int getLastEqualsOrLowerWithBinarySearch(int[] a, int k){
        int left = 0;
        int right = a.length - 1;
        int targetIndex = -1;
        while (left <= right) {
            int middle = (right + left) / 2;
            if (a[middle] <= k) {
                targetIndex = middle;
                right = middle - 1;
            } else if (a[middle] > k) {
                right = middle - 1;
            }
        }
        return targetIndex;
    }

    public static BigDecimal squrtTest(BigDecimal a) {
        BigDecimal left = BigDecimal.ZERO;
        BigDecimal right = a;
        BigDecimal c = (left.add(right)).divide(new BigDecimal("2"));
        System.out.println(a.subtract(c.multiply(c)));
        BigDecimal b;
        while (true) {
            b = (left.add(right)).divide(new BigDecimal("2"));
            if ((a.subtract(b.multiply(b)).compareTo(new BigDecimal("0")) > 0) && (a.subtract(b.multiply(b)).compareTo(new BigDecimal("0.000001")) < 0)) {
                break;
            }
            if (b.multiply(b).equals(a)) {
                return b;
            } else if (b.multiply(b).compareTo(a) > 0) {
                right = b.add(new BigDecimal("0.000001"));
            } else {
                left = b.subtract(new BigDecimal("0.000001"));
                ;
            }
        }
        return b;
    }

    public static double squrtTest2(double a) {
        double left = 0.0;
        double right = a;
        double middle = (left + right) / 2;
        ;
        while (Math.abs(a - middle * middle) > 0.000001) {
            middle = (left + right) / 2;
            if (a == middle) {
                break;
            }else if(a > middle*middle){
                left = middle;
            }else{
                right = middle;
            }
        }
        return middle;
    }

    /**
     * 容量扩展
     *
     * @param buckets
     * @param bucketIndex
     */
    private static void ensureCapacity(int[][] buckets, int bucketIndex) {
        int[] tempArr = buckets[bucketIndex];
        int[] newArr = new int[tempArr.length * 2];
        for (int i = 0; i < tempArr.length; i++) {
            newArr[i] = tempArr[i];
        }
        buckets[bucketIndex] = newArr;
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
