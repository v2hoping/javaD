package com.owl.zookeeper.use.enumD;

/**
 * Created by wanghouping on 2018/4/9.
 *
 * @author houping wang
 */
public enum Student {

    A("wang"),B("hou"),C("ping");

    private String name;

    Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
