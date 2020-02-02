package com.zjh.daily_test.jvm;

/**
 * 类的说明
 *
 * @author 张江浩
 * @version 1.00
 * @date 2020/2/2 12:49
 */
public class VolatileTest {

    public static volatile int race = 0;

    public static void increase(){
        race++;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[20];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000000 ; j++) {
                    increase();
                }
            });
            threads[i].start();
        }


        while (Thread.activeCount() > 1){
            Thread.yield();
        }

        System.out.println(race);
    }

}
