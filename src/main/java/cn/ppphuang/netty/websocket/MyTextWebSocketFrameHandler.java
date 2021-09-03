package cn.ppphuang.netty.websocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.time.LocalDateTime;

//TextWebSocketFrame这个泛型表示一个文本帧
public class MyTextWebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame msg) throws Exception {
        System.out.println("server receive" + msg.text());
        channelHandlerContext.channel().writeAndFlush(new TextWebSocketFrame("server time" + LocalDateTime.now() + " " + msg.text()));
    }

    /**
     * 客户端连接后 触发
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        //id 表示唯一值，longText是惟一的 shortText不是
        System.out.println("handlerAdded invoke" + ctx.channel().id().asLongText());
        System.out.println("handlerAdded invoke" + ctx.channel().id().asShortText());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerRemoved invoke"+ ctx.channel().id().asLongText());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("exception" + cause.getMessage());
        ctx.channel().close();
    }
}
