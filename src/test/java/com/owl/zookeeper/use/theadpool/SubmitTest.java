package com.owl.zookeeper.use.theadpool;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by 26383 on 2018/5/9.
 *
 * @author houping wang
 */
public class SubmitTest {

    @Test
    public void test() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> submit = executorService.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
                System.out.println(Thread.currentThread().getName() + "线程正在执行。");
                Thread.sleep(1000 * 10);
                return 1;
            }
        });
        Integer integer = submit.get();
        System.out.println(integer);
    }
}
