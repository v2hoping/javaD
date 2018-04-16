package com.owl.zookeeper.use.instanceofD;

import org.junit.Test;

/**
 * Created by wanghouping on 2018/4/16.
 *
 * @author houping wang
 */
public class InstanceofD {

    public static void main(String[] args) {
        String a = "1";
        boolean b = a instanceof String;
        System.out.println("a instanceof String:" + b);
    }

    @Test
    public void test() {
        Object a = new ChirldD();
        ParentD b = new ChirldD();
        ChirldD c = new ChirldD();
        boolean b1 = a instanceof ChirldD;
        boolean b2 = b instanceof ChirldD;
        boolean b3 = c instanceof ChirldD;
        System.out.println(a.getClass());
        System.out.println(b.getClass());
        System.out.println(c.getClass());
    }
}
