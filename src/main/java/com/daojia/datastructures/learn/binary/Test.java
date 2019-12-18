package com.daojia.datastructures.learn.binary;

import sun.java2d.pipe.OutlineTextRenderer;

import javax.swing.*;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: maosen
 * @Description:
 * @Date: Created in 2019/11/12 15:53.
 */
public class Test {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(7);
        list.add(5);
        list.add(6);
        list.add(4);

        System.out.println("普通stream");
        list.stream().forEach(x -> System.out.println(x));

        System.out.println("并发stream");
        list.parallelStream().forEach(System.out::println);

        System.out.println("过滤");
        list.parallelStream().filter(x -> x > 2).forEach(System.out::println);

        System.out.println("排序  --stream+forEach");
        list.stream().filter(x -> x >= 2).sorted().forEach(System.out::println);

        System.out.println("逆序  --parallelStream+forEachOrdered   此处直接用forEach是错误的");
        list.parallelStream().filter(x -> x >= 2).sorted(Comparator.reverseOrder()).forEachOrdered(System.out::println);

        System.out.println("转换");
        // 1. Array
        //String[] strArray1 = list.stream().toArray(String[]::new);
        // 2. Collection
        List<Integer> list1 = list.stream().collect(Collectors.toList());
        List<Integer> list2 = list.stream().collect(Collectors.toCollection(ArrayList::new));
        Set set1 = list.stream().collect(Collectors.toSet());
        Stack stack1 = list.stream().collect(Collectors.toCollection(Stack::new));
        // 3. String
        String str = list.stream().map(x -> x.toString()).collect(Collectors.joining());
        //求和
        System.out.println(list.stream().reduce(Integer::sum).get());
        //最大值
        System.out.println(list.stream().max(Integer::compareTo).get());
        //最大值
        System.out.println(list.stream().mapToInt(Integer::intValue).max().getAsInt());
        //去重
        System.out.println(list.stream().distinct().sorted());
        //字段去重
        //list.stream().filter(distinctByKey(b -> b.getName())).forEach(b -> System.out.println(b.getName()+ "," + b.getPrice()));







        /*Long userId = 1152191009978339328L;
        String userIdStr = Long.toBinaryString(userId);
        System.out.println(userIdStr.length());*/

       /* String text = null;
        Integer integer = Optional.ofNullable(text).map(String::length).orElse(-1);

        System.out.println(integer);*/
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Calendar> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Calendar startDay = new GregorianCalendar();
            Calendar checkDay = new GregorianCalendar();
            checkDay.setTime(startDay.getTime());//不污染入参
            checkDay.add(checkDay.DATE,i);
            list.add(checkDay);
            checkDay = null;
            startDay = null;
        }

        list.stream().forEach(day ->  System.out.println(sdf.format(day.getTime())));
        System.out.println("-----------------------");
        list.parallelStream().forEach(day ->  System.out.println(sdf.format(day.getTime())));
        System.out.println("-----------------------");*/
        /*int x = 0b01010110;
        int y = 0b00001111;
        int z = x&y;
        String b = Integer.toBinaryString(z);
        System.out.println("x="+x);
        System.out.println("y="+y);
        System.out.println("z="+z);
        System.out.println("b="+b);

        int aa=0b0011 << 1;
        String s = Integer.toBinaryString(aa);
        System.out.println(aa);
        System.out.println(s);

        System.out.println(5>>32);*/

        /*Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        inputStream.forEach(System.out::println);
        Stream<Integer> outputStream = inputStream.flatMap((childList) -> childList.stream());

        outputStream.forEach(System.out::println);
        System.out.println(outputStream);*/
    }
}
