package com.zjh.daily_test.jvm;

/**
 * 类的说明
 *
 * @author 张江浩
 * @version 1.00
 * @date 2020/1/31 13:23
 */
public class HeapOOM {

    public Object instance = null;

    private static final int _1Mb = 1024 * 1024;

    private byte[] bigSize = new byte[2 * 1024];


    public static void testGc() {
        HeapOOM oom1 = new HeapOOM();
        HeapOOM oom2 = new HeapOOM();
        oom1.instance = oom2;
        oom2.instance = oom1;


        oom1 = null;
        oom2 = null;

        System.gc();
    }


    /**
     * 对象优先在Eden区分配
     * VM -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * 堆内存最小20M，最大20M，新生代10M。同时 一个eden和一个survivor对比的是 8：1
     * 因为Parallel Scavenge是用复制算法
     * 所以一个survivor区做为复制的地方
     *
     * 过程
     * 1 三个2m的对象进入eden区
     * 2 4m的对象发现eden区满了，触发 minor GC
     * 3 因为survivor区过小，所以GC的时候老年代提供了担保，三个2m的对象便进入了老年区
     * 4 剩下那个4m的对象留在了eden区
     */
    public static void testAllocation(){
        byte [] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[2 * _1Mb];
        allocation2 = new byte[2 * _1Mb];
        allocation3 = new byte[2 * _1Mb];
        allocation4 = new byte[4 * _1Mb];
    }

    public static void main(String[] args) {
        testAllocation();
    }

}
