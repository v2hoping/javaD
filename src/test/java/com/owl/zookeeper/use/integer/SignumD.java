package com.owl.zookeeper.use.integer;

/**
 * Created by 26383 on 2018/4/5.
 *
 * @author houping wang
 */
public class SignumD {

    public static int signumD(int j) {
        if(j == 0) {
            return 0;
        }
        return  j >>> 31 == 0 ? 1 : -1;
    }
}
