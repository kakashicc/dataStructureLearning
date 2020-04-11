package com.daojia.datastructures.learn.datastructure.a11_sorts;

import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2019/12/12 17:16.
 */
@SuppressWarnings("all")
public class SortTest {

    public static void test(int i){
        try {
            Thread.currentThread().sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i);
        test(i+1);
    }

    public static void main(String[] args) throws Exception {

      test(1);

//        String methodName = "bubbleSort";
//        String methodName = "selectSort";
//        String methodName = "insertSort";
//        String methodName = "mergeSort";
        String methodName = "quickSort";
//        String methodName = "bucketSort";
//        String methodName = "quickSort";
        testSort(methodName);
    }

    public static void testSort(String methodName) throws Exception {
        SortTest st = SortTest.class.newInstance();
        Method method = st.getClass().getMethod(methodName, int[].class);
        testSort(st, method);
    }


    /**
     * bubble sort  原地排序、稳定排序
     * 时间复杂度最好O(n)、最坏O(n²)、平均O(n²)
     *
     * @param a
     */
    public static void bubbleSort(int[] a) {
        int temp;
        for (int i = 0; i < a.length - 1; i++) {
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
     * select sort  原地排序、非稳定排序
     * 时间复杂度最好O(n²)、最坏O(n²)、平均O(n²)
     *
     * @param a
     */
    public static void selectSort(int[] a) {
        int tmp;
        for (int i = 0; i < a.length - 1; i++) {
            tmp = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[tmp] > a[j]) {
                    tmp = j;
                }
            }
            if (tmp != i) {
                //change
                int temp = a[i];
                a[i] = a[tmp];
                a[tmp] = temp;
            }
        }

    }

    /**
     * insert sort 原地排序、稳定排序
     * 时间复杂度最好O(n)、最坏O(n²)、平均O(n²)
     *
     * @param a
     */
    public static void insertSort(int[] a) {
        //遍历未排序列表
        for (int i = 1; i < a.length; i++) {
            //未排序值
            int value = a[i];
            //前一个值
            int j = i - 1;
            while (j >= 0 && a[j] > value) {
                //前一个元素后移一位
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = value;
        }
    }

    /**
     * 归并排序   非原地排序、稳定排序
     * 时间复杂度最好O(nlogn)、最坏O(nlogn)、平均O(nlogn)
     *
     * @param a
     */
    public static void mergeSort(int[] a) {
        mergeSortInternally(a, 0, a.length - 1);
    }

    /**
     * 递归计算
     *
     * @param a
     * @param p
     * @param r
     */
    private static void mergeSortInternally(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = (p + r) / 2;
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q + 1, r);
        //普通处理
        //merge(a, p, q, r);
        //哨兵模式处理
        mergeBySentry(a, p, q, r);
    }


    /**
     * 合并两个有序数组
     *
     * @param a 原数组
     * @param p 起始位置
     * @param q 结束位置
     * @param r 最终结束位置
     */
    private static void merge(int[] a, int p, int q, int r) {
        int[] temp = new int[r - p + 1];
        int head1 = p;
        int head2 = q + 1;
        int i = 0;
        while (head1 <= q && head2 <= r) {
            if (a[head1] <= a[head2]) {
                temp[i] = a[head1];
                head1++;
            } else {
                temp[i] = a[head2];
                head2++;
            }
            i++;
        }
        if (head1 > q) {
            //把head2剩下的赋值给temp
            for (; head2 <= r; head2++) {
                temp[i] = a[head2];
                i++;
            }
        } else {
            //把head1剩下的赋值给temp
            for (; head1 <= q; head1++) {
                temp[i] = a[head1];
                i++;
            }
        }

        //把temp赋值回a数组
        for (int j = 0; j < r - p + 1; j++) {
            a[p + j] = temp[j];
        }
    }

    /**
     * 哨兵模式处理有序数组合并
     *
     * @param a
     * @param p
     * @param q
     * @param r
     */
    private static void mergeBySentry(int[] a, int p, int q, int r) {
        int[] leftArray = new int[q - p + 2];
        int[] rightArray = new int[r - q + 1];
        //左边数组赋值
        for (int i = 0; i < leftArray.length - 1; i++) {
            leftArray[i] = a[p + i];
        }
        leftArray[leftArray.length - 1] = Integer.MAX_VALUE;
        //右边数组赋值
        for (int i = 0; i < rightArray.length - 1; i++) {
            rightArray[i] = a[q + 1 + i];
        }
        rightArray[rightArray.length - 1] = Integer.MAX_VALUE;

        int j = 0;
        int k = 0;
        int m = p;
        while (m <= r) {
            if (leftArray[j] <= rightArray[k]) {
                a[m++] = leftArray[j++];
            } else {
                a[m++] = rightArray[k++];
            }
        }
    }

    /**
     * quick sort  原地排序、稳定排序
     * 时间复杂度最好O(nlogn)、最坏O(n²)、平均O(nlogn)
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
        //int q = partition(a, p, r);
        int q = partition2(a, p, r);
        quickSortInternally(a, p, q - 1);
        quickSortInternally(a, q + 1, r);
    }


    /**
     * 左右分区，返回中间节点
     *
     * @param a
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] a, int left, int right) {
        //参照节点
        int pivot = a[right];
        //找大数
        int bigIndex = left;
        for (int littleIndex = left; littleIndex < right; littleIndex++) {
            if (a[littleIndex] < pivot) {
                //找到比pivot小的数，准备进行交换操作
                if (bigIndex == littleIndex) {
                    //未找到比pivot大的数,大数索引向右移动
                    bigIndex++;
                } else {
                    //交换大小数,大数索引向右移动
                    int temp = a[bigIndex];
                    a[bigIndex] = a[littleIndex];
                    a[littleIndex] = temp;
                    bigIndex++;
                }
            }
        }
        //遍历完成后,交换pivot和bigIndex值
        int temp = a[bigIndex];
        a[bigIndex] = a[right];
        a[right] = temp;
        return bigIndex;
    }


    private static int partition2(int[] a, int left, int right) {
        //最后节点为参照点
        int pivot = a[right];
        //从左边开始找比pivot大的节点
        int bigIndex = left;
        //从右边开始找比pivot小的节点
        int littleIndex = right - 1;
        while (true) {
            while (a[bigIndex] <= pivot && bigIndex < right) {
                bigIndex++;
            }
            while (a[littleIndex] > pivot && littleIndex > bigIndex) {
                littleIndex--;
            }
            if (littleIndex == bigIndex || bigIndex == right) {
                //循环终止条件达到
                int temp = a[bigIndex];
                a[bigIndex] = a[right];
                a[right] = temp;
                break;
            } else {
                //交换大小值
                int temp = a[bigIndex];
                a[bigIndex] = a[littleIndex];
                a[littleIndex] = temp;
            }
        }
        return bigIndex;
    }

    /**
     * 左右分组
     *
     * @param a
     * @param p
     * @param r
     * @return
     */
   /* private static int partition(int[] a, int left, int right) {
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
    }*/

    /*private static int partition2(int[] a, int left, int right) {
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
    }*/
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

    public static int getFirstEqualsWithBinarySearch(int[] a, int k) {
        int left = 0;
        int right = a.length - 1;
        int targetIndex = -1;
        while (left <= right) {
            int middle = (right + left) / 2;
            if (a[middle] == k) {
                targetIndex = middle;
                right = middle - 1;
            } else if (a[middle] > k) {
                right = middle - 1;
            } else if (a[middle] < k) {
                left = middle + 1;
            }
        }
        return targetIndex;
    }

    public static int getLastEqualsWithBinarySearch(int[] a, int k) {
        int left = 0;
        int right = a.length - 1;
        int targetIndex = -1;
        while (left <= right) {
            int middle = (right + left) / 2;
            if (a[middle] == k) {
                targetIndex = middle;
                left = middle + 1;
            } else if (a[middle] > k) {
                right = middle - 1;
            } else if (a[middle] < k) {
                left = middle + 1;
            }
        }
        return targetIndex;
    }

    public static int getLastEqualsOrLowerWithBinarySearch(int[] a, int k) {
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
            } else if (a > middle * middle) {
                left = middle;
            } else {
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
