package cn.ppphuang.netty.rpc.provider;

import cn.ppphuang.netty.rpc.construct.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String mes) {
        System.out.println("receive message:" + mes);
        if (mes != null) {
            return "hello client , receive message [" + mes + "]";
        } else {
            return "hello client , receive message";
        }
    }
}
