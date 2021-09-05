package cn.ppphuang.netty.tcppackage;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

public class MyMessageDecoder extends ReplayingDecoder<Void> {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        System.out.println("MyMessageDecoder invoke");
        int i = byteBuf.readInt();
        byte[] bytes = new byte[i];
        byteBuf.readBytes(bytes);
        Message message = new Message();
        message.setLen(i);
        message.setContent(bytes);
        list.add(message);
    }
}
