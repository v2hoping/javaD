package com.owl.zookeeper.use.singleton;

/**
 * Created by 26383 on 2018/4/16.
 * 饿汉单例模式.
 * @author houping wang
 */
public class SingletonHungry {

    private static final SingletonHungry singleton = new SingletonHungry();

    private SingletonHungry() {}

    public static SingletonHungry getInstance() {
        return singleton;
    }

    public String getMessage() {
        return "SingletonHungry单例模式";
    }

}
