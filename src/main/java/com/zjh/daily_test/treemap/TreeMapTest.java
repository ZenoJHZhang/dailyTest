package com.zjh.daily_test.treemap;

import java.util.Random;
import java.util.TreeMap;

/**
 * 类的说明
 *
 * @author 张江浩
 * @version 1.00
 * @date 2020/2/13 15:12
 */
public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        treeMap.put(1, 1);
        treeMap.put(4, 4);
        treeMap.put(2, 2);
        treeMap.put(10, 10);
        treeMap.put(20, 20);

        //获取等于key1的值，如果没有就获取比key1大的最小的key
        //ceiling 天花板
        System.out.println(treeMap.ceilingKey(5));

        //获取等于key1的值，如果没有就获取比key1小的最大的key
        //floor 地板
        System.out.println(treeMap.floorKey(5));
    }
}
