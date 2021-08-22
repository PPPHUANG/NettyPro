package cn.ppphuang.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class FileChannel02 {
    public static void main(String[] args) throws IOException {
        File file = new File("file.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
        int read = channel.read(byteBuffer);
        byteBuffer.flip();
        fileInputStream.close();
        System.out.println(new String(byteBuffer.array()));
    }
}
