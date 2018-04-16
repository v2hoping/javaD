package com.owl.zookeeper.use.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wanghouping on 2018/4/16.
 *
 * @author houping wang
 */
public class AutomicIntegerD implements Runnable{

    private static final AtomicInteger atomicInteger = new AtomicInteger();

    public void run() {
        int andIncrement = atomicInteger.getAndIncrement();
    }
}
