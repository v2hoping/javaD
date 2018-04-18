package com.owl.zookeeper.use.singleton;

/**
 * Created by 26383 on 2018/4/16.
 * 懒汉单例模式.
 * @author houping wang
 */
public class SingletonLazy {

    private static volatile SingletonLazy singleton = null;//防止JVM指令重排序

    private SingletonLazy() {}

    public static SingletonLazy getInstance() {
        if(null == singleton) {//第一层：判断为null
            synchronized (SingletonLazy.class) {//第二层：只允许一个线程进入
                if(null == singleton) {//第三层：防止第一层多个进入，一个线程解锁后，多个线程依次重复创建对象。
                    System.out.println("LazySingleton单例模式生成对象");
                    singleton = new SingletonLazy();
                }
            }
        }
        return singleton;
    }

    public String getMessage() {
        return "LazySingleton单例模式";
    }

}
