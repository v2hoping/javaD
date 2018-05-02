package com.owl.zookeeper.use.spi;

/**
 * Created by wanghouping on 2018/5/2.
 *
 * @author houping wang
 */
public class MyMsg implements IMsg{

    static {
        MsgManage.register("my", MyMsg.class);
    }

    public void send(String msg) {
        System.out.println("[通过MyMsg实现加载]" + msg);
    }
}
