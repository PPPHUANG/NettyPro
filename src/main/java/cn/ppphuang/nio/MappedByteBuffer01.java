package cn.ppphuang.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedByteBuffer01 {
    public static void main(String[] args) throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("file.txt","rw");
        FileChannel channel = randomAccessFile.getChannel();
        //模式 映射开始位置 映射数量
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        map.put(1,(byte) 'P');
        map.put(3,(byte) 'H');
        //IndexOutOfBoundsException
//        map.put(5,(byte) 'P');
        randomAccessFile.close();
        System.out.println("closed");
    }
}
