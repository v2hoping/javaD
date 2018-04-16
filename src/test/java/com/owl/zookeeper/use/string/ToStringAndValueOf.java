package com.owl.zookeeper.use.string;

import org.junit.Test;

/**
 * Created by 26383 on 2018/4/13.
 * String.valueof和Integer.toString的不同
 * @author houping wang
 */
public class ToStringAndValueOf {

    @Test
    public void valueOf() {
        String a = String.valueOf(10);
        System.out.println("valueOf()方法变量a:" + a);
    }

    @Test
    public void toStringTest() {
        String a = Integer.toString(10);
        System.out.println("toStringTest()方法变量a:" + a);
    }

}
