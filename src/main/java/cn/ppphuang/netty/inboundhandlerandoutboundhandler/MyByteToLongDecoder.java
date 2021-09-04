package cn.ppphuang.netty.inboundhandlerandoutboundhandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class MyByteToLongDecoder extends ByteToMessageDecoder {
    /**
     * 会被多次调用 直到确定没有新的元素被添加到list，或者byteBuf 没有更多可读字节为止
     * 如果list 不为空，就会将list的内容传递给下一个handler处理，该处理器的方法也有可能调用多次（这里只会调用两次decoder 一次handler）
     * @param channelHandlerContext
     * @param byteBuf
     * @param list
     * @throws Exception
     */
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        //long 8 byte
        System.out.println("MyByteToLongDecoder invoked");
        if (byteBuf.readableBytes() >= 8) {
            list.add(byteBuf.readLong());
        }
    }
}
