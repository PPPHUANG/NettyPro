package cn.ppphuang.netty.inboundhandlerandoutboundhandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

public class MyByteToLongDecoder02 extends ReplayingDecoder<Void> {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        //long 8 byte
        System.out.println("MyByteToLongDecoder02 invoked");
        // ReplayingDecoder 无需判断可读长度
//        if (byteBuf.readableBytes() >= 8) {
            list.add(byteBuf.readLong());
//        }
    }
}
