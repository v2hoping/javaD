package com.owl.zookeeper.use.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by wanghouping on 2018/4/24.
 *
 * @author houping wang
 */
public class HandleProxy implements InvocationHandler {

    private IProDemo iProDemo;

    public HandleProxy(IProDemo iProDemo) {
        this.iProDemo = iProDemo;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("println")) {
            System.out.println("制定方法");
        }else{
            System.out.println(method.getName());
        }
        return "dd";
    }

//        public abstract void before(Object proxy, Method method, Object[] args);
//
//        public abstract void after(Object proxy, Method method, Object[] args);
//
//        public abstract Object returnValue(Object value);
}
