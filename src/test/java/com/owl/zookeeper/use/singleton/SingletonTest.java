package com.owl.zookeeper.use.singleton;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 26383 on 2018/4/16.
 *
 * @author houping wang
 */
public class SingletonTest {

    @Test
    public void atomic() {
        Runnable r = new Runnable() {
            public void run() {
                SingletonAtomic instance = SingletonAtomic.getInstance();
//                System.out.println(instance.getMessage());
            }
        };
        thread(r);
    }

    @Test
    public void hungry() {
        SingletonHungry instance = SingletonHungry.getInstance();
        System.out.println(instance.getMessage());
    }

    @Test
    public void lazy() {
        Runnable r = new Runnable() {
            public void run() {
                SingletonLazy instance = SingletonLazy.getInstance();
//                System.out.println(instance.getMessage());
            }
        };
        thread(r);
    }

    @Test
    public void variety() {
        SingletonVarietyHungry instance = SingletonVarietyHungry.getInstance();
                System.out.println(instance.getMessage());
    }

    private static void thread(Runnable r) {
        int n = 100;
        ArrayList<Runnable> runnables = new ArrayList<Runnable>();
        for(int i = 0; i < n; i ++) {
            runnables.add(r);
        }
        for(int i = 0; i < n; i ++) {
            runnables.get(i).run();
        }
    }

}
