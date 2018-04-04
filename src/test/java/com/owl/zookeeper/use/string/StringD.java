package com.owl.zookeeper.use.string;

import org.junit.Test;

/**
 * Created by wanghouping on 2018/4/3.
 * String源码用例.
 * @author houping wang
 */
public class StringD {

    /**
     * intern()方法作用验证.
     * true
     * false
     * true
     * false
     */
    @Test
    public void yinyong() {
        String str1 = "a";
        String str2 = "b";
        String str3 = "ab";
        String str4 = str1 + str2;
        String str5 = new String("ab");

        System.out.println(str5.equals(str3));
        System.out.println(str5 == str3);
        System.out.println(str5.intern() == str3);
        System.out.println(str5.intern() == str4);
    }
}
