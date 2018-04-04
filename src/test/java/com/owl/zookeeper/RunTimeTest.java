package com.owl.zookeeper;

import org.junit.Test;
import sun.net.util.IPAddressUtil;

import java.io.IOException;

/**
 * Created by wanghouping on 2018/3/19.
 *
 * @author houping wang
 */
public class RunTimeTest {

    @Test
    public void test() {
        try {
            Process exec = Runtime.getRuntime().exec(new String[]{"notepad.exe"});
            exec.destroy();
            try {
                exec.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
