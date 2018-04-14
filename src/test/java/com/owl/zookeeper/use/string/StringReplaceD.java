package com.owl.zookeeper.use.string;

import org.junit.Test;

import java.util.regex.Matcher;

/**
 * Created by wanghouping on 2018/4/13.
 *
 * @author houping wang
 */
public class StringReplaceD {

    @Test
    public void replace() {
        String str = "AAA.AAAA.AAAAAA";
        String replace = str.replace(".", "#");
        System.out.println("replace:" + replace);
    }

    @Test
    public void replaceFirst() {
        String str = "AAA.AAAA.AAAAAA";
        String replace = str.replaceFirst(".", "#");
        System.out.println("replaceFirst:" + replace);
    }

    @Test
    public void replaceAll() {
        String str = "AAA.AAAA.AAAAAA";
        String replace = str.replaceAll(".", "#");
        System.out.println("replaceAll:" + replace);
    }

    @Test
    public void replaceAllRegex() {
        String str = "AAA.AAAA.AAAAAA";
        String replace = str.replaceAll("(A){4}", "#");
        System.out.println("replaceAll:" + replace);
    }

    @Test
    public void quoteReplacement() {
        String str = "A$\\";
        String str1 = Matcher.quoteReplacement(str);
        System.out.println("quoteReplacement[str]:" + str);
        System.out.println("quoteReplacement[str1]:" + str1);
    }
}
