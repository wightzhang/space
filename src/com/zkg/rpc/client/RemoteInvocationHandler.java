package com.zkg.rpc.client;

import com.zkg.rpc.RpcRequest;

import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*
 * created by kgzhang 2018/11/4
 */
public class RemoteInvocationHandler implements InvocationHandler {

    private String host;
    private int port;

    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest request = new RpcRequest();
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setParameters(args);
        TCPTransport tcpTransport = new TCPTransport(this.host,this.port);

        //if(Object.class.equals(method.getDeclaringClass())){
        //    return method.invoke(this,args);
        //}

        return tcpTransport.send(request);
    }
}
