package com.zjh.daily_test.delay;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 类的说明
 *
 * @author 张江浩
 * @version 1.00
 * @date 2020/2/20 14:30
 */
public class TestDelayQueue implements Delayed {

    private String name;
    private long start = System.currentTimeMillis();
    private long time;

    public TestDelayQueue(String name, long time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(start+ time - System.currentTimeMillis(),TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        TestDelayQueue testDelayQueue = (TestDelayQueue) o;
        return (int)(this.getDelay(TimeUnit.MILLISECONDS) - testDelayQueue.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public String toString() {
        return "TestDelayQueue{" +
                "name='" + name + '\'' +
                ", time=" + time +
                '}';
    }
}
