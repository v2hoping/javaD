package com.owl.zookeeper.use.ioc;

/**
 * Created by wanghouping on 2018/5/14.
 *
 * @author houping wang
 */
public interface ApplicationContext {

    /**
     * 获得指定名称Bean
     * @param name 名称
     * @return Bean
     */
    Object getBean(String name);
}
