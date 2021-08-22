package cn.ppphuang.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannel03 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("file.txt");
        FileChannel inputChannel = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream("file1.txt");
        FileChannel outputChannel = fileOutputStream.getChannel();
        ByteBuffer allocate = ByteBuffer.allocate(10);
        while (true) {
            //不clear position 与 limit相等会返回0 就会死循环
            allocate.clear();
            int read = inputChannel.read(allocate);
            if (read == -1) {
                break;
            }
            allocate.flip();
            outputChannel.write(allocate);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
