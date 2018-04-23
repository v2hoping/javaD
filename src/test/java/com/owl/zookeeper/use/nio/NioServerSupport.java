package com.owl.zookeeper.use.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by wanghouping on 2018/4/23.
 * NIO服务端.
 * @author houping wang
 */
public class NioServerSupport {

    private static final Integer DEFAULT_PORT = 1235;

    public interface ServerFace{

        /**
         * 启动监听.
         */
        void start();

        /**
         * 启动监听制定端口.
         * @param port port
         */
        void start(Integer port) throws IOException;

    }

    public interface ServerHandleFace {

        /**
         * 处理数据.
         * 接受请求报文，添加服务器标识，并返回.
         */
        void handle();
    }

    public static class Server implements ServerFace, Runnable{

        private Integer port = null;

        private ServerSocketChannel serverSocketChannel = null;

        private Selector selector = null;

        private Boolean started = false;

        public void start() {
            start(DEFAULT_PORT);
        }

        public void start(Integer port) {
            this.port = port;
            try {
                bind();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void bind() throws IOException {
            //创建选择器、管道
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            //绑定监听端口
            serverSocketChannel.socket().bind(new InetSocketAddress(port));
            //设置异步
            serverSocketChannel.configureBlocking(false);
            //注册选择器的连接事件
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            //设置启动
            started = true;
            System.out.println("[服务端]绑定监听端口，初始化完成");
        }

        private void listener() {
            System.out.println("[服务端]监听启动");
            while(started) {
                try {
                    selector.select(1000);
                    Set<SelectionKey> keys = selector.keys();
                    Iterator<SelectionKey> iterator = keys.iterator();
                    SelectionKey selectionKey;
                    while(iterator.hasNext()) {
                        selectionKey = iterator.next();

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    closeAll();
                }
            }
            System.out.println("[服务端]监听结束");
        }

        private void closeAll() {
            try {
                started = false;
                if(null != serverSocketChannel) {
                    serverSocketChannel.close();
                }
                if(null != selector) {
                    selector.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {

        }
    }


}
