package com.owl.zookeeper.use.adapter;

/**
 * Created by wanghouping on 2018/5/14.
 *
 * @author houping wang
 */
public class LanguageAdapter implements Target{

    private ChinaTarget chinaTarget;

    public LanguageAdapter(ChinaTarget chinaTarget) {
        this.chinaTarget = chinaTarget;
    }

    public void said() {
        chinaTarget.saidChina();
    }
}
