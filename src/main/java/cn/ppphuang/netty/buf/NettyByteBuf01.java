package cn.ppphuang.netty.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class NettyByteBuf01 {
    public static void main(String[] args) {
        //1.创建对象，包含一个数组arr，是一个byte[10]
        //2. 在netty中ByteBuf 不需要flip 因为维护了 readerindex writerindex
        //3.  readerindex writerindex capacity 将buf分成3个区域
        //  readerindex writerindex 可读区域
        //  writerindex capacity 可写区域
        ByteBuf buffer = Unpooled.buffer(10);
        for (int i = 0; i < 10; i++) {
            buffer.writeByte(i);
        }
        for (int i = 0; i < buffer.capacity(); i++) {
            //不会修改readerindex
            System.out.println(buffer.getByte(i));
        }
        for (int i = 0; i < buffer.capacity(); i++) {
            //会修改readerindex
            System.out.println(buffer.readByte());
        }
    }
}
