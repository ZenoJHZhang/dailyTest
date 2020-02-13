package com.zjh.daily_test.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 类的说明
 *
 * @author 张江浩
 * @version 1.00
 * @date 2020/2/13 14:33
 */
public class LruTest extends LinkedHashMap<String, String> {

    public LruTest(int initialCapacity,float loadFactor){
        super(initialCapacity,loadFactor,true);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
        return size() > 5;
    }

}
