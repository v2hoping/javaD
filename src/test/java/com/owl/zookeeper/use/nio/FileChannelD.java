package com.owl.zookeeper.use.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by 26383 on 2018/4/18.
 * File NIO读写
 * @author houping wang
 */
public class FileChannelD {

    public static void main(String[] args) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\githubworkspace\\javaD\\src\\main\\resources\\NioFile.txt", "rw");
            FileChannel channel = randomAccessFile.getChannel();
            ByteBuffer bf = ByteBuffer.allocate(32);
            int bytesRead = channel.read(bf);
            while(bytesRead != -1) {
                byte[] bytes = new byte[bytesRead];
                System.out.println("长度：" + bytesRead);
                bf.flip();
                while(bf.hasRemaining()) {
//                    bf.get(bytes);
//                    System.out.println(new String(bytes, "utf-8"));
                    System.out.println((char)bf.get());
                }
                bf.clear();
                bytesRead = channel.read(bf);
            }
            randomAccessFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }
    }

}