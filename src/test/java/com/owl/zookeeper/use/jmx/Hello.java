package com.owl.zookeeper.use.jmx;

/**
 * Created by wanghouping on 2018/5/3.
 *
 * @author houping wang
 */
public class Hello implements HelloMBean{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printlnHello() {
        System.out.println(name);
    }

    public void printlnHello(String msg) {
        System.out.println(msg);
    }
}
