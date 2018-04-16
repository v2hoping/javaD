package com.owl.zookeeper.string;
/**
 * Created by wanghouping on 2018/4/2.
 * String源码学习用例.
 * @author houping wang
 */
public class StringD {
    public static void main(String[] args) {
//        String str = "a" + "b";
        String a = new String("AB");
        String b = "AB";
        String c = a.intern();
        if(a == c) {
            System.out.println("a == c");
        }
        if(b == c) {
            System.out.println("b == c");
        }
    }
}
