package cn.ppphuang.netty.rpc.customer;

import cn.ppphuang.netty.rpc.construct.HelloService;
import cn.ppphuang.netty.rpc.netty.NettyClient;

public class ClientBootStrap {
    public static final String providerName = "HelloService#hello#";

    public static void main(String[] args) {
        //创建消费者
        NettyClient customer = new NettyClient();
        //获取代理对象
        HelloService service = (HelloService) customer.getBean(HelloService.class, providerName);
        //调用方法
        String res = service.hello("hello server");
        System.out.println(res);
    }
}
