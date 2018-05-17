package com.owl.zookeeper.use.chain;

import org.junit.Test;

/**
 * Created by wanghouping on 2018/5/14.
 *
 * @author houping wang
 */
public class Chain {

    public static abstract class Handler {

        protected Handler handler;

        /**
         * 插入任务
         * @param handler 任务
         */
        public Handler add(Handler handler) {
            handler.setHandler(this);
            return handler;
        }

        public void setHandler(Handler handler) {
            this.handler = handler;
        }

        public abstract void handler(int i);

    }

    @Test
    public void test() {
        new Chain.Handler() {
            @Override
            public void handler(int i) {
                System.out.println("第一个" + i);
                if(handler != null) {
                    this.handler.handler(i);
                }
            }
        }.add(new Handler() {
            @Override
            public void handler(int i) {
                System.out.println("第二个" + i);
                if(handler != null) {
                    this.handler.handler(i);
                }
            }
        }).add(new Handler() {
            @Override
            public void handler(int i) {
                System.out.println("第三个" + i);
                if(handler != null) {
                    this.handler.handler(i);
                }
            }
        }).handler(1);
    }
}
