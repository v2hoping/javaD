package com.owl.zookeeper.use.singleton;

/**
 * Created by 26383 on 2018/4/16.
 * 变种的饿汉模式.
 * @author houping wang
 */
public class SingletonVarietyHungry {

    private String name;

    private static class SingletonInside {
        private static final SingletonVarietyHungry singleton = new SingletonVarietyHungry();
    }

    public static SingletonVarietyHungry getInstance() {
        return SingletonInside.singleton;
    }

    public String getMessage() {
        return "SingletonVarietyHungry单例模式";
    }
}
