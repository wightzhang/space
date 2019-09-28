package com.zkg.rpc.Server;

import com.zkg.rpc.IHelloService;

import java.io.IOException;

/*
 * created by kgzhang 2018/11/4
 */
public class ServerDemo {

    public static void main(String[] args) {
        RpcServer rpcServer = new RpcServer();
        try {
            rpcServer.publisher(new HelloServiceImpl(),8888);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
