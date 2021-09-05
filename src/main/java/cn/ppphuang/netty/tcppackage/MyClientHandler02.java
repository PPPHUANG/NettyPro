package cn.ppphuang.netty.tcppackage;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.nio.charset.StandardCharsets;


public class MyClientHandler02 extends SimpleChannelInboundHandler<Message> {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //连续发送可能会粘包
        for (int i = 0; i < 10; i++) {
            String msg = "hello server";
            byte[] bytes = msg.getBytes(StandardCharsets.UTF_8);
            int length = bytes.length;
            Message message = new Message();
            message.setLen(length);
            message.setContent(bytes);
            ctx.writeAndFlush(message);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Message message) throws Exception {

    }
}
