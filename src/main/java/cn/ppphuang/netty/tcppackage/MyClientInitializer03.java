package cn.ppphuang.netty.tcppackage;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

public class MyClientInitializer03 extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast(new LengthFieldBasedFrameDecoder(4096, 0, 4, 0, 4));
        pipeline.addLast(new LengthEncoder());
        pipeline.addLast(new MyClientHandler());
    }
}
