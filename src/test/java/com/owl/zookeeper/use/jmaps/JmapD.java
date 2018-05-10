package com.owl.zookeeper.use.jmaps;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghouping on 2018/5/10.
 *
 * @author houping wang
 */
public class JmapD{

    private static final List<AAAAAAAAAA> list = new ArrayList<AAAAAAAAAA>();

    public static void main(String[] args) {
        new Thread(new Runnable() {

            private final String a = "王厚平";

            public void run() {
                System.out.println("启动");
                try {
                    Thread.sleep(1000 * 60 * 60);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "xiaopingping").start();
        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(name);
        String pid = name.split("@")[0];
        System.out.println("Pid is:" + pid);
        for(int i = 0; i < 100; i ++) {
            list.add(new AAAAAAAAAA("whp", 1));
            list.add(new AAAAAAAAAA("whp", 2));
            list.add(new AAAAAAAAAA("whp", 3));
            list.add(new AAAAAAAAAA("whp", 4));
            list.add(new AAAAAAAAAA("whp", 5));
            list.add(new AAAAAAAAAA("whp", 6));
        }
        try {
            Thread.sleep(1000 * 60 * 60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
