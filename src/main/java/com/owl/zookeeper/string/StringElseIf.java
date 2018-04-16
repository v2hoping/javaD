package com.owl.zookeeper.string;

/**
 * Created by wanghouping on 2018/4/13.
 *
 * @author houping wang
 */
public class StringElseIf {

    public static void main(String[] args) {
        String a = "123";
        if("123" == a) {
            System.out.println(a);
        }else if ("1" == a){
            String b = a + "!";
            System.out.println(b);
        }else{
            String b = a + "?";
            System.out.println(b);
        }
    }
}
