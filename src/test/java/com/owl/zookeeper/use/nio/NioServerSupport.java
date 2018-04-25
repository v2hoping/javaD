package com.owl.zookeeper.use.nio;

import com.owl.zookeeper.use.io.SoceketSupport;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * Created by wanghouping on 2018/4/23.
 * NIO服务端.
 * @author houping wang
 */
public class NioServerSupport {

    private static final Integer DEFAULT_PORT = 1235;

    public interface ServerFace{

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

        public Server(Integer port) {
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
            serverSocketChannel.socket().bind(new InetSocketAddress(port), 1024);
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
            try {
                while (started) {
                    selector.select(1000);
                    Set<SelectionKey> keys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = keys.iterator();
                    SelectionKey selectionKey;
                    while (iterator.hasNext()) {
                        selectionKey = iterator.next();
                        iterator.remove();
                        selectionKeyHandle(selectionKey);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                closeAll();
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

        private void selectionKeyHandle(SelectionKey selectionKey) throws IOException {
            if(selectionKey.isValid()) {
                if(selectionKey.isAcceptable()){
                    ServerSocketChannel ssc = (ServerSocketChannel) selectionKey.channel();
                    //通过ServerSocketChannel的accept创建SocketChannel实例
                    //完成该操作意味着完成TCP三次握手，TCP物理链路正式建立
                    SocketChannel sc = ssc.accept();
                    //设置为非阻塞的
                    sc.configureBlocking(false);
                    //注册为读
                    sc.register(selector, SelectionKey.OP_READ);
                    System.out.println("服务端建立客户端连接成功");
                }
                if(selectionKey.isReadable()) {
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    ByteBuffer allocate = ByteBuffer.allocate(1024);
                    int readLength = channel.read(allocate);
                    if(readLength > 0) {
                        allocate.flip();
                        byte[] bytes = new byte[allocate.remaining()];
                        allocate.get(bytes);
                        String str = new String(bytes, "UTF-8");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("[服务端]收到用户消息:" + str);
                        doWrite(channel, str);
                    }else if(readLength == 0) {
                    }else{
                        channel.close();
                        selectionKey.cancel();
                    }
                }
            }
        }

        //异步发送应答消息
        private void doWrite(SocketChannel channel,String response) throws IOException{
            String responseResult = response + "(服务端应答)";
            //将消息编码为字节数组
            byte[] bytes = responseResult.getBytes();
            //根据数组容量创建ByteBuffer
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            //将字节数组复制到缓冲区
            writeBuffer.put(bytes);
            //flip操作
            writeBuffer.flip();
            //发送缓冲区的字节数组
            channel.write(writeBuffer);
            //****此处不含处理“写半包”的代码
        }

        public void run() {
            listener();
        }

        public void stop(){
            started = false;
        }
    }

    public static class MeServer {
        private static int DEFAULT_PORT = 1235;
        private static Server serverHandle;
        public static void start(){
            start(DEFAULT_PORT);
        }
        public static synchronized void start(Integer port){
            if(serverHandle!=null)
                serverHandle.stop();
            serverHandle = new Server(port);
            new Thread(serverHandle,"Server").start();
        }
        public static void main(String[] args){
            start();
        }
    }

    public static class MeClient {
        private static String DEFAULT_HOST = "127.0.0.1";
        private static int DEFAULT_PORT = 1235;
        private static Client clientHandle;
        public static void start(){
            start(DEFAULT_HOST,DEFAULT_PORT);
        }
        public static synchronized void start(String ip,int port){
            if(clientHandle!=null)
                clientHandle.stop();
            clientHandle = new Client(ip,port);
            new Thread(clientHandle,"Server").start();
        }
        //向服务器发送消息
        public static boolean sendMsg(String msg) throws Exception{
            while(!clientHandle.sendMsg(msg)) {
                System.out.println("未准备好");
            }
            return true;
        }
        public static void main(String[] args){
            start();
        }
    }

    public static class MeClient2 {
        private static String DEFAULT_HOST = "127.0.0.1";
        private static int DEFAULT_PORT = 1235;
        private static Client clientHandle;
        public static void start(){
            start(DEFAULT_HOST,DEFAULT_PORT);
        }
        public static synchronized void start(String ip,int port){
            if(clientHandle!=null)
                clientHandle.stop();
            clientHandle = new Client(ip,port);
            new Thread(clientHandle,"Server").start();
        }
        //向服务器发送消息
        public static boolean sendMsg(String msg) throws Exception{
            while(!clientHandle.sendMsg(msg)) {
                Thread.sleep(100);
                System.out.println("未准备好");
            }
            return true;
        }
        public static void main(String[] args){
            start();
        }
    }

    public static class Client implements Runnable{
        private String host;
        private int port;
        private Selector selector;
        private SocketChannel socketChannel;
        private volatile boolean started;
        private volatile boolean isConnect  = false;

        public Client(String ip,int port) {
            this.host = ip;
            this.port = port;
            try{
                //创建选择器
                selector = Selector.open();
                //打开监听通道
                socketChannel = SocketChannel.open();
                //如果为 true，则此通道将被置于阻塞模式；如果为 false，则此通道将被置于非阻塞模式
                socketChannel.configureBlocking(false);//开启非阻塞模式
                started = true;
            }catch(IOException e){
                e.printStackTrace();
                System.exit(1);
            }
        }

        public void stop(){
            started = false;
        }

        public void run() {
            try{
                doConnect();
            }catch(IOException e){
                e.printStackTrace();
                System.exit(1);
            }
            //循环遍历selector
            while(started){
                try{
                    //无论是否有读写事件发生，selector每隔1s被唤醒一次
                    selector.select(1000);
                    //阻塞,只有当至少一个注册的事件发生的时候才会继续.
//              selector.select();
                    Set<SelectionKey> keys = selector.selectedKeys();
                    Iterator<SelectionKey> it = keys.iterator();
                    SelectionKey key = null;
                    while(it.hasNext()){
                        key = it.next();
                        it.remove();
                        try{
                            handleInput(key);
                        }catch(Exception e){
                            if(key != null){
                                key.cancel();
                                if(key.channel() != null){
                                    key.channel().close();
                                }
                            }
                        }
                    }
                }catch(Exception e){
                    e.printStackTrace();
                    System.exit(1);
                }
            }
            //selector关闭后会自动释放里面管理的资源
            if(selector != null)
                try{
                    selector.close();
                }catch (Exception e) {
                    e.printStackTrace();
                }
        }
        private void handleInput(SelectionKey key) throws IOException{
            if(key.isValid()){
                SocketChannel sc = (SocketChannel) key.channel();
                if(key.isConnectable()){
                    if(sc.finishConnect()) {
                        isConnect = true;
                        System.out.println("客户端连接成功");
                    }
                    else System.exit(1);
                }
                //读消息
                if(key.isReadable()){
                    //创建ByteBuffer，并开辟一个1M的缓冲区
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    //读取请求码流，返回读取到的字节数
                    int readBytes = sc.read(buffer);
                    //读取到字节，对字节进行编解码
                    if(readBytes>0){
                        //将缓冲区当前的limit设置为position=0，用于后续对缓冲区的读取操作
                        buffer.flip();
                        //根据缓冲区可读字节数创建字节数组
                        byte[] bytes = new byte[buffer.remaining()];
                        //将缓冲区可读字节数组复制到新建的数组中
                        buffer.get(bytes);
                        String result = new String(bytes,"UTF-8");
                        System.out.println("[客户端]收到消息：" + result);
//                        doWrite(sc, result);
                    }
                    //没有读取到字节 忽略
//              else if(readBytes==0);
                    //链路已经关闭，释放资源
                    else if(readBytes<0){
                        key.cancel();
                        sc.close();
                    }
                }
            }
        }
        //异步发送消息
        private void doWriteRandom(SocketChannel channel,String request) throws IOException{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Random random = new Random();
            if(random.nextBoolean()) {
                doWrite(channel, request);
            }else {
                System.out.println("发送客户端终止应答" + request);
            }
        }

        private void doWrite(SocketChannel channel,String request) throws IOException{
            //将消息编码为字节数组
            byte[] bytes = request.getBytes();
            //根据数组容量创建ByteBuffer
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            //将字节数组复制到缓冲区
            writeBuffer.put(bytes);
            //flip操作
            writeBuffer.flip();
            //发送缓冲区的字节数组
            channel.write(writeBuffer);
            //****此处不含处理“写半包”的代码
        }

        private void doConnect() throws IOException{
            if(socketChannel.connect(new InetSocketAddress(host,port)));
            else socketChannel.register(selector, SelectionKey.OP_CONNECT);
        }
        public boolean sendMsg(String msg) throws Exception{
            if(!isConnect) {
                return false;
            }
            socketChannel.register(selector, SelectionKey.OP_READ);
            doWrite(socketChannel, msg);
            return true;
        }
    }

    public static void main(String[] args) {
        MeServer.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MeClient.start();
        MeClient2.start();
        try {
            MeClient.sendMsg("王厚平");
            MeClient2.sendMsg("校长");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
