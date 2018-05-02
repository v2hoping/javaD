package com.owl.zookeeper.use.spi;

import org.junit.Test;

/**
 * Created by wanghouping on 2018/5/2.
 *
 * @author houping wang
 */
public class SpiD {

    @Test
    public void test() throws ClassNotFoundException {
        Class.forName("com.owl.zookeeper.use.spi.MyMsg");
        Class.forName("com.owl.zookeeper.use.spi.YourMsg");
        IMsg my = new MsgManage().getMsgConnection("my");
        IMsg your = new MsgManage().getMsgConnection("your");
        my.send("你好，世界");
        your.send("你好，世界");
    }
}
