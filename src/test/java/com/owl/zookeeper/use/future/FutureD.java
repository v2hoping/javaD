package com.owl.zookeeper.use.future;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by wanghouping on 2018/4/18.
 *
 * @author houping wang
 */
public class FutureD {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new Callable<Integer>() {
            public Integer call() throws Exception {
                Thread.sleep(2000);
                return 1;
            }
        };
        FutureTask<Integer> integerFutureTask = new FutureTask<Integer>(callable);
        new Thread(integerFutureTask).start();
        Integer integer = integerFutureTask.get();
        System.out.println(integer);
    }

    @Test
    public void test() {
        FutureReal<Integer> futureReal = new FutureReal<Integer>() {
            @Override
            public Integer call() {
                try {
                    System.out.println("开始");
                    Thread.sleep(10000);
                    System.out.println("结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return 2;
            }
        };
        new Thread(futureReal).start();
        System.out.println(Thread.currentThread().toString() + "开始");
        Integer integer = futureReal.get();
        System.out.println(Thread.currentThread().toString() + "结束");
        System.out.println(integer);
    }
}
