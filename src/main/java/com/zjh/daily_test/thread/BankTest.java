package com.zjh.daily_test.thread;

/**
 * 类的说明
 *
 * @author 张江浩
 * @version 1.00
 * @date 2019/12/22 10:59
 */
public class BankTest {
    public static final int NACOUNTS = 100;
    public static final double INITIAL_BALCANCE = 1000;
    public static final double MAX_AMOUNT = 1000;
    public static final int DELAY = 10;

    public static void main(String[] args) {
        Bank bank = new Bank(NACOUNTS,INITIAL_BALCANCE);
        for (int i = 0; i < NACOUNTS; i++) {
            int fromAccount = i;
            Runnable r = () -> {
                try {
                    while (true){
                        int toAccoumt = (int) (bank.size() *Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount,toAccoumt,amount);
                        Thread.sleep((long) (DELAY * Math.random()));
                    }
                }
                catch (InterruptedException e){

                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }
}
