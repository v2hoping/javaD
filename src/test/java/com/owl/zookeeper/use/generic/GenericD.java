package com.owl.zookeeper.use.generic;

import org.junit.Test;

/**
 * Created by wanghouping on 2018/5/3.
 *
 * @author houping wang
 */
public class GenericD {

    @Test
    public void tet() {
        Java<Integer> a = new Java<Integer>();
        Integer t = a.getT();
    }
}
