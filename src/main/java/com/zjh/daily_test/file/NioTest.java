package com.zjh.daily_test.file;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * 类的说明
 *
 * @author 张江浩
 * @version 1.00
 * @date 2020/1/21 13:15
 */
public class NioTest {
    private static String FILE_PATH = "E:\\project\\1.txt";


    public static void main(String[] args) throws IOException {
        test03();
    }

    public static void test01() throws IOException {
        RandomAccessFile aFile = new RandomAccessFile(FILE_PATH, "rw");
        FileChannel channel = aFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(48);
        buffer.clear();
        String newData = "1234253464537567";
        buffer.put(newData.getBytes());

        //重置buffer 1.写数据到buffer => 读buffer数据到channel ； 2.channel读数据到buffer中=> 输出buffer中的数据
        buffer.flip();

        while (buffer.hasRemaining()){
            channel.write(buffer);
        }

        System.out.println(channel.position());
        channel.close();
    }

    public static void test02() throws IOException {
        RandomAccessFile aFile = new RandomAccessFile(FILE_PATH, "rw");
        FileChannel channel = aFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(48);
        int read = channel.read(buffer);

        buffer.flip();

        while (read != -1){
            while (buffer.hasRemaining()){
                System.out.println((char)buffer.get());
                read = channel.read(buffer);
            }
        }

        channel.close();
    }

    public static void test03() throws IOException{
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("http://www.baidu.com", 80));
        if (socketChannel.isConnected()){
            ByteBuffer bufferedReader = ByteBuffer.allocate(48);

            int read = socketChannel.read(bufferedReader);

            bufferedReader.flip();

            while (read != -1){
                while (bufferedReader.hasRemaining()){
                    System.out.println((char)bufferedReader.get());
                    read = socketChannel.read(bufferedReader);
                }
            }
        }

        socketChannel.close();

    }


}
