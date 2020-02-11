package com.zjh.daily_test.file;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 类的说明
 *
 * @author 张江浩
 * @version 1.00
 * @date 2020/2/11 16:19
 */
public class BlockClient {
    public static void main(String[] args) throws IOException {
        //socketChannel客户端
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 6666));
        FileChannel fileChannel = FileChannel.open(Paths.get("E:\\true.jpg"), StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(48);

        while (fileChannel.read(buffer) != -1){
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }

        fileChannel.close();
        socketChannel.close();
    }
}
