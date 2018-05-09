package com.owl.zookeeper.use.theadpool;

import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.*;

/**
 * Created by wanghouping on 2018/5/8.
 *
 * @author houping wang
 */
public class DefaultThreadPoolTest {

    @Test
    public void test() {
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("启动One");
                try {
                    Thread.sleep(1000 * 5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("关闭One");
            }
        };
        Runnable runnable1 = new Runnable() {
            public void run() {
                System.out.println("启动Two");
                try {
                    Thread.sleep(1000 * 10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("关闭Two");
            }
        };
        DefaultThreadPool<Runnable> defaulThread = new DefaultThreadPool<Runnable>();
        defaulThread.execute(runnable);
        defaulThread.execute(runnable1);
        try {
            Thread.sleep(100*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void newSingleThreadExecutor() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.shutdown();
    }

    @Test
    public void newFixedThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.shutdown();
    }

    @Test
    public void newCachedThreadPool() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.shutdown();
    }

    @Test
    public void newScheduledThreadPool() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(new MyThread(), 5, 10, TimeUnit.SECONDS);
        try {
            Thread.sleep(1000*60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
