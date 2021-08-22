package cn.ppphuang.nio;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class BasicBufferGetPut {
    public static void main(String[] args) {
        ByteBuffer allocate = ByteBuffer.allocate(50);
        allocate.putInt(1);
        allocate.putShort((short) 2);
        allocate.putChar('p');
        allocate.flip();
        System.out.println(allocate.getInt());
        System.out.println(allocate.getShort());
        System.out.println(allocate.getChar());
        //java.nio.BufferUnderflowException 写什么类型 读什么类型 不然可能会异常
//        System.out.println(allocate.getLong());
    }
}
