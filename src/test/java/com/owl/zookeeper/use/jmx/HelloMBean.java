package com.owl.zookeeper.use.jmx;

/**
 * Created by wanghouping on 2018/5/3.
 *
 * @author houping wang
 */
public interface HelloMBean {

    String getName();

    void setName(String name);

    void printlnHello();

    void printlnHello(String msg);
}
