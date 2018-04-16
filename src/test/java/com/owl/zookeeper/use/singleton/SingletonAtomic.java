package com.owl.zookeeper.use.singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by wanghouping on 2018/4/16.
 *
 * @author houping wang
 */
public class SingletonAtomic {
        private static final AtomicReference<SingletonAtomic> INSTANCE = new AtomicReference<SingletonAtomic>();

        private SingletonAtomic() {}

        public static SingletonAtomic getInstance() {
            for (;;) {
                SingletonAtomic singleton = INSTANCE.get();
                if (null != singleton) {
                    return singleton;
                }

                singleton = new SingletonAtomic();
                if (INSTANCE.compareAndSet(null, singleton)) {
                    return singleton;
                }
            }
        }
}
