package com.owl.zookeeper.use.finalD;

/**
 * Created by wanghouping on 2018/4/17.
 *
 * @author houping wang
 */
public class FinalD {

    private int a ;

    private static int i;

    public int getA() {
        return a;
    }

    public static int getI() {
        return i;
    }

    public static void main(String[] args) {
        FinalD finalD = new FinalD();
        int a = finalD.getA();
        int i = FinalD.getI();
    }
}
