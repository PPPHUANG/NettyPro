package cn.ppphuang.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class FileChannel01 {
    public static void main(String[] args) throws IOException {
        String content = "hello ppphuang";
        FileOutputStream fileOutputStream = new FileOutputStream("file.txt");
        FileChannel channel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(content.getBytes(StandardCharsets.UTF_8));
        byteBuffer.flip();
        channel.write(byteBuffer);
        fileOutputStream.close();
    }
}
