package com.owl.zookeeper;

/**
 * Created by wanghouping on 2018/4/3.
 *
 * @author houping wang
 */
public class StaticTest
{
    public static void main(String[] args)
    {
        staticFunction();//(6)
    }

    static StaticTest st = new StaticTest();//初始化(2)

    static //(5)
    {
        System.out.println("1");
    }

    {
        System.out.println("2");//类信息(1)
    }

    StaticTest()
    {
        System.out.println("3");//(3)
        System.out.println("a="+a+",b="+b);//(4)
    }

    public static void staticFunction(){
        System.out.println("4");
    }

    int a=110;
    static int b =112;
}