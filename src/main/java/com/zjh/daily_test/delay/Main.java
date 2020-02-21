package com.zjh.daily_test.delay;

import java.util.concurrent.*;

/**
 * 类的说明
 *
 * @author 张江浩
 * @version 1.00
 * @date 2020/2/20 14:35
 */
public class Main {

    private static DelayQueue delayQueue =  new DelayQueue();

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 30, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        threadPoolExecutor.execute(() -> {
            delayQueue.offer(new TestDelayQueue("a1",1000));
            delayQueue.offer(new TestDelayQueue("a2",3000));
            delayQueue.offer(new TestDelayQueue("a3",2000));
            delayQueue.offer(new TestDelayQueue("a4",500));
            delayQueue.offer(new TestDelayQueue("a5",4000));
        });

        while (true){
            Delayed take = delayQueue.take();
            System.out.println(take);
        }
    }
}
