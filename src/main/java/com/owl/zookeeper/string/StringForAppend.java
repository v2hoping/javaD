package com.owl.zookeeper.string;

/**
 * Created by wanghouping on 2018/4/11.
 *
 * @author houping wang
 */

/**
 Compiled from "StringForAppend.java"
 public class com.owl.zookeeper.string.StringForAppend {
 public com.owl.zookeeper.string.StringForAppend();
 Code:
 0: aload_0
 1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 4: return

 public static void main(java.lang.String[]);
 Code:
 0: ldc           #2                  // String 解释：将常量空字符串入栈
 2: astore_1                          解释：将空字符串赋值给a
 3: iconst_0                          解释：将常量integer 0入栈
 4: istore_2                          解释：出栈0，赋值给变量0
 5: iload_2                           解释：将变量i=0，入栈
 6: iconst_3                          解释：将integer 3入栈
 7: if_icmpge     36                  解释：比较栈顶两个元素，如果相等则跳转到36
 10: new           #3                  // class java/lang/StringBuilder 创建StringBuilder，并入栈
 13: dup                               解释：复制栈顶
 14: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V 解释：出栈调用StringBuilder的构造方法
 17: aload_1                           解释：入栈空字符串
 18: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder; 出栈空字符串，出栈StringBuilder，执行append方法
 21: ldc           #6                  // String 1 解释：常量1入栈
 23: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder; 出栈字符串1，调用append方法
 26: invokevirtual #7                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String; 出栈StringBuilder，调用append方法，将结果入栈
 29: astore_1                          解释：出栈""+1，保存到变量a
 30: iinc          2, 1                解释：将变量i，递增1
 33: goto          5                   解释：跳转到步骤5
 36: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;解释：获得对象PrintStream，入栈
 39: aload_1                           入栈变量a
 40: invokevirtual #9                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V 出栈变量a,出栈PrintStream，调用println方法
 43: return                            解释：返回
 }
 */
public class StringForAppend {

    public static void main(String[] args) {
        String a = "";
        for(int i = 0; i < 3; i ++) {
            a += "1";
        }
        System.out.println(a);
    }
}
