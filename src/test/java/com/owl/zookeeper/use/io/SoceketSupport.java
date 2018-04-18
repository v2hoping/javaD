package com.owl.zookeeper.use.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wanghouping on 2018/4/18.
 *
 * @author houping wang
 */
public class SoceketSupport {

    private static final String ip = "127.0.0.1";

    private static final Integer port = 1234;

    interface ServerHandle {
        /**
         * 处理报文数据.
         * @param message 报文数据
         * @return 返回处理后数据
         */
        String handleMessage(String message);

        /**
         * 读取数据
         * @return 返回读取的数据
         */
        void read();

        /**
         * 处理和输出数据
         */
        void handleAndWrite(String message);

        /**
         * 设置结束退出条件.
         * @return 是否退出 true:是 false:否
         */
        Boolean end();

    }

    interface Client {

        void send();

    }

    public static class MeServer{

        private static final ExecutorService executorService = Executors.newFixedThreadPool(2);

        public static void startListen(Integer port, Integer threadType) {
            try {
                //创建监听
                ServerSocket ss = new ServerSocket(port);
                while(true) {
                    //启动监听
                    Socket socket = ss.accept();
                    //创建线程
                    if(threadType.equals(0)) {
                        new MeServerHandle(socket).run();
                    }else{
                        executorService.execute(new MeServerHandle(socket));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class MeServerHandle implements ServerHandle, Runnable {

        private Socket sk = null;

        private BufferedReader br = null;

        private PrintWriter pw = null;

        public MeServerHandle(Socket sk) {
            this.sk = sk;
            try {
                this.br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
                this.pw = new PrintWriter(sk.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String handleMessage(String message) {
            return "[服务端][报文数据：" + message +"]";
        }

        public void read() {
            String message = null;
            try {
                while(true) {
                    if((message = br.readLine()) == null) break;
                    System.out.println("[服务器端]接收到：" + message);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handleAndWrite(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                closeAll();
            }
        }

        public void handleAndWrite(String message) {
            String returnMessage = handleMessage(message);
            System.out.println("[服务器端]回复：" + returnMessage);
            pw.println(returnMessage);
            pw.flush();
        }

        public Boolean end() {
            return null;
        }

        public void closeAll() {
            //一下必要的清理工作
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                br = null;
            }
            if(pw != null){
                pw.close();
                pw = null;
            }
            if(sk != null){
                try {
                    sk.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sk = null;
            }
        }

        public void run() {
            read();
        }
    }

    public static class MeClient implements Client, Runnable{

        private Socket sk = null;

        private BufferedReader br = null;

        private PrintWriter pw = null;

        private String ip;

        private Integer port;

        private String name = "defaultName";

        public MeClient(String name) {
            this.init(SoceketSupport.ip, SoceketSupport.port);
            this.name = name;
        }

        public MeClient(String ip, Integer port) {
            init(ip, port);
        }

        public MeClient() {
            this.init(SoceketSupport.ip, SoceketSupport.port);
        }

        public void init(String ip, Integer port) {
            try {
                this.sk = new Socket(ip, port);
                this.br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
                this.pw = new PrintWriter(sk.getOutputStream());
                this.ip = ip;
                this.port = port;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void send(String str) {
            try {
                String sendStr = name + ":" + str;
                System.out.println("[客户端]发送：" + sendStr);
                pw.println(sendStr);
                pw.flush();
                System.out.println("[客户端]接收回执：" + br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                closeAll();
            }
        }

        public void send() {
            send("测试使用");
        }

        public void closeAll() {
            //一下必要的清理工作
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                br = null;
            }
            if(pw != null){
                pw.close();
                pw = null;
            }
            if(sk != null){
                try {
                    sk.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sk = null;
            }
        }

        public void run() {
            this.send();
        }
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                MeServer.startListen(SoceketSupport.port, 0);
            }
        }).start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < 100; i ++) {
            new Thread(new MeClient("Client" + i)).start();
        }
    }

}
