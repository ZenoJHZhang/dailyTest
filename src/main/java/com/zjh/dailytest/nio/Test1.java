package com.zjh.dailytest.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

/**
 * http://ifeve.com/buffers/
 *
 * @author 张江浩
 * @version 1.00
 * @date 2019/4/24 14:32
 */
public class Test1 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("C:\\Users\\ucmed\\Desktop\\sql.txt", "rw");
        FileChannel channel = randomAccessFile.getChannel();

        //缓冲区大小
        ByteBuffer buf = ByteBuffer.allocate(48);

        // -1 时说明所有数据已读取完毕
        int bytesRead = channel.read(buf);
        while (bytesRead != -1) {
            buf.flip();
            // position < limit
            while(buf.hasRemaining()){
                System.out.println(buf.get());
            }
            //清空缓存区，为下一次的管道写入至缓存做准备
            buf.clear();
            bytesRead = channel.read(buf);
        }
        //关闭管道
        channel.close();
    }
}
