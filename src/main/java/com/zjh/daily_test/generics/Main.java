package com.zjh.daily_test.generics;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 类的说明
 *
 * @author 张江浩
 * @version 1.00
 * @date 2020/2/11 13:48
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);

        List<Double> stringList = new LinkedList<>();
        stringList.add(23.00);

        test(list);
        test(stringList);
    }

    public static void test(List<? extends Number> list) {
        for (Number number : list) {
            System.out.println(number);
        }
    }
}
