package com.owl.zookeeper.use.integer;

import org.junit.Test;

/**
 * Created by wanghouping on 2018/4/16.
 * 理解Integer缓存机制.
 * @author houping wang
 */
public class IntegerCache {

    public static void main(String[] args) {
        Integer integer = 100;
        Integer integer1 = 2000;
    }

    @Test
    public void test() {
        //Integer缓存-128-127之间
        Integer a1 = 100;
        Integer a2 = 100;
        if(a1 == a2) {
            System.out.println("a1==a2:" + (a1 == a2));
        }
        //Integer缓存失效
        Integer b1 = 200;
        Integer b2 = 200;
        if(b1 == b2) {
            System.out.println("b1==b2:" + (b1 == b2));
        }
    }
}
