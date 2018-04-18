package com.owl.zookeeper.use.future;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * Created by wanghouping on 2018/4/18.
 * 实现一个Future
 * @author houping wang
 */
public class FutureReal<T> implements Callable<T>, Runnable{

    private T t;

    private Boolean isOk = false;

    public T call() {
        return t;
    };



    public void run() {
        synchronized (this) {
            try {
                t = call();
                isOk = true;
                notifyAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public T get() {
        synchronized (this) {
            while(!isOk) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return t;
    }

}
