package com.zkg.rpc.client;

import com.zkg.rpc.IHelloService;

/*
 * created by kgzhang 2018/11/4
 */
public class ClientDemo {
    public static void main(String[] args) {
        IHelloService helloService =
                new RpcClientProxy().clientProxy(IHelloService.class,"127.0.0.1",8888);
        System.out.println(helloService.sayHello("kgzhang"));
        //System.out.println(helloService.toString());
    }
}
