package cn.ppphuang.netty.tcppackage;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;


//本类作用,加上四个字节的消息头(int类型),表示数据包长度
public class LengthEncoder extends MessageToByteEncoder<ByteBuf> {
    @Override
    protected void encode(ChannelHandlerContext ctx, ByteBuf msg, ByteBuf out) throws Exception {
        int length = msg.readableBytes();
        byte[] bytes = new byte[length];
        msg.readBytes(bytes);
        out.writeInt(length);
        out.writeBytes(bytes);
    }
}
