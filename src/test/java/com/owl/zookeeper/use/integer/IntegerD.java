package com.owl.zookeeper.use.integer;

import org.junit.Test;

/**
 * Created by wanghouping on 2018/4/3.
 *
 * @author houping wang
 */
public class IntegerD {

    @Test
    public void test() {
        Integer integer = new Integer(1);
        int MIN_VALUE = 0x80000000;

    }

    @Test
    public void bitCount() {
        int i = Integer.bitCount(3);
        System.out.println("Integer.bitCount(3):" + i);
    }

    @Test
    public void rotateLeft() {
        int i = 2;
        int distance = 1;
        int i1 = i << distance;
        int i2 = 2 >>> 31;
        int i3 = i1 | i2;
        System.out.println(i3);
    }

    @Test
    public void reverse() {
        int reverse = Integer.reverse(15);
        String s = Integer.toBinaryString(reverse);
        System.out.println("reverse(15):" + s);
    }

    @Test
    public void signum() {
        int i = 1;
        int i1 = i >> 31;
        System.out.println("i1:" + Integer.toBinaryString(i1));
        int i2 = -i >>> 31;
        System.out.println("i2:" + Integer.toBinaryString(i2));
        int i3 = i1 | i2;
        System.out.println("signum():" + i3);
    }

    @Test
    public void test5(){
        int i2 = SignumD.signumD(1);
        int i1 = SignumD.signumD(-111);
        int i3 = SignumD.signumD(0);
    }

    public void reverseBytes() {
        int i = 1;
        // [3][2][1][0]
        //  i >>> 24 将高8位移动到低8位 [3]->[0]，其余位为0
        // (i >> 8) & 1111 1111 0000 0000 [2]->[1]，其余位为0
        // (i<<24) [0]->[3]其余位为0
        // (i<<8) & 0X FF 00 00 [1] -> [2]，其余位位0
        int i1 = ((i >>> 24)) |
                ((i >> 8) & 0xFF00) |
                ((i << 8) & 0xFF0000) |
                ((i << 24));
    }
}
