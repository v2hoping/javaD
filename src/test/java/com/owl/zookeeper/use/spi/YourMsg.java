package com.owl.zookeeper.use.spi;

/**
 * Created by wanghouping on 2018/5/2.
 *
 * @author houping wang
 */
public class YourMsg implements IMsg{

    static {
        MsgManage.register("your", YourMsg.class);
    }

    public void send(String msg) {
        System.out.println("[通过YourMsg实现加载]" + msg);
    }
}
