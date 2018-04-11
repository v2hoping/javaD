package com.owl.zookeeper.use;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by wanghouping on 2018/4/9.
 *
 * @author houping wang
 */
public class bigdecimalD {

    @Test
    public void test() {
        BigDecimal a = new BigDecimal("1.22");
        BigDecimal b = new BigDecimal("2.22");
        BigDecimal add = a.add(b);
        System.out.println(add);
    }
}
