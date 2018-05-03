package com.owl.zookeeper.use.example;

/**
 * Created by 26383 on 2018/4/24.
 *
 * @author houping wang
 */
public class Parking {

    //驶入方法：***车辆欢迎驶入！入参：车牌号

    //驶出方法：***车辆欢迎驶出！入参：车牌号

    //驶出后通知用户：某某用户，你的***车已经驶出！入参：用户、车牌号


   private static void in(String number)
   {
       System.out.println(number+"车辆欢迎驶入！");
   }
    private static void out(String number)
    {
        System.out.println(number+"车辆欢迎驶出！");
    }
    private static void tongzhi(String number,String name )
    {

        System.out.println(name+"，你的" + number + "车已经驶出！");
    }
    public static void person(String number,String name)
    {
        in(number);
        out(number);
        tongzhi(number,name);
    }

    public static void main(String args[])
    {
        String number;
        String name;
        person("鲁Z123456","颖宝");
        person("鲁Z123457","汪厚萍");
    }
}
