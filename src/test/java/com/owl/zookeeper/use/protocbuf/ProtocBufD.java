package com.owl.zookeeper.use.protocbuf;

import com.google.protobuf.InvalidProtocolBufferException;
import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * Created by wanghouping on 2018/4/26.
 *
 * @author houping wang
 */
public class ProtocBufD {

    @Test
    public void text() throws InvalidProtocolBufferException {
        DemoA.Demo.Builder builder = DemoA.Demo.newBuilder();
        DemoA.Demo demo = builder.setName("").setEmail("").setId(1).build();
        byte[] bytes = demo.toByteArray();
        DemoA.Demo demo1 = DemoA.Demo.parseFrom(bytes);
        Assert.assertFalse(demo1 == demo);
        Assert.assertEquals("Email应相等", demo.getEmail(), demo1.getEmail());
        Assert.assertEquals("名称应相等", demo.getName(), demo1.getName());
        Assert.assertEquals("ID应相等", demo.getId(), demo1.getId());
    }

    @Test
    public void text2() {
        int i = ~0x7F;
        int i1 = i | 1;
        String s1 = Integer.toBinaryString(i1);
        String s = Integer.toBinaryString(i);
    }

    @Test
    public void test3() throws UnsupportedEncodingException {
        String wang = "123";
        byte[] bytes = wang.getBytes("UTF-8");
        Integer i = 123;
    }

    @Test
    public void DemoInt32ATest() throws InvalidProtocolBufferException {
        DemoInt32A.DemoInt32 demoInt32 = DemoInt32A.DemoInt32.newBuilder().setId(-1).build();
        byte[] bytes = demoInt32.toByteArray();
        DemoInt32A.DemoInt32 demoInt321 = DemoInt32A.DemoInt32.parseFrom(bytes);
        int id = demoInt321.getId();
    }

    @Test
    public void zigzagTest() {
        int i = int_to_zigzag(3);
        int i1 = zigzag_to_int(i);
    }

    /**
     *
     message Test
     {

     required int32 id1 = 1；

     required int32 id2 = 2；
     }

     // 在代码中给id1 附上1个字段值：296
     // 在代码中给id2 附上1个字段值：296
     Test.setId1（300）；
     Test.setId2（296）；

     // 编码结果为：二进制字节流 = [8，-84，2，16, -88, 2]
     */
    @Test
    public void test() {
        Byte i = -84;

        String s = Integer.toBinaryString(-84);
        String s1 = Integer.toBinaryString(2);
        String s2 = Integer.toBinaryString(-88);
        String s3 = Integer.toBinaryString(2);
    }

    @Test
    public void String() {
        DemoIntStringA.DemoString build = DemoIntStringA.DemoString.newBuilder().setName("1").addNames("1").addNames("2").build();
        byte[] bytes = build.toByteArray();
    }

    public int int_to_zigzag(int n)
// 传入的参数n = 传入字段值的二进制表示（此处以负数为例）
// 负数的二进制 = 符号位为1，剩余的位数为 该数绝对值的原码按位取反；然后整个二进制数+1
    {
        return (n <<1) ^ (n >>31);
        // 对于sint 32 数据类型，使用Zigzag编码过程如下：
        // 1. 将二进制表示数 左移1位（左移 = 整个二进制左移，低位补0）
        // 2. 将二进制表示数 右移31位
        // 对于右移：
        // 首位是1的二进制（有符号数），是算数右移，即右移后左边补1
        // 首位是0的二进制（无符号数），是逻辑左移，即右移后左边补0
        // 3. 将上述二者进行异或

        // 对于sint 64 数据类型 则为： return  (n << 1> ^ (n >> 63) ；
    }


    // 附：将Zigzag值解码为整型值
    public int zigzag_to_int(int n)
    {
        return(n >>> 1) ^ -(n & 1);
// 右移时，需要用不带符号的移动，否则如果第一位数据位是1的话，就会补1
    }


}
