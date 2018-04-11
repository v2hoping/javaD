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
        Integer integer = new Integer(111);
        String s = integer.toString();
        System.setProperty("111", "222");
        Integer integer1 = Integer.getInteger("111", 333);
        //进制转换
        Integer decode = Integer.decode("0X1110");
        Integer decode1 = Integer.decode("00011");
    }

    @Test
    public void OneBit() {
        //获取一个数小于自身且最接近自身的2次方数
        //0111->0100->4(10进制)
        int i = Integer.highestOneBit(7);
        System.out.println("highestOneBit(7)=" + i);
        //获取一个数最低位为1的2次方数
        //0111->0001->1(10进制)
        int j = Integer.lowestOneBit(7);
        System.out.println("lowestOneBit(7)=" + j);
    }

    @Test
    public void numberOfLeadingZeros() {
        /**
         * if (i == 0)
         * return 32;
         * int n = 1;
         * if (i >>> 16 == 0) { n += 16; i <<= 16; }
         * if (i >>> 24 == 0) { n +=  8; i <<=  8; }
         * if (i >>> 28 == 0) { n +=  4; i <<=  4; }
         * if (i >>> 30 == 0) { n +=  2; i <<=  2; }
         * n -= i >>> 31;
         * return n;
         * 以4为例:
         * 0000 0000 0000 0000 0000 0000 0000 0100
         * (1)折半，验证前16位若等于0，则说明存在16个0；将后16位提成前16位，方便之后再次折半
         * 0000 0000 0000 0100 0000 0000 0000 0000
         * (2)0000 0000 0000 0100相当于对其折半，若为0，说明存在8个0；再将低8位提成高8位
         * 0000 0100 0000 0000 0000 0000 0000 0000
         * (3)0000 0100相当于对其折半，若为0，则说明存在4个0；再将低4位提成高8位
         * 0100 0000 0000 0000 0000 0000 0000 0000
         * (4)0100相当于对其折半，不为0，则不操作，说明其中存在1，则对该部分再次进行折半，直到无法再分
         * 判断最左边1为是0，还是1
         */
        int i = Integer.numberOfLeadingZeros(4);
        System.out.println("numberOfLeadingZeros(4)=" + i);
    }

    @Test
    public void numberOfTrailingZeros() {
        int i = Integer.numberOfTrailingZeros(4);
        System.out.println("numberOfLeadingZeros(4)=" + i);
    }

    /**
     * 自己实现一个numberOfLeadingZeros(),加深对其理解.
     */
    @Test
    public void numberOfLeadingZerosMe() {
        int x = 1;
        int i = numberOfLeadingZerosD(x);
        int j = Integer.numberOfLeadingZeros(x);
        System.out.println("numberOfLeadingZerosD:" + i);
        System.out.println("numberOfLeadingZeros:" + j);
    }

    @Test
    public void numberOfTrailingZerosDRecursionDMe() {
        int x = 0xFF000000;
        int i = numberOfTrailingZerosDRecursionD(x);
        int j = Integer.numberOfTrailingZeros(x);
        System.out.println("numberOfTrailingZerosDRecursionD:" + i);
        System.out.println("numberOfTrailingZeros:" + j);
    }

    private int numberOfLeadingZerosD(int i) {
        return numberOfLeadingZerosDRecursion(i, 0, 32, 0);
    }

    private int numberOfTrailingZerosDRecursionD(int i) {
        return numberOfTrailingZerosDRecursion(i, 0, 32, 0);
    }

    /**
     * @param i 数据值
     * @param n 0个数
     * @param digits 有效位数
     * @param move 需要折半有效区域而移动的位数
     * @return 从左边其为0的个数
     */
    private int numberOfLeadingZerosDRecursion(int i, int n, int digits, int move) {
        if(digits == 0)
            return 32;
        if (digits == 1)
            return n;
        digits >>= 1;
        move += digits;
        if (i >>> move == 0) {
            n += digits;
            i <<= digits;
        }
        return numberOfLeadingZerosDRecursion(i, n, digits, move);
    }

    private int numberOfTrailingZerosDRecursion(int i, int n, int digits, int move) {
        if(digits == 0)
            return 32;
        if (digits == 1)
            return n;
        digits >>= 1;
        move += digits;
        if (i << move == 0) {
            n += digits;
            i >>>= digits;
        }
        return numberOfTrailingZerosDRecursion(i, n, digits, move);
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
