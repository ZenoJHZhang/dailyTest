package com.zjh.daily_test.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 类的说明
 *
 * @author 张江浩
 * @version 1.00
 * @date 2020/2/21 15:24
 */
public class CountDownLatchTest {
    public static void main(String[] args)  {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        executor.execute(() -> {
            try {
                System.out.println("wait");
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("来齐了");
        });

        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "人来了一个");
                countDownLatch.countDown();
            });

        }
    }
}
