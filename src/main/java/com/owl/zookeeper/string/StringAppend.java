package com.owl.zookeeper.string;

/**
 * Created by wanghouping on 2018/4/11.
 *
 * @author houping wang
 */

/**
 Compiled from "StringAppend.java"
 public class com.owl.zookeeper.string.StringAppend {
 public com.owl.zookeeper.string.StringAppend();
 Code:
 0: aload_0  //将this入栈
 1: invokespecial #1                  // Method java/lang/Object."<init>":()V //调用Object的构造方法
 4: return                            //返回void

 public static void main(java.lang.String[]);
 Code:
 0: ldc           #2                  // String 1  解释：LDC cst：将常量池偏移量为cst的值入栈，譬如LDC #12，在操作栈中会占用1个字长
 2: astore_1                          解释：将栈顶的String 1赋值给第一个变量a
 3: new           #3                  // class java/lang/StringBuilder 解释：创建对象，并将该对象入栈顶
 6: dup                               解释：复制栈顶数据StringBuilder。因为方法调用会弹出参数(这里是Object对象)，因此需要上面的dup指令，保证在调用构造函数之后栈顶上还是 Object对象的引用，很多种情况下dup指令都是为这个目的而存在的。
 7: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V 解释：调用StringBuilder构造方法
 10: ldc           #5                  // String 2 解释：将String 2压入栈顶
 12: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder; 解释：栈顶2出栈，作为方法入参，调用java/lang/StringBuilder.append()方法
 15: aload_1                           解释：将变量a的1入栈
 16: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder; 解释：将变量a的1出栈，作为方法入参，调用java/lang/StringBuilder.append()方法
 19: ldc           #7                  // String 3 解释：将常量池中的字符串3入栈
 21: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder; 解释：将字符串3出栈，作为方法入参，调用java/lang/StringBuilder.append()方法
 24: invokevirtual #8                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String; 解释：调用StringBuilder.toString
 27: astore_2                          解释：将返回值保存在变量b
 28: getstatic     #9                  // Field java/lang/System.out:Ljava/io/PrintStream; 解释：获得静态变量，System.out
 31: aload_2                           解释：变量2入栈
 32: invokevirtual #10                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V 解释：变量2出栈，作为println的方法
 35: return                            解释：返回void
 }
 */
public class StringAppend {

    public static void main(String[] args) {
        String a = "1";
        String b = "2" + a + "3";
        System.out.println(b);
    }
}
