package com.zjh.daily_test.generics;

/**
 * 类的说明
 *
 * @author 张江浩
 * @version 1.00
 * @date 2020/2/11 13:47
 */
public class Test<T> {
    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public T sout(T obj){
        System.out.println(obj);
        return obj;
    }
}
