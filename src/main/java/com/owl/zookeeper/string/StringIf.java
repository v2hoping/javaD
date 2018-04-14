package com.owl.zookeeper.string;

/**
 * Created by wanghouping on 2018/4/12.
 *
 * @author houping wang
 */

/**
 Compiled from "StringIf.java"
 public class com.owl.zookeeper.string.StringIf {
 public com.owl.zookeeper.string.StringIf();
 Code:
 0: aload_0
 1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 4: return

 public static void main(java.lang.String[]);
 Code:
 0: ldc           #2                  // String 123 解释：将常量123入栈
 2: astore_1                          解释：出栈123，赋值给变量a
 3: ldc           #2                  // String 123  解释：将常量123入栈
 5: aload_1                           解释：入栈123
 6: if_acmpne     19                  解释：比较栈顶两个元素，如果符合跳转到指定位置
 9: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;解释：获得System.out对象，入栈
 12: aload_1                          解释：入栈123
 13: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V 解释：出栈参数，出栈调用方法对象
 16: goto          46                  解释：跳转到结束
 19: new           #5                  // class java/lang/StringBuilder 创建一个 解释：创建一个StringBuilder对象，并入栈
 22: dup                               解释：复制栈顶数据，并入栈
 23: invokespecial #6                  // Method java/lang/StringBuilder."<init>":()V 解释：出栈并调用构造方法
 26: aload_1                           解释：入栈123
 27: invokevirtual #7                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;解释：出栈123，出栈StringBUilder，调用方法，入栈StirngBuilder
 30: ldc           #8                  // String ! 解释：入栈常量！
 32: invokevirtual #7                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;解释：出栈!，出栈StringBuilder，调用append(!)，入栈StirngBuilder
 35: invokevirtual #9                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String; 解释：出栈StringBuilder，调用toString()
 38: astore_2                          解释：出栈123！，赋值给变量b
 39: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream; 解释：获得PrintStream，并入栈
 42: aload_2                           解释：入栈123！
 43: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V  出栈2个栈位，调用println
 46: return                            解释：结束
 }
 */
public class StringIf {

    public static void main(String[] args) {
        String a = "123";
        if("123" == (a)) {
            System.out.println(a);
        }else {
            String b = a + "!";
            System.out.println(b);
        }
    }
}
