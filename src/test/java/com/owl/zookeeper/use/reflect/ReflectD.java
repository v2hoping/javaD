package com.owl.zookeeper.use.reflect;

import org.junit.Test;

import java.lang.reflect.*;

/**
 * Created by wanghouping on 2018/4/24.
 *
 * @author houping wang
 */
public class ReflectD {

    public static class Demo {
        public String name;
        private String age;
        public void setName(String name){
            this.name = name;
        }

        private void setAge(String age) {
            this.age = age;
        }

        public void println() {
            System.out.println("输出:" + name + "," + age);
        }
    }

    @Test
    public void demo() {
        Class cl = null;
        try {
            cl = Class.forName("com.owl.zookeeper.use.reflect.ReflectD$Demo");
            Object demo = cl.newInstance();
            Method setName = cl.getMethod("setName", String.class);
            Method setAge = cl.getDeclaredMethod("setAge", String.class);
            setAge.setAccessible(true);
            setName.invoke(demo, "王厚平");
            setAge.invoke(demo, "18");
            //调用父类
            Method[] declaredMethods = cl.getDeclaredMethods();
            Method toString = cl.getSuperclass().getDeclaredMethod("toString");
            System.out.println(toString.invoke(demo));
            //调用属性
            Field name = cl.getField("name");
            String o = (String)name.get(demo);
            System.out.println(o);
            Field age = cl.getDeclaredField("age");
            age.setAccessible(true);
            String o1 = (String)age.get(demo);
            System.out.println(o1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得泛型的真实类型.
     */
    @Test
    public void demo1() throws NoSuchFieldException {
        TDemo<String> t = new TDemo<String>();
        t.setT("100");
        Field t1 = t.getClass().getDeclaredField("t");
        Type genericType = t1.getGenericType();
        String s = genericType.toString();
        if (genericType instanceof ParameterizedType) {
            System.out.print("11");
        }
    }

    public static abstract class HandleProxy implements InvocationHandler{

        private IProDemo iProDemo;

        public HandleProxy(IProDemo iProDemo) {
            this.iProDemo = iProDemo;
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            before(iProDemo, method, args);
            Object invoke = method.invoke(iProDemo, args);
            after(iProDemo, method, args);
            return returnValue(invoke);
        }

        public abstract void before(Object proxy, Method method, Object[] args);

        public abstract void after(Object proxy, Method method, Object[] args);

        public abstract Object returnValue(Object value);
    }

    @Test
    public void demo2(){
        try {
            IProDemo proDemo = new ProDemo();
            IProDemo iProDemo = (IProDemo) Proxy.newProxyInstance(ProDemo.class.getClassLoader(), new Class[]{IProDemo.class}, new HandleProxy(proDemo) {
                @Override
                public void before(Object proxy, Method method, Object[] args) {
                    System.out.println("调用前");
                }

                @Override
                public void after(Object proxy, Method method, Object[] args) {
                    System.out.println("调用后");
                }

                @Override
                public Object returnValue(Object value) {
                    return  value + "（返回）";
                }
            });
//            String str = iProDemo.println();
            iProDemo.ni();
//            System.out.println(str);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
