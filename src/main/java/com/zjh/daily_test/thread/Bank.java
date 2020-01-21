package com.zjh.daily_test.thread;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 类的说明
 *
 * @author 张江浩
 * @version 1.00
 * @date 2019/12/22 10:59
 */
public class Bank {
    private final double[] accounts;
    private Lock bankLock = new ReentrantLock();
    //条件变量通过 lock.newCondition 初始化
    private Condition condition = bankLock.newCondition();

    public Bank(int n, double balance) {
        accounts = new double[n];
        Arrays.fill(accounts, balance);
    }

    public void transfer(int from, int to, double amount) {
        bankLock.lock();
        try {
            while (accounts[from] < amount) {
                condition.await();
            }
            System.out.println(Thread.currentThread());
            accounts[from] -= amount;
            accounts[to] += amount;
            condition.signalAll();
            System.out.print("Total blance:" + getTotalBalance());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bankLock.unlock();
        }
    }

    public double getTotalBalance() {
        double sum = 0;
        for (double a : accounts) {
            sum += a;
        }
        return sum;
    }

    public int size() {
        return accounts.length;
    }

}
