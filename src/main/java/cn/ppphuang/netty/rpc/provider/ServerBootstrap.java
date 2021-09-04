package cn.ppphuang.netty.rpc.provider;

import cn.ppphuang.netty.rpc.netty.NettyServer;

public class ServerBootstrap {
    public static void main(String[] args) throws InterruptedException {
        NettyServer.startServer("127.0.0.1", 7000);
    }
}
