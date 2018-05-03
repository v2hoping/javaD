package com.owl.zookeeper.use.example;

/**
 * Created by 26383 on 2018/4/24.
 * 面向过程.
 * 顺序：自上而下
 * @author houping wang
 */
public class GuoCheng {

    private static void say(String name) {
        System.out.println(name + "说话：");
        System.out.println("你好");
        System.out.println("世界");
    }

    private static void eat(String name) {
        System.out.println(name + "吃饭：");
        System.out.println("苹果");
        System.out.println("梨");
    }

    private static void xuexi(String name) {
        System.out.println(name + "学习：");
        System.out.println("JAVA");
    }

    public static void persoen(String name) {
        say(name);
        eat(name);
        xuexi(name);
    }

    public static void main(String[] args) {
        persoen("颖宝");
        persoen("王厚平");
        persoen("颖宝2");
    }


}
