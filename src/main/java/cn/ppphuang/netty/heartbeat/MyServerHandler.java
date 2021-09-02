package cn.ppphuang.netty.heartbeat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;

public class MyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateHandler) {
            IdleStateEvent event = (IdleStateEvent) evt;
            String eventType = null;
            switch (event.state()) {
                case READER_IDLE:
                    eventType = "read free";
                    break;
                case WRITER_IDLE:
                    eventType = "write free";
                    break;
                case ALL_IDLE:
                    eventType = "add free";
                    break;
            }
            System.out.println(ctx.channel().remoteAddress() + "--timeout--" + eventType);
            System.out.println("server do something");
            ctx.channel().close();
        }
    }
}
