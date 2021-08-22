package cn.ppphuang.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannel04 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("file.txt");
        FileChannel inputChannel = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream("file2.txt");
        FileChannel outputChannel = fileOutputStream.getChannel();
        outputChannel.transferFrom(inputChannel,0,inputChannel.size());
        inputChannel.close();
        outputChannel.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
