package cn.ppphuang.netty.inboundhandlerandoutboundhandler;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class MyClientHandler extends SimpleChannelInboundHandler<Long> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Long aLong) throws Exception {
        System.out.println("read from client" + channelHandlerContext.channel().remoteAddress() +" " + aLong);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyClientHandler send ");
        //不是long类型的数据不会调用 MyLongToByteEncoder
//        ctx.writeAndFlush(Unpooled.copiedBuffer("abcdabcdabcd", CharsetUtil.UTF_8));
        //是long类型的数据不会调用 MyLongToByteEncoder
        ctx.writeAndFlush(123456L);
    }
}
