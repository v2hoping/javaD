package com.owl.zookeeper.use.adapter;

import org.junit.Test;

/**
 * Created by wanghouping on 2018/5/14.
 *
 * @author houping wang
 */
public class Client {

    @Test
    public void test() {
        Target languageAdapter = new LanguageAdapter(new China());
        languageAdapter.said();
    }
}
