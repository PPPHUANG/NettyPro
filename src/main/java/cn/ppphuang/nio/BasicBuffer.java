package cn.ppphuang.nio;

import java.nio.Buffer;
import java.nio.IntBuffer;

public class BasicBuffer {
    public static void main(String[] args) {
        IntBuffer allocate = IntBuffer.allocate(5);
        for (int i = 0; i < allocate.capacity(); i++) {
            allocate.put(1 * i);
        }
        allocate.flip();
        while (allocate.hasRemaining()) {
            int i = allocate.get();
            System.out.println(i);
        }
    }
}
