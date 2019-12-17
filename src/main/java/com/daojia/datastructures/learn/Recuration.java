package com.daojia.datastructures.learn;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2019/12/11 18:59.
 */
public class Recuration {

    public static void main(String[] args) {
        /*System.out.println(getNumber(1));
        System.out.println(getNumber(2));
        System.out.println(getNumber(3));
        System.out.println(getNumber(4));
        System.out.println(getNumber2(4));*/

        //System.out.println(getStep1(50));
        System.out.println(getStep2(50));
    }

    public static int getNumber(int n) {
        if (n == 1) {
            return 1;
        }
        return getNumber(n - 1) + 1;
    }

    public static int getNumber2(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += 1;
        }
        return result;
    }

    public static int getStep1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return getStep1(n - 1) + getStep1(n - 2);
    }

    public static int getStep2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int result = 0;
        int little = 1;
        int big = 2;
        for (int i = 3; i <= n; i++) {
            result = little+big;
            little = big;
            big = result;
        }
        return result;
    }
}
