package cn.ppphuang.netty.tcppackage;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MyMessageEncoder extends MessageToByteEncoder<Message> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Message message, ByteBuf byteBuf) throws Exception {
        System.out.println("MyMessageEncoder invoke");
        byteBuf.writeInt(message.getLen());
        byteBuf.writeBytes(message.getContent());
    }
}
