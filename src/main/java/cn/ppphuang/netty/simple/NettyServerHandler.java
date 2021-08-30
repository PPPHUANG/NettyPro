package cn.ppphuang.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        System.out.println("server ctx:" + ctx);
//        ByteBuf buf = (ByteBuf) msg;
//        System.out.println("client msg:" + buf.toString(CharsetUtil.UTF_8));
//        System.out.println("client address:" + ctx.channel().remoteAddress());
//    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //异步执行 nioEventLoop taskQueue
        ctx.channel().eventLoop().execute(new Thread(() -> {
            try {
                //5秒后
                Thread.sleep(5 * 1000);
                ctx.writeAndFlush(Unpooled.copiedBuffer("hello client taskQueue", CharsetUtil.UTF_8));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));

        ctx.channel().eventLoop().execute(new Thread(() -> {
            try {
                //10秒后
                Thread.sleep(5 * 1000);
                ctx.writeAndFlush(Unpooled.copiedBuffer("hello client taskQueue1", CharsetUtil.UTF_8));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        //以上两个任务都在同一个线程里执行

        //异步执行 nioEventLoop scheduleTaskQueue
        ctx.channel().eventLoop().schedule(() -> {
            ctx.writeAndFlush(Unpooled.copiedBuffer("hello client scheduleTaskQueue", CharsetUtil.UTF_8));
        }, 5, TimeUnit.SECONDS);
        //上面五秒后执行的输出 会跟第二个10秒的一起输出 因为这个已经等够了五秒
        System.out.println("task go on");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello client", CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
