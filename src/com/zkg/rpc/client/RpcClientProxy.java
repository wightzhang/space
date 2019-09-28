package com.zkg.rpc.client;

import java.lang.reflect.Proxy;

/*
 * created by kgzhang 2018/11/4
 */
public class RpcClientProxy {

    public <T> T clientProxy(final Class<T> interfaceCls,final String host,final int port){
        return (T)Proxy.newProxyInstance(
                interfaceCls.getClassLoader(),new Class[]{interfaceCls},new RemoteInvocationHandler(host,port));
    }
}
