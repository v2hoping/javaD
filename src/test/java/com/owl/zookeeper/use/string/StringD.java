package com.owl.zookeeper.use.string;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wanghouping on 2018/4/3.
 * String源码用例.
 * 熟悉Java String的使用，熟悉String的各种函数
 * JDK 7中substring的原理及区别、
 *
 * replaceFirst、replaceAll、replace区别、
 * String对“+”的重载、
 * String.valueOf和Integer.toString的区别、
 * 字符串的不可变性
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

    @Test
    public void intern() {
        String str2 = new StringBuilder().append("s").append("t").append("r").toString();
        str2.intern();
        String str1 = "str";
        System.out.println(str2==str1);
//        String a = new String("1111");
//        a.intern();
//        String b = new String("1111");
//        String intern = b.intern();
//        String intern1 = a.intern();
//        String c = "1111";
//        System.out.println("a == c:" + (intern == c));
    }

    @Test
    public void subString() {
        String substring = "abc".substring(2, 2);
        System.out.println("substring(2,3):" + substring);
    }

    @Test
    public void split() {
        String[] split = "a,b,c,d,e,f".split(",");
        String[] split1 = "a,b,c,d,e,f".split(",", 3);
    }

    @Test
    public void copyOfRange() {
        char[] chars = {'a', 'b', 'c', 'd', 'e'};
        char[] chars1 = Arrays.copyOfRange(chars, 3, 10);
    }

    @Test
    public void replaceFirst() {
        String str = "abacda";
        String a = str.replaceFirst("a", "!");
    }

    @Test
    public void replaceAll() {
        String str = "abacda";
        String a = str.replaceAll("a", "!");
    }

    @Test
    public void replace() {
        String str = "abacda";
        String a = str.replace("a", "!");
    }


}
