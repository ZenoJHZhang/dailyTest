package com.zjh.daily_test.lru;

import java.util.Map;

/**
 * 类的说明
 *
 * @author 张江浩
 * @version 1.00
 * @date 2020/2/13 14:43
 */
public class Main {
    public static void main(String[] args) {
        LruTest lruTest = new LruTest(2, 0.75f);
        lruTest.put("1","zjh");
        lruTest.put("2","zjh");
        lruTest.put("3","zjh");
        lruTest.put("4","zjh");
        lruTest.put("5","zjh");

        lruTest.forEach((key, value) -> System.out.println(key));

        lruTest.put("6","zjh");

        lruTest.forEach((key, value) -> System.out.println(key));

        System.out.println("第二次===================");
        for (Map.Entry<String,String> entry: lruTest.entrySet()
             ) {
            System.out.println(entry.getKey());
        }

    }
}
