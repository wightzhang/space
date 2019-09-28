package com.zkg.rpc.Server;

import com.zkg.rpc.IHelloService;

/*
 * created by kgzhang 2018/11/4
 */
public class HelloServiceImpl implements IHelloService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
