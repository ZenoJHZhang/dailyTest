package com.zjh.daily_test.jvm;

/**
 * 类的说明
 *
 * @author 张江浩
 * @version 1.00
 * @date 2020/2/6 15:05
 */
public class SingleTon {
    private SingleTon(){

    }

    private volatile  static SingleTon singleTon = null;

    public static SingleTon getSingleTon(){
        if (singleTon == null){
            synchronized (SingleTon.class){
                if (singleTon != null){
                    return singleTon;
                }
                singleTon = new SingleTon();
                return singleTon;
            }
        }
        return singleTon;
    }
}
