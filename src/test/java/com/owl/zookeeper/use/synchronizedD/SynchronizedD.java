package com.owl.zookeeper.use.synchronizedD;

/**
 * Created by wanghouping on 2018/4/16.
 *
 * @author houping wang
 */
public class SynchronizedD {

    public synchronized void test(){
        System.out.println("Hello World");
    }

    public void test1(){
        synchronized (SynchronizedD.class){
            System.out.println("Hello World");
        }
    }
}
