package com.owl.zookeeper.use.singleton;

import com.owl.zookeeper.use.finalD.FinalD;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by wanghouping on 2018/4/16.
 * 原子单例模式.
 * @author houping wang
 */
public class SingletonAtomic {

        private static final AtomicReference<SingletonAtomic> INSTANCE = new AtomicReference<SingletonAtomic>();//使用CAS算法，类似于乐观锁

        private SingletonAtomic() {}

        public static SingletonAtomic getInstance() {
            for (;;) {
                SingletonAtomic singleton = INSTANCE.get();//获得对象
                if (null != singleton) {//已创建则直接返回
                    return singleton;
                }

                singleton = new SingletonAtomic();//创建对象
                if (INSTANCE.compareAndSet(null, singleton)) {//compareAndSet，若预期于内部数据相同，则赋值singleton
                    System.out.println("AtomicReference单例模式生成对象");
                    return singleton;
                }
            }
        }

        public String getMessage() {
            return "AtomicReference单例模式";
        }
}
