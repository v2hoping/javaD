package com.owl.zookeeper.use.reflect;

/**
 * Created by wanghouping on 2018/4/24.
 *
 * @author houping wang
 */
public class TDemo<T> {

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
