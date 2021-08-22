package cn.ppphuang.nio;

import java.nio.ByteBuffer;

public class BufferReadOnly {
    public static void main(String[] args) {
        ByteBuffer allocate = ByteBuffer.allocate(50);
        allocate.putInt(1);
        allocate.flip();
        System.out.println(allocate.getInt());
        ByteBuffer byteBuffer = allocate.asReadOnlyBuffer();
        //java.nio.ReadOnlyBufferException
        byteBuffer.putInt(1);
    }
}
