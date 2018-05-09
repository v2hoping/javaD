package com.owl.zookeeper.use.theadpool;

/**
 * Created by wanghouping on 2018/5/9.
 *
 * @author houping wang
 */
public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"正在执行....");
    }
}
